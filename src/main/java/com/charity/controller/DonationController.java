package com.charity.controller;

import com.charity.entity.Donation;
import com.charity.entity.Score;
import com.charity.entity.UserDonationVo;
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
public class DonationController {
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


    @RequestMapping("donation")
    @AuthToken
    public ModelAndView donation(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String key = request.getParameter("key");
        HttpSession session = request.getSession();
        mv.addObject("key", key);
        Integer permisssionlevel = (Integer) session.getAttribute("permisssionlevel");
        if (request.getParameter("key") == "" || request.getParameter("key") == null) {
            key = null;
        } else {
            key = (request.getParameter("key"));
        }
        if (permisssionlevel == 4) {
            Integer duid = (Integer) session.getAttribute("Uid");
            List<UserDonationVo> userDonationVos = donationService.SelectAllDonation(duid, pageNum, pageSize);
            PageInfo dlist = new PageInfo(userDonationVos);
            List pagenums = new ArrayList();
            if (pageNum > 3 && dlist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
            {
                if (pageNum >= dlist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                    pagenums.add(dlist.getPages() - 4);
                    pagenums.add(dlist.getPages() - 3);
                    pagenums.add(dlist.getPages() - 2);
                    pagenums.add(dlist.getPages() - 1);
                    pagenums.add(dlist.getPages());
                } else {
                    pagenums.add(pageNum - 2);
                    pagenums.add(pageNum - 1);
                    pagenums.add(pageNum);
                    pagenums.add(pageNum + 1);
                    pagenums.add(pageNum + 2);
                }
            } else {          //前端页数没超过第三页时
                if (dlist.getPages() < 5) //如果总页数小于5
                {
                    for (int i = 0; i < dlist.getPages(); i++)
                        pagenums.add(i + 1);
                } else {
                    pagenums.add("1");
                    pagenums.add("2");
                    pagenums.add("3");
                    pagenums.add("4");
                    pagenums.add("5");
                }
            }
            mv.addObject("pagenums", pagenums);
            mv.addObject("dlist", dlist);
        } else {
            Integer duid;
            if (key == null) {
                duid = null;
            } else {
                duid = userService.SelectUsername(key).getUid();
            }
            List<UserDonationVo> userDonationVos = donationService.SelectAllDonation(duid, pageNum, pageSize);
            PageInfo dlist = new PageInfo(userDonationVos);
            List pagenums = new ArrayList();
            if (pageNum > 3 && dlist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
            {
                if (pageNum >= dlist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                    pagenums.add(dlist.getPages() - 4);
                    pagenums.add(dlist.getPages() - 3);
                    pagenums.add(dlist.getPages() - 2);
                    pagenums.add(dlist.getPages() - 1);
                    pagenums.add(dlist.getPages());
                } else {
                    pagenums.add(pageNum - 2);
                    pagenums.add(pageNum - 1);
                    pagenums.add(pageNum);
                    pagenums.add(pageNum + 1);
                    pagenums.add(pageNum + 2);
                }
            } else {          //前端页数没超过第三页时
                if (dlist.getPages() < 5) //如果总页数小于5
                {
                    for (int i = 0; i < dlist.getPages(); i++)
                        pagenums.add(i + 1);
                } else {
                    pagenums.add("1");
                    pagenums.add("2");
                    pagenums.add("3");
                    pagenums.add("4");
                    pagenums.add("5");
                }
            }
            mv.addObject("pagenums", pagenums);
            mv.addObject("dlist", dlist);
        }
        mv.setViewName("donation");
        return mv;
    }


    @RequestMapping("add-donation")
    @AuthToken
    public ModelAndView adddonation(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-donation");
        return mv;
    }

    @RequestMapping("edit-donation")
    @AuthToken
    public ModelAndView editdonation1(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer id;
        id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        Donation donation = donationService.SelectNameDonation(id);
        String username = userService.SelectUserId(donation.getDuid()).getUsername();
        Integer score = scoreService.selectIdScore(donation.getDsid()).getScore();
        mv.addObject("score", score);
        mv.addObject("username", username);
        mv.addObject("donation", donation);
        mv.setViewName("edit-donation");
        return mv;
    }

    @RequestMapping("editdonation")
    @AuthToken
    @ResponseBody
    public Integer editdonation(String donations, String dusername, Integer dsid, Integer did, String daddress, Integer dmoney, Integer score, HttpServletRequest request) {
        if (userService.SelectUsername(dusername) == null)
            return 3;//名字错误
        String Scause = donations;
        if (dmoney != null)
            Scause = Scause + "和捐赠了" + dmoney + "元";
        Donation donation = new Donation();
        Integer uid = userService.SelectUsername(dusername).getUid();
        donation.setDaddress(daddress);
        donation.setDmoney(dmoney);
        donation.setDonations(donations);
        donation.setDuid(uid);
        donation.setDid(did);
        Score score1 = new Score();
        score1.setScause(Scause);
        score1.setScore(score);
        score1.setSid(dsid);
        System.out.println(donation);
        System.out.println(score1);
        Boolean i = scoreService.updateOne(score1);
        Boolean a = donationService.UpdateDonation(donation);
        if (a && i) {
            return 1;
        } else
            return 2;
    }


    @RequestMapping("adddonation")
    @ResponseBody
    @AuthToken
    public Integer adddonation(String donations, String dusername, String daddress, Integer score, Integer dmoney, HttpServletRequest request) {
        if (userService.SelectUsername(dusername) == null)
            return 3;//名字错误
        Integer uid = userService.SelectUsername(dusername).getUid();
        System.out.println(dusername + uid);
        String Scause = donations;
        if (dmoney != null)
            Scause = Scause + "和捐赠了" + dmoney + "元";
        Score score1 = new Score();
        Date date = new Date();
        Timestamp stime = new Timestamp(date.getTime());
        score1.setScause(Scause);
        score1.setScore(score);
        score1.setSuid(uid);
        score1.setStime(stime);
        Integer f = scoreService.updatescore(score1);
        Integer sid = score1.getSid();
        Donation donation = new Donation();
        donation.setDaddress(daddress);
        donation.setDmoney(dmoney);
        donation.setDsid(sid);
        donation.setDonations(donations);
        donation.setDuid(23);
        System.out.println(donation);
        Boolean i = donationService.AddDonation(donation);
        if (i)
            return 1;
        else
            return 2;
    }

    @RequestMapping(value = "deleteDonation", method = RequestMethod.POST)
    @ResponseBody
    @AuthToken
    public String deleteDonation(String id) throws IOException {

        Integer did = Integer.valueOf(id);
        System.out.println(did);
        Integer sid = donationService.SelectIdDonation(did).getDsid();
        Boolean flag = donationService.DeleteDonation(did);
        Boolean flag1 = scoreService.deletescore(sid);
        if (flag && flag1) {
            return "1";     // 删除物资记录成功
        } else {
            return "2";     // 删除物资记录失败
        }
    }

    @RequestMapping("donateMoney")
    public ModelAndView donateMoney(Integer id) {
        ModelAndView mv = new ModelAndView();
        System.out.println(id);
        mv.addObject("id", id);
        mv.setViewName("donatemoney");
        return mv;
    }

}
