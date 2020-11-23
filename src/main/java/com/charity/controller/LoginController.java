package com.charity.controller;

import com.charity.entity.Role;
import com.charity.entity.User;
import com.charity.entity.UserRole;
import com.charity.model.AuthToken;
import com.charity.model.ConstantKit;
import com.charity.service.RoleService;
import com.charity.service.UserService;
import com.charity.utils.Md5TokenGenerator;
import com.charity.utils.RandomValidateCode;
import com.charity.utils.RedisUtils;
import com.charity.utils.SendSms;
import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    RoleService roleService;

    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("middle")
    public ModelAndView middle() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("middle");
        return mv;
    }

    @RequestMapping("loginchecks")
    @ResponseBody
    public String logincheck(String Username, String Upassword, String checks, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();

        User user = new User();

        user.setUpassword(Upassword);

        user.setUsername(Username);

        // 从session中获取随机数
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");

        User user1 = userService.SelectUPw(user);
        if (user1 != null && !random.equalsIgnoreCase(checks)) {
            return "2"; //验证码错误
        } else if (user1 != null && random.equalsIgnoreCase(checks)) {
            String uname = user1.getUname();
            String AuthUsername = user1.getUsername() + "Auth";
            Integer uid = user1.getUid();
            if (redisUtils.get(uname) == null) {
                redisUtils.set(AuthUsername, "Auth");
                redisUtils.expire(AuthUsername, ConstantKit.Auth_EXPIRE_TIME);
            } else {
                redisUtils.remove(user1.getUsername());
                redisUtils.remove(uname);
                redisUtils.set(AuthUsername, null);
                return "4";
            }
            redisUtils.set(uname, uid);

            Role role = userService.checkRole(uid);

            session.setAttribute("permisssionlevel", role.getPermissionlevel());

            session.setAttribute("Uid", uid);

            String token = tokenGenerator.generate(user1.getUsername(), user1.getUpassword());

            redisUtils.set(user.getUsername(), token);

            //设置key生存时间，当key过期时，它会被自动删除，时间是秒
            redisUtils.expire(user1.getUsername(), ConstantKit.TOKEN_EXPIRE_TIME);

            redisUtils.set(token, user1.getUsername());

            redisUtils.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);

            Long currentTime = System.currentTimeMillis();

            redisUtils.set(token + user1.getUsername(), currentTime.toString());

            String name = (String) redisUtils.get(token);

            session.setAttribute("username", user1.getUsername());

            session.setAttribute("httpHeaderName", token);

            return "1";  //登陆成功
        } else {
            return "3"; // 密码错误
        }
    }

    //处理注册用户
    @RequestMapping("adduser")
    @ResponseBody
    public String adduser(String username, String pass, String Usex,
                          String email, String mobile, String address,
                          String province, String nicename, String city, String area) throws IOException {
        if (userService.SelectUsername(username) != null) {
            return "2";     // 用户名已被注册
        } else {
            String flag = province + city + area + address;
            address = flag;
            Date date = new Date();
            Timestamp datetime = new Timestamp(date.getTime()); //2013-01-14 22:45:36.484
            User user = new User();
            switch (Usex) {
                case "1":
                    Usex = "男";
                    break;
                case "2":
                    Usex = "女";
                    break;
            }
            user.setUimage("/static/images/noimage.jpg");
            user.setUsername(username);
            user.setUpassword(pass);
            user.setUsex(Usex);
            user.setUDatetime(datetime);
            user.setUaddress(address);
            user.setUemail(email);
            user.setUiphone(mobile);
            user.setUname(nicename);
            Boolean flag1 = userService.addUser(user);
            UserRole userRole = new UserRole();
            userRole.setRoleid(5);
            userRole.setUserid(user.getUid());
            Boolean flag2 = roleService.adduserrole(userRole);
            if (flag1 && flag2) {
                return "1";     // 添加用户成功
            } else {
                return "3";     // 添加用户失败
            }
        }
    }

    @RequestMapping(value = "sendme", method = RequestMethod.POST)
    @ResponseBody
    public String sendme(String username, String mobile, HttpServletRequest request) throws HttpException, IOException {
        User user = new User();
        user.setUsername(username);
        user.setUiphone(mobile);
        Boolean flag = userService.SelectUPhone(user);
        if (flag) {
            HashMap<String, String> hashMap = SendSms.getMessageStatus(mobile);
            String result = hashMap.get("result");
            if (result.trim().equals("1")) {
                String code = hashMap.get("code");
                HttpSession session = request.getSession();
                session.setAttribute(mobile + "code", code);
                session.setMaxInactiveInterval(60 * 5);
                return "1";     // 验证码发送成功
            } else {
                return "2";     // 验证码发送失败
            }
        } else {
            return "3";         // 用户名或手机号码错误
        }
    }

    @RequestMapping(value = "comparecode", method = RequestMethod.POST)
    @ResponseBody
    public String comparecode(String username, String mobile, String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute(mobile + "code");
        if (sessionCode != null && code.equals(sessionCode)) {
            // 把comparecode放进session，用于判断请求修改密码页面时是否通过了手机验证
            session.setAttribute("comparecode", "1");
            session.setAttribute("username", username);   // 把修改密码的用户名放进session
            return "1";     // 验证码正确
        } else if (sessionCode != null && !code.equals(sessionCode)) {
            return "2";     // 验证码错误
        } else {
            return "3";     // 没有按发送验真码按钮
        }
    }

    @RequestMapping(value = "updatepassword", method = RequestMethod.POST)
    @ResponseBody
    public String updatepassword(String newpassword, String repassword, HttpServletRequest request) throws IOException {
        if (newpassword.equals(repassword)) {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            User user = new User();
            user.setUsername(username);
            user.setUpassword(newpassword);
            Boolean flag = userService.updateUserPassword(user);
            if (flag) {
                session.invalidate();
                return "1";     // 密码修改成功
            } else {
                System.out.println("未知错误");
                return "3";
            }
        } else {
            return "2";     // 两次密码输入不一致
        }
    }

    @RequestMapping("index")
    @AuthToken
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping(value = "getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("logout")
    public ModelAndView Logout(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        // 清除Session
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("httpHeaderName");
        String username = (String) redisUtils.get(token);
        redisUtils.remove(username + "Auth");
        redisUtils.remove(userService.SelectUsername(username).getUname());
        redisUtils.remove(token);
        redisUtils.remove(username);
        redisUtils.remove(username + token);
        session.invalidate();
        mv.setViewName("login");
        return mv;
    }

    //强制逼迫下线跳转页面
    @RequestMapping("compel")
    public ModelAndView compel() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("compel");
        return mv;
    }

    @RequestMapping("compel1")
    public ModelAndView compel1() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("compel1");
        return mv;
    }
}
