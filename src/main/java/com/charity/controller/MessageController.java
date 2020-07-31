package com.charity.controller;

import com.charity.entity.*;
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
public class MessageController {

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

    @RequestMapping("home")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView();

        Notice notice = new Notice();
        List<Notice> notices = noticeService.SelectreadNotice1(notice, 1, 5);
        List<Notice> notices1 = noticeService.SelectreadNotice2(notice, 1, 5);
        PageInfo nlist1 = new PageInfo(notices1);
        PageInfo nlist = new PageInfo(notices);
        List<UserDonationVo> userDonationVos = donationService.SelectAllDonation(null, 1, 5);
        PageInfo dlist = new PageInfo(userDonationVos);
        List<UserCommentVo> userCommentVos = commentService.SelectComment(1, 5);
        PageInfo clist = new PageInfo(userCommentVos);
        List<String> images = noticeService.SelectAllImage(1, 6);
        PageInfo ilist = new PageInfo(images);
        notice = noticeService.SelectLatestNotice();
        Integer money = donationService.CheckDMoney();
        Integer people = userService.checkuserall();
        Integer donation = donationService.CheckDonation();
        Integer numnotice = noticeService.CheckNotice();
        mv.addObject("numnotice", numnotice);
        mv.addObject("money", money);
        mv.addObject("people", people);
        mv.addObject("donation", donation);
        mv.addObject("notice", notice);
        mv.addObject("ilist", ilist);
        mv.addObject("clist", clist);
        mv.addObject("dlist", dlist);
        mv.addObject("nlist", nlist);
        mv.addObject("nlist1", nlist1);
        mv.setViewName("home");

