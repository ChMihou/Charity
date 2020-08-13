package com.charity.controller;

import com.charity.common.Paginator;
import com.charity.entity.*;
import com.charity.model.AuthToken;
import com.charity.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    NoticeService noticeService;

    @Autowired
    DonationService donationService;

    @Autowired
    MessageService messageService;

    @Autowired
    CabinetService cabinetService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    AwardService awardService;

    @Autowired
    MailService mailService;

    @Autowired
    CommentService commentService;

    @Autowired
    EmailService emailService;

    @RequestMapping("welcome")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        Integer money = donationService.CheckDMoney();
        Integer people = userService.checkuserall();
        Integer donation = donationService.CheckDonation();
        Integer notice = noticeService.CheckNotice();
        mv.addObject("money", money);
        mv.addObject("people", people);
        mv.addObject("donation", donation);
        mv.addObject("notice", notice);
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("member-list")
    @AuthToken
    public ModelAndView memberlist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String search = request.getParameter("search");
        if (search == "null") {
            search = null;
        }
        List<User> userList = userService.SelectallUser(search);
        if (userList.isEmpty()) {
            PageInfo userolevolist = new PageInfo(userList);
            mv.addObject("ulist", userolevolist);
        } else {
            List<UserRoleVo> userRoleVos = roleService.selectRolename(userList, pageNum, pageSize);
            PageInfo userolevolist = new PageInfo(userRoleVos);
            mv.addObject("ulist", userolevolist);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,userolevolist,pageNum,pageSize);
            mv.addObject("pagenums", pagenums);
        }
        mv.addObject("search", search);
        mv.setViewName("member-list");
        return mv;
    }

    @RequestMapping("authority")
    @AuthToken
    public ModelAndView authority(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String search = request.getParameter("search");
        if (search == "null") {
            search = null;
        }
        List<User> userList = userService.SelectallUser(search);
        if (userList.isEmpty()) {
            PageInfo userolevolist = new PageInfo(userList);
            mv.addObject("ulist", userolevolist);
        } else {
            List<UserRoleVo> userRoleVos = roleService.selectRolename(userList, pageNum, pageSize);
            PageInfo userolevolist = new PageInfo(userRoleVos);
            mv.addObject("ulist", userolevolist);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,userolevolist,pageNum,pageSize);
            mv.addObject("pagenums", pagenums);
        }
        mv.addObject("search", search);
        mv.setViewName("authority");
        return mv;
    }

    @RequestMapping("edituser")
    @AuthToken
    public ModelAndView edituser(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.SelectUserId(id);
        mv.addObject("id", user.getUid());
        mv.addObject("user", user);
        mv.setViewName("edituser");
        return mv;
    }

    @RequestMapping(value = "deleteuser", method = RequestMethod.POST)
    @ResponseBody
    @AuthToken
    public String deleteuser(String id) throws IOException {

        Integer uid = Integer.valueOf(id);

        boolean flag = userService.deleteUser(uid);
        if (flag) {
            return "1";     // 删除用户成功
        } else {
            return "2";     // 删除用户失败
        }
    }

    @RequestMapping("edituserall")
    @ResponseBody
    @AuthToken
    public String edituserall(Integer id, String username, String pass, String usex,
                              String email, String mobile, String address,
                              String province, String nicename, String city, String area) throws IOException {
        String flag = province + city + area + address;
        address = flag;
        User user = new User();
        switch (usex) {
            case "1":
                usex = "男";
                break;
            case "2":
                usex = "女";
                break;
        }
        user.setUsername(username);
        user.setUpassword(pass);
        user.setUsex(usex);
        user.setUid(id);
        user.setUaddress(address);
        user.setUemail(email);
        user.setUiphone(mobile);
        user.setUname(nicename);
        Boolean flag1 = userService.alterUserAll(user);
        if (flag1) {
            return "1";     // 修改成功
        } else {
            return "3";     // 修改失败
        }
    }

    @RequestMapping("admin-edit")
    @AuthToken
    public ModelAndView adminedit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin-edit");
        return mv;
    }

    @RequestMapping("admin-list")
    @AuthToken
    public ModelAndView adminlist() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin-list");
        return mv;
    }

    @RequestMapping("admin-role")
    @AuthToken
    public ModelAndView adminrole() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin-role");
        return mv;
    }

    @RequestMapping("authority-alter")
    @AuthToken
    public ModelAndView authorityalter(Integer id) {
        ModelAndView mv = new ModelAndView();
        UserRoleVo userRoleVo = roleService.selectRoleOne(id);
        mv.addObject("userRoleVo", userRoleVo);
        mv.addObject("id", id);
        mv.setViewName("authority-alter");
        return mv;
    }

    @RequestMapping(value = "power", method = RequestMethod.POST)
    @ResponseBody
    @AuthToken
    public boolean poweredit(Integer dutyid, Integer id) {
        UserRole userRole = new UserRole();
        userRole.setUserid(id);
        userRole.setRoleid(dutyid);
        boolean flag = roleService.alterUserRole(userRole);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping("demo")
    @AuthToken
    public ModelAndView demo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        return mv;
    }


    //注册账号
    @RequestMapping("member-add")
    public ModelAndView memberadd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member-add");
        return mv;
    }

    @RequestMapping("member-del")
    @AuthToken
    public ModelAndView memberdel() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member-del");
        return mv;
    }

    @RequestMapping("member-edit")
    @AuthToken
    public ModelAndView memberedit() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member-edit");
        return mv;
    }

    @RequestMapping("member-password")
    public ModelAndView memberpassword() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member-password");
        return mv;
    }

    @RequestMapping("member-alter")
    @AuthToken
    public ModelAndView memberalter(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        User user = userService.SelectUsername(username);
        mv.addObject("user", user);
        mv.setViewName("member-alter");
        return mv;
    }

    @RequestMapping("order-add")
    @AuthToken
    public ModelAndView orderadd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("order-add");
        return mv;
    }


    //忘记密码
    @RequestMapping("user-lostpassword")
    public ModelAndView orderlist1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-lostpassword");
        return mv;
    }

    @RequestMapping("role-add")
    @AuthToken
    public ModelAndView roleadd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-add");
        return mv;
    }

    @RequestMapping("unicode")
    @AuthToken
    public ModelAndView unicode() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("unicode");
        return mv;
    }

    @RequestMapping("memberalter")
    @ResponseBody
    public String memberalter(String username, String pass, String usex,
                              String email, String mobile, String address,
                              String province, String nicename, String city, String area) throws IOException {
        String flag = province + city + area + address;
        address = flag;
        User user = new User();
        switch (usex) {
            case "1":
                usex = "男";
                break;
            case "2":
                usex = "女";
                break;
        }
        user.setUsername(username);
        user.setUpassword(pass);
        user.setUsex(usex);
        user.setUaddress(address);
        user.setUemail(email);
        user.setUiphone(mobile);
        user.setUname(nicename);
        Boolean flag1 = userService.alterUser(user);
        if (flag1) {
            return "1";     // 修改成功
        } else {
            return "3";     // 修改失败
        }
    }

    @RequestMapping("chatroom")
    @AuthToken
    public ModelAndView chatroom() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatroom");
        return mv;
    }

    @RequestMapping("member")
    @AuthToken
    public ModelAndView member(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userService.SelectUsername(username);
        Role role = userService.checkRole(user.getUid());
        model.addObject("user", user);
        model.addObject("role", role);
        model.setViewName("member");
        return model;
    }

    @RequestMapping("contact")
    @AuthToken
    public ModelAndView contact() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("contact");

        return mv;
    }

    @RequestMapping("sendemail")
    @ResponseBody
    public Integer SendEmail(String name, String email, String subject, String message, HttpServletRequest request) {
        User user = new User();
        user.setUsername(name);
        user.setUemail(email);
        if (userService.SelectEmail(user) == null)
            return 2;

        Boolean i = mailService.send(email, subject, message);

        if (i) {
            HttpSession session = request.getSession();
            String sendUser = (String) session.getAttribute("username");
            Date date = new Date();
            Timestamp etime = new Timestamp(date.getTime());
            Email email1 = new Email();
            email1.setEusername(name);
            email1.setEmail(email);
            email1.setEmess(message);
            email1.setEsubject(subject);
            email1.setEsenduser(sendUser);
            email1.setEtime(etime);
            emailService.InsertEmail(email1);
            return 1;
        } else {
            return 3;
        }
    }

    @RequestMapping("email")
    @AuthToken
    public ModelAndView email(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Email> emails = emailService.SelectAllEmail(pageNum, pageSize);
        PageInfo elist = new PageInfo(emails);
        List pagenums = new ArrayList();
        Paginator.page(pagenums,elist,pageNum,pageSize);
        mv.addObject("pagenums", pagenums);
        mv.addObject("elist", elist);
        mv.setViewName("email");
        return mv;
    }

    @RequestMapping("image")
    public ModelAndView image(Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("image");
        return mv;
    }

}
