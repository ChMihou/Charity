package com.charity.controller;

import com.charity.common.Paginator;
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
            Paginator.page(pagenums,dlist,pageNum,pageSize);
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
            Paginator.page(pagenums,dlist,pageNum,pageSize);
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
        mv.addObject("id", id);
        mv.setViewName("donatemoney");
        return mv;
    }

}
