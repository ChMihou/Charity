package com.charity.controller;

import com.charity.common.Paginator;
import com.charity.entity.Award;
import com.charity.entity.UserAwardVo;
import com.charity.entity.UserScoreVo;
import com.charity.model.AuthToken;
import com.charity.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ScoreController {
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


    @RequestMapping("score")
    @AuthToken
    public ModelAndView score(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("Uid");
        List<UserScoreVo> userScoreVos = scoreService.selectPersonScore(id, pageNum, pageSize);
        PageInfo slist = new PageInfo(userScoreVos);
        List pagenums = new ArrayList();
        Paginator.page(pagenums,slist,pageNum,pageSize);
        mv.addObject("pagenums", pagenums);
        mv.addObject("slist", slist);
        mv.setViewName("score");
        return mv;
    }

    @RequestMapping("award")
    @AuthToken
    public ModelAndView award(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        Integer permisssionlevel = (Integer) session.getAttribute("permisssionlevel");
        Integer id = (Integer) session.getAttribute("Uid");
        String key = request.getParameter("key");
        if (key == "" || key == "null") {
            key = null;
        }
        List<UserAwardVo> userAwardVos = new ArrayList<>();
        mv.addObject("key", key);
        if (userService.SelectUsername(key) == null && permisssionlevel != 4) {
            Integer uid = null;
            userAwardVos = awardService.SelectPersonAward(uid, pageNum, pageSize);
            PageInfo alist = new PageInfo(userAwardVos);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,alist,pageNum,pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("alist", alist);
        } else if (userService.SelectUsername(key) != null && permisssionlevel != 4) {
            Integer uid = userService.SelectUsername(key).getUid();
            userAwardVos = awardService.SelectPersonAward(uid, pageNum, pageSize);
            PageInfo alist = new PageInfo(userAwardVos);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,alist,pageNum,pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("alist", alist);
        } else {
            userAwardVos = awardService.SelectPersonAward(id, pageNum, pageSize);
            PageInfo alist = new PageInfo(userAwardVos);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,alist,pageNum,pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("alist", alist);
        }
        mv.setViewName("award");
        return mv;
    }

    @RequestMapping("add-award")
    @AuthToken
    public ModelAndView addaward(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-award");
        return mv;
    }

    @RequestMapping("deleteAward")
    @AuthToken
    @ResponseBody
    public Boolean deleteaward(Integer id, HttpServletRequest request) {
        Integer aid = Integer.valueOf(id);

        boolean flag = awardService.deleteAward(aid);
        if (flag) {
            return true;     // 删除成功
        } else {
            return false;     // 删除失败
        }
    }

    @RequestMapping("addaward")
    @AuthToken
    @ResponseBody
    public Integer addaward1(String ausername, String aname, HttpServletRequest request) {
        if (userService.SelectUsername(ausername) == null)
            return 3;
        Integer id = userService.SelectUsername(ausername).getUid();
        Date date = new Date();
        Timestamp atime = new Timestamp(date.getTime());
        Award award = new Award();
        award.setAname(aname);
        award.setAtime(atime);
        award.setAuid(id);
        boolean i = awardService.AddAward(award);
        if (i)
            return 1;
        else
            return 2;
    }

    @RequestMapping("award-comment")
    @AuthToken
    public ModelAndView acomment(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.valueOf(request.getParameter("id"));
        mv.addObject("id", id);
        mv.setViewName("award-comment");
        return mv;
    }

    @RequestMapping("awardcomment")
    @ResponseBody
    @AuthToken
    public Boolean awardcomment(String acomment, Integer id, HttpSession session) {
        Award award = new Award();
        award.setAcomment(acomment);
        award.setAid(id);
        Boolean a = awardService.UpdateAcomment(award);
        if (a) {
            return true;
        } else {
            return false;
        }
    }

}
