package com.charity.controller;

import com.charity.common.Paginator;
import com.charity.entity.Jsoncheck;
import com.charity.entity.Notice;
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
public class NewsController {
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

    @RequestMapping("admin-news")
    @AuthToken
    public ModelAndView adminnews(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer flag;
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        Integer permisssionlevel = (Integer) session.getAttribute("permisssionlevel");
        mv.addObject("check", check);
        if (request.getParameter("check") == "" || request.getParameter("check") == null) {
            flag = null;
        } else {
            flag = Integer.valueOf(request.getParameter("check"));
        }
        String key = request.getParameter("key");
        Notice notice = new Notice();
        notice.setNflag(flag);
        notice.setNtitle(key);
        if (permisssionlevel == 4) {
            List<Notice> notices = noticeService.SelectreadNotice1(notice, pageNum, pageSize);
            PageInfo nlist = new PageInfo(notices);
            List pagenums = new ArrayList();
            Paginator.page(pagenums, nlist, pageNum, pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("nselect", 1);
            mv.addObject("nlist", nlist);
        } else {
            List<Notice> notices = noticeService.SelectNotice1(notice, pageNum, pageSize);
            PageInfo nlist = new PageInfo(notices);
            List pagenums = new ArrayList();
            Paginator.page(pagenums, nlist, pageNum, pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("nselect", 1);
            mv.addObject("nlist", nlist);
        }
        mv.addObject("check", check);
        mv.addObject("key", key);
        mv.setViewName("admin-news");
        return mv;
    }

    @RequestMapping("admin-special")
    @AuthToken
    public ModelAndView adminspecial(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer flag;
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
        Integer permisssionlevel = (Integer) session.getAttribute("permisssionlevel");
        mv.addObject("check", check);
        if (request.getParameter("check") == "" || request.getParameter("check") == null) {
            flag = null;
        } else {
            flag = Integer.valueOf(request.getParameter("check"));
        }
        String key = request.getParameter("key");
        Notice notice = new Notice();
        notice.setNflag(flag);
        notice.setNtitle(key);
        if (permisssionlevel == 4) {
            List<Notice> notices = noticeService.SelectreadNotice3(notice, pageNum, pageSize);
            PageInfo nlist = new PageInfo(notices);
            List pagenums = new ArrayList();
            Paginator.page(pagenums, nlist, pageNum, pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("nselect", 1);
            mv.addObject("nlist", nlist);
        } else {
            List<Notice> notices = noticeService.SelectNotice3(notice, pageNum, pageSize);
            PageInfo nlist = new PageInfo(notices);
            List pagenums = new ArrayList();
            Paginator.page(pagenums, nlist, pageNum, pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("nselect", 1);
            mv.addObject("nlist", nlist);
        }
        mv.addObject("check", check);
        mv.addObject("key", key);
        mv.setViewName("admin-special");
        return mv;
    }

    @RequestMapping("admin-project")
    @AuthToken
    public ModelAndView adminproject(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer flag;
        HttpSession session = request.getSession();
        Integer permisssionlevel = (Integer) session.getAttribute("permisssionlevel");
        String check = request.getParameter("check");
        mv.addObject("check", check);
        if (request.getParameter("check") == "" || request.getParameter("check") == null) {
            flag = null;
        } else {
            flag = Integer.valueOf(request.getParameter("check"));
        }
        String key = request.getParameter("key");
        Notice notice = new Notice();
        notice.setNflag(flag);
        notice.setNtitle(key);
        if (permisssionlevel == 4) {
            List<Notice> notices = noticeService.SelectreadNotice2(notice, pageNum, pageSize);
            PageInfo nlist = new PageInfo(notices);
            List pagenums = new ArrayList();
            Paginator.page(pagenums, nlist, pageNum, pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("nselect", 1);
            mv.addObject("nlist", nlist);
        } else {
            List<Notice> notices = noticeService.SelectNotice2(notice, pageNum, pageSize);
            PageInfo nlist = new PageInfo(notices);
            List pagenums = new ArrayList();
            Paginator.page(pagenums, nlist, pageNum, pageSize);
            mv.addObject("pagenums", pagenums);
            mv.addObject("nselect", 1);
            mv.addObject("nlist", nlist);
        }
        mv.addObject("key", key);
        mv.addObject("check", check);
        mv.setViewName("admin-project");
        return mv;
    }

    @RequestMapping("read-article")
    @AuthToken
    public ModelAndView readarticle(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer nid = Integer.valueOf(request.getParameter("id"));
        Notice notice = noticeService.SelectNoticeId(nid);
        mv.addObject("notice", notice);
        mv.setViewName("read-article");
        return mv;
    }

    @RequestMapping("edit-article")
    @AuthToken
    public ModelAndView editarticle(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer nid;
        if (request.getParameter("id") == null) {
            nid = 1;
        } else {
            nid = Integer.valueOf(request.getParameter("id"));
        }
        Notice notice = noticeService.SelectNoticeId(nid);
        mv.addObject("notice", notice);
        mv.setViewName("edit-article");
        return mv;
    }

    @RequestMapping("check-article")
    @AuthToken
    public ModelAndView checkarticle(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer nid;
        if (request.getParameter("id") == null) {
            nid = 1;
        } else {
            nid = Integer.valueOf(request.getParameter("id"));
        }
        Notice notice = noticeService.SelectNoticeId(nid);
        mv.addObject("notice", notice);
        mv.setViewName("check-article");
        return mv;
    }

    @RequestMapping("submitcheck")
    @ResponseBody
    @AuthToken
    public Boolean submitCheck(Jsoncheck jsoncheck) {
        Boolean a = noticeService.alterCheck(jsoncheck);
        if (a) {
            return true;
        }

        return false;
    }

    @RequestMapping("addarticle")
    @ResponseBody
    @AuthToken
    public Boolean addarticle(String n_title, String n_article, String n_author, Integer n_flag, Integer n_select, String images, Integer aims, String nintro) {
        Notice notice = new Notice();
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        notice.setNtitle(n_title);
        notice.setNarticle(n_article);
        notice.setNauthor(n_author);
        notice.setNtime(nousedate);
        notice.setNintro(nintro);
        notice.setNselect(n_select);
        notice.setNflag(n_flag);
        notice.setNimage(images);
        notice.setMoney(aims);
        notice.setNmoney(0);
        noticeService.addNotice(notice);
        return true;
    }

    @RequestMapping("article-add")
    @AuthToken
    public ModelAndView articleadd(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer nselect = Integer.valueOf(request.getParameter("nselect"));
        mv.addObject("nselect", nselect);
        mv.setViewName("add-article");
        return mv;
    }

    @RequestMapping("deleteOneNotice")
    @ResponseBody
    @AuthToken
    public boolean deleteOneNotice(Integer id) {
        Boolean i = noticeService.deleteOneNotice(id);
        if (i) {
            return true;
        }
        return false;
    }

    @RequestMapping("deleteListNotice")
    @ResponseBody
    @AuthToken
    public boolean deleteListNotice(String ids) {
        String[] id = ids.split(",");
        int[] ints = new int[id.length];

        for (int i = 0; i < id.length; i++) {

            ints[i] = Integer.parseInt(id[i]);

        }
        for (int i = 0; i < ints.length; i++) {
            Boolean a = noticeService.deleteOneNotice(ints[i]);
            if (!a)
                return false;
        }
        return true;
    }

    @RequestMapping("updateNotice")
    @ResponseBody
    public boolean updatearticle(Integer n_id, String n_title, String n_article, String n_author, Integer n_flag, String images, Integer aims, String ninro) {
        ModelAndView mv = new ModelAndView();
        Notice notice = new Notice();
        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());
        notice.setNid(n_id);
        notice.setNtitle(n_title);
        notice.setNarticle(n_article);
        notice.setNauthor(n_author);
        notice.setNtime(nousedate);
        notice.setNflag(n_flag);
        notice.setNintro(ninro);
        notice.setNimage(images);
        notice.setMoney(aims);
        Boolean i;
        if (images == null || images == "") {
            i = noticeService.updateNotice1(notice);
        } else {
            i = noticeService.updateNotice2(notice);
        }
        mv.addObject("id", notice.getNid());
        if (i)
            return true;
        return true;
    }
}
