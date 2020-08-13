package com.charity.controller;

import com.charity.common.Paginator;
import com.charity.entity.Cabinet;
import com.charity.model.AuthToken;
import com.charity.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CabinetController {
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

    @RequestMapping("cabinet")
    @AuthToken
    public ModelAndView cabinet(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
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
        Paginator.page(pagenums,clist,pageNum,pageSize);
        mv.addObject("pagenums", pagenums);
        mv.addObject("clist", clist);
        mv.setViewName("cabinet");
        return mv;
    }

    @RequestMapping("edit-cabinet")
    @AuthToken
    public ModelAndView editcabinet(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Integer cid = Integer.valueOf(request.getParameter("id"));
        Cabinet cabinet = new Cabinet();
        cabinet.setCid(cid);
        List<Cabinet> clist = cabinetService.SelectAllCabinet(cabinet, pageNum, pageSize);
        mv.addObject("clist", clist);
        mv.setViewName("edit-cabinet");
        return mv;
    }

    @RequestMapping("add-cabinet")
    @AuthToken
    public ModelAndView addabinet() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-cabinet");
        return mv;
    }

    @RequestMapping("addcabinet")
    @ResponseBody
    @AuthToken
    public Boolean addcabinet(String cname, String province, String country, String area, String city, HttpServletRequest request) {
        Cabinet cabinet = new Cabinet();
        String caddress = province + city + area + country;
        cabinet.setCaddress(caddress);
        cabinet.setCname(cname);
        Boolean i = cabinetService.addCabinet(cabinet);
        if (i)
            return true;
        else
            return false;
    }

    @RequestMapping("editcabinet")
    @ResponseBody
    @AuthToken
    public Boolean editcabinet(Integer cid, String cname, String province, String country, String area, String city, HttpServletRequest request) {
        Cabinet cabinet = new Cabinet();
        String caddress = province + city + area + country;
        cabinet.setCaddress(caddress);
        cabinet.setCname(cname);
        cabinet.setCid(cid);
        Boolean i = cabinetService.updateCabinet(cabinet);
        if (i)
            return true;
        else
            return false;
    }

    @RequestMapping(value = "deleteCabinet", method = RequestMethod.POST)
    @ResponseBody
    @AuthToken
    public boolean deleteCabinet(String id) throws IOException {

        Integer cid = Integer.valueOf(id);

        boolean flag = cabinetService.deleteIdCabinet(cid);
        if (flag) {
            return true;     // 删除用户成功
        } else {
            return false;     // 删除用户失败
        }
    }

}
