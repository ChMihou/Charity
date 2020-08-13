package com.charity.controller;

import com.charity.common.Paginator;
import com.charity.entity.Comment;
import com.charity.entity.Message;
import com.charity.entity.UserCommentNoticeVo;
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
public class CommentController {
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


    @RequestMapping("submitapply")
    @ResponseBody
    @AuthToken
    public Boolean submitAopply(String mess, Integer mid, HttpSession session) {
        Message message = new Message();
        String Mcheckboy = (String) session.getAttribute("username");
        message.setMid(mid);
        message.setMflag(1);
        message.setMapply(mess);
        message.setMcheckboy(Mcheckboy);
        Boolean a = messageService.addapply(message);
        if (a) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("submitapplycomment")
    @ResponseBody
    @AuthToken
    public Boolean submitApplycomment(String apply, Integer id, HttpSession session) {
        Comment comment = new Comment();
        String aboy = (String) session.getAttribute("username");
        comment.setCaboy(aboy);
        comment.setCflag(1);
        comment.setCapply(apply);
        comment.setCid(id);
        Boolean a = commentService.UpdateApply(comment);
        if (a) {
            return true;
        } else {
            return false;
        }
    }


    @RequestMapping("deleteOneComment")
    @ResponseBody
    @AuthToken
    public boolean deleteOneComment(Integer id) {

        Boolean i = commentService.DeleteComent(id);
        if (i) {
            return true;
        }
        return false;
    }

    @RequestMapping("deleteListComment")
    @ResponseBody
    @AuthToken
    public boolean deleteListComment(String ids) {
        String[] id = ids.split(",");
        int[] ints = new int[id.length];

        for (int i = 0; i < id.length; i++) {

            ints[i] = Integer.parseInt(id[i]);

        }
        for (int i = 0; i < ints.length; i++) {
            Boolean a = commentService.DeleteComent(ints[i]);
            if (!a)
                return false;
        }
        return true;
    }


    @RequestMapping("apply-comment")
    @AuthToken
    public ModelAndView applycomment(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.valueOf(request.getParameter("id"));
        mv.addObject("id", id);
        mv.setViewName("apply-comment");
        return mv;
    }

    @RequestMapping("comment-list")
    @AuthToken
    public ModelAndView commentlist(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<UserCommentNoticeVo> userCommentNoticeVos = commentService.SelectAllComment(pageNum, pageSize);
        PageInfo clist = new PageInfo(userCommentNoticeVos);
        List pagenums = new ArrayList();
        Paginator.page(pagenums,clist,pageNum,pageSize);
        mv.addObject("pagenums", pagenums);
        mv.addObject("clist", clist);
        mv.setViewName("comment-list");
        return mv;
    }

    @RequestMapping("addmessage")
    @ResponseBody
    @AuthToken
    public Boolean addmessage(String n_title, String n_article, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String Mname = (String) session.getAttribute("username");
        Date date = new Date();
        Timestamp mtime = new Timestamp(date.getTime());
        Message message = new Message();
        message.setMtitle(n_title);
        message.setMname(Mname);
        message.setMtime(mtime);
        message.setMflag(0);
        message.setMess(n_article);
        Boolean i = messageService.addMessage(message);
        if (i)
            return true;
        else
            return false;
    }

    @RequestMapping("message")
    @AuthToken
    public ModelAndView message(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Integer permisssionlevel = (Integer) session.getAttribute("permisssionlevel");
        Integer flag;
        String check = request.getParameter("check");
        model.addObject("check", check);
        if (request.getParameter("check") == "" || request.getParameter("check") == null) {
            flag = null;
        } else {
            flag = Integer.valueOf(request.getParameter("check"));
        }
        Message message = new Message();
        String key = request.getParameter("key");
        if (key == "") {
            key = null;
        }
        model.addObject("key", key);
        message.setMtitle(key);
        message.setMflag(flag);
        if (permisssionlevel == 3) {
            List<Message> messageList = messageService.CheckallMessage(message, pageNum, pageSize);
            PageInfo mlist = new PageInfo(messageList);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,mlist,pageNum,pageSize);
            model.addObject("pagenums", pagenums);
            model.addObject("mlist", mlist);
        } else {
            message.setMname(username);
            List<Message> messageList = messageService.CheckoneMessage(message, pageNum, pageSize);
            PageInfo mlist = new PageInfo(messageList);
            List pagenums = new ArrayList();
            Paginator.page(pagenums,mlist,pageNum,pageSize);
            model.addObject("pagenums", pagenums);
            model.addObject("mlist", mlist);
        }
        model.setViewName("message");
        return model;
    }

    @RequestMapping("deleteOneMessage")
    @ResponseBody
    @AuthToken
    public Boolean deleteOneMessage(Integer id) {
        Boolean i = messageService.deleteOneMessage(id);
        if (i)
            return true;
        else
            return false;

    }

    @RequestMapping("add-message")
    @AuthToken
    public ModelAndView addmessage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-message");
        return mv;
    }

    @RequestMapping("read-message")
    @AuthToken
    public ModelAndView readmessage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer mid = Integer.valueOf(request.getParameter("id"));
        Message message = messageService.CheckIdMessage(mid);
        mv.addObject("message", message);
        mv.setViewName("read-message");
        return mv;
    }

    @RequestMapping("apply-message")
    @AuthToken
    public ModelAndView applymessage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer mid = Integer.valueOf(request.getParameter("id"));
        Message message = messageService.CheckIdMessage(mid);
        mv.addObject("message", message);
        mv.setViewName("apply-message");
        return mv;
    }

}