        return mv;
    }

    @RequestMapping("about")
    public ModelAndView about(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "4") int pageSize) {

        ModelAndView mv = new ModelAndView();

        List<User> users = userService.SelectRootUser(pageNum, pageSize);

        PageInfo ulist = new PageInfo(users);

        mv.addObject("ulist", ulist);

        mv.setViewName("about");

        return mv;
    }

    @RequestMapping("cause-single")
    public ModelAndView causesingle(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "9") int pageSize) {

        ModelAndView mv = new ModelAndView();
        List<UserAwardVo> userAwardVos = awardService.SelectPersonAward(null, pageNum, pageSize);
        PageInfo alist = new PageInfo(userAwardVos);
        List pagenums = new ArrayList();
        if (pageNum > 3 && alist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= alist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(alist.getPages() - 4);
                pagenums.add(alist.getPages() - 3);
                pagenums.add(alist.getPages() - 2);
                pagenums.add(alist.getPages() - 1);
                pagenums.add(alist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (alist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < alist.getPages(); i++)
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
        mv.addObject("alist", alist);
        mv.setViewName("cause-single");

        return mv;
    }

    @RequestMapping("causes")
    public ModelAndView causes(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {

        ModelAndView mv = new ModelAndView();

        Notice notice = new Notice();
        List<Notice> notices = noticeService.SelectreadNotice2(notice, pageNum, pageSize);
        PageInfo nlist = new PageInfo(notices);
        List pagenums = new ArrayList();
        if (pageNum > 3 && nlist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= nlist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(nlist.getPages() - 4);
                pagenums.add(nlist.getPages() - 3);
                pagenums.add(nlist.getPages() - 2);
                pagenums.add(nlist.getPages() - 1);
                pagenums.add(nlist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (nlist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < nlist.getPages(); i++)
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
        mv.addObject("nlist", nlist);

        mv.setViewName("causes");

        return mv;
    }

    @RequestMapping("donate")
    public ModelAndView donate() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("donate");

        return mv;
    }

    @RequestMapping("gallery")
    public ModelAndView gallery(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "16") int pageSize) {

        ModelAndView mv = new ModelAndView();

        List<String> images = noticeService.SelectAllImage(pageNum, pageSize);

        PageInfo ilist = new PageInfo(images);
        List pagenums = new ArrayList();
        if (pageNum > 3 && ilist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= ilist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(ilist.getPages() - 4);
                pagenums.add(ilist.getPages() - 3);
                pagenums.add(ilist.getPages() - 2);
                pagenums.add(ilist.getPages() - 1);
                pagenums.add(ilist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (ilist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < ilist.getPages(); i++)
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
        mv.addObject("ilist", ilist);

        mv.setViewName("gallery");

        return mv;
    }

    @RequestMapping("news")
    public ModelAndView news(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "9") int pageSize) {

        ModelAndView mv = new ModelAndView();
        Notice notice = new Notice();
        List<Notice> notices = noticeService.SelectreadNotice1(notice, pageNum, pageSize);
        PageInfo nlist = new PageInfo(notices);
        List pagenums = new ArrayList();
        if (pageNum > 3 && nlist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= nlist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(nlist.getPages() - 4);
                pagenums.add(nlist.getPages() - 3);
                pagenums.add(nlist.getPages() - 2);
                pagenums.add(nlist.getPages() - 1);
                pagenums.add(nlist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (nlist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < nlist.getPages(); i++)
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
        mv.addObject("nlist", nlist);
        mv.setViewName("news");
        return mv;
    }

    @RequestMapping("testimonial")
    public ModelAndView testimonial(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String area = request.getParameter("area");
        String caddress;
        if (province != null) {
            caddress = province;
            if (city != null) {
                caddress = province + city;
                if (area != null) {
                    caddress = province + city + area;
                }
            }
        } else {
            caddress = null;
        }
        Cabinet cabinet = new Cabinet();
        cabinet.setCaddress(caddress);
        List<Cabinet> cabinets = cabinetService.SelectAllCabinet(cabinet, pageNum, pageSize);
        PageInfo clist = new PageInfo(cabinets);
        List pagenums = new ArrayList();
        if (pageNum > 3 && clist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= clist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(clist.getPages() - 4);
                pagenums.add(clist.getPages() - 3);
                pagenums.add(clist.getPages() - 2);
                pagenums.add(clist.getPages() - 1);
                pagenums.add(clist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (clist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < clist.getPages(); i++)
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
        mv.addObject("clist", clist);
        mv.setViewName("testimonial");

        return mv;
    }

    @RequestMapping("article")
    public ModelAndView article(Integer id, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {

        ModelAndView mv = new ModelAndView();
        Notice notice = new Notice();
        notice = noticeService.SelectNoticeId(id);
        mv.addObject("notice", notice);
        mv.addObject("id", id);
        List<UserCommentVo> userCommentVos = commentService.SelectComentId(id, pageNum, pageSize);
        PageInfo clist = new PageInfo(userCommentVos);
        List<UserDonationVo> userDonationVos = donationService.SelectNIdDonation(id, pageNum, pageSize);
        PageInfo dlist = new PageInfo(userDonationVos);
        List pagenums = new ArrayList();
        if (pageNum > 3 && clist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= clist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(clist.getPages() - 4);
                pagenums.add(clist.getPages() - 3);
                pagenums.add(clist.getPages() - 2);
                pagenums.add(clist.getPages() - 1);
                pagenums.add(clist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (clist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < clist.getPages(); i++)
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
        mv.addObject("clist", clist);
        mv.addObject("dlist", dlist);
        mv.setViewName("article");
        return mv;
    }

    @RequestMapping("comment")
    public ModelAndView comment(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {

        ModelAndView mv = new ModelAndView();
        List<UserCommentVo> userCommentVos = commentService.SelectComment(pageNum, pageSize);
        PageInfo clist = new PageInfo(userCommentVos);
        List pagenums = new ArrayList();
        if (pageNum > 3 && clist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= clist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(clist.getPages() - 4);
                pagenums.add(clist.getPages() - 3);
                pagenums.add(clist.getPages() - 2);
                pagenums.add(clist.getPages() - 1);
                pagenums.add(clist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (clist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < clist.getPages(); i++)
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
        mv.addObject("clist", clist);
        mv.setViewName("comment");

        return mv;
    }

    @RequestMapping("submitcomment")
    @ResponseBody
    public Boolean submitComment(HttpServletRequest request, Integer cid, String comment) {

        Comment com = new Comment();
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("Uid");
        com.setCflag(0);
        com.setCnid(cid);
        com.setComment(comment);
        com.setCuid(uid);
        Date date = new Date();
        Timestamp datetime = new Timestamp(date.getTime());
        com.setCtime(datetime);
        Boolean i = commentService.InsertComment(com);
        if (i) {
            return true;
        } else
            return false;
    }

    @RequestMapping("submitallcomment")
    @ResponseBody
    public Boolean submitallComment(HttpServletRequest request, String comment) {

        Comment com = new Comment();
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("Uid");
        com.setCflag(0);
        com.setCnid(0);
        com.setComment(comment);
        com.setCuid(uid);
        Date date = new Date();
        Timestamp datetime = new Timestamp(date.getTime());
        com.setCtime(datetime);
        System.out.println("hello");
        Boolean i = commentService.InsertComment(com);
        if (i) {
            return true;
        } else
            return false;
    }

    @RequestMapping("deleteComment")
    public ModelAndView deleteComment(Integer cid, Integer nid) {
        ModelAndView mv = new ModelAndView();
        Boolean i = commentService.DeleteComent(cid);
        mv.setViewName("redirect:article?id=" + nid);
        return mv;
    }

    @RequestMapping("deleteallComment")
    public ModelAndView deleteallComment(Integer cid) {
        ModelAndView mv = new ModelAndView();
        Boolean i = commentService.DeleteComent(cid);
        mv.setViewName("redirect:comment");
        return mv;
    }

    @RequestMapping("applycomment")
    @ResponseBody
    public Boolean applysubmit(HttpServletRequest request, Integer aid, String apply, Integer nid) {
        Comment comment = new Comment();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        comment.setCaboy(username);
        comment.setCflag(1);
        comment.setCid(aid);
        comment.setCapply(apply);
        commentService.UpdateApply(comment);
        return true;
    }

    @RequestMapping("applyfirtscomment")
    @ResponseBody
    public Boolean applyfirtscomment(HttpServletRequest request, Integer aid, String apply) {
        Comment comment = new Comment();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        comment.setCaboy(username);
        comment.setCflag(1);
        comment.setCid(aid);
        comment.setCapply(apply);
        commentService.UpdateApply(comment);
        return true;
    }

    @RequestMapping("specialnews")
    public ModelAndView specialnews(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "2") int pageSize) {
        ModelAndView mv = new ModelAndView();
        Notice notice = new Notice();
        List<Notice> notices = noticeService.SelectreadNotice3(notice, pageNum, pageSize);
        PageInfo nlist = new PageInfo(notices);
        List pagenums = new ArrayList();
        if (pageNum > 3 && nlist.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= nlist.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(nlist.getPages() - 4);
                pagenums.add(nlist.getPages() - 3);
                pagenums.add(nlist.getPages() - 2);
                pagenums.add(nlist.getPages() - 1);
                pagenums.add(nlist.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (nlist.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < nlist.getPages(); i++)
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
        mv.addObject("nlist", nlist);
        mv.setViewName("specialnews");
        return mv;
    }
}
