package com.charity.service.impl;

import com.charity.dao.NoticeDao;
import com.charity.entity.Jsoncheck;
import com.charity.entity.Notice;
import com.charity.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceimpl implements NoticeService {

    @Resource
    NoticeDao noticeDao;


    @Override
    public List<Notice> SelectNotice1(Notice notice,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectNotice1(notice);
    }

    @Override
    public List<Notice> SelectNotice2(Notice notice,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectNotice2(notice);
    }

    @Override
    public List<Notice> SelectNotice3(Notice notice,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectNotice3(notice);
    }

    @Override
    public List<Notice> SelectreadNotice1(Notice notice,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectreadNotice1(notice);
    }

    @Override
    public List<Notice> SelectreadNotice2(Notice notice,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectreadNotice2(notice);
    }

    @Override
    public List<Notice> SelectreadNotice3(Notice notice,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectreadNotice3(notice);
    }

    @Override
    public Notice SelectNoticeId(Integer id) {
        return noticeDao.SelectNoticeId(id);
    }

    @Override
    public Boolean updateNotice1(Notice notice) {
        return noticeDao.updateNotice1(notice);
    }

    @Override
    public Boolean updateNotice2(Notice notice) {
        return noticeDao.updateNotice2(notice);
    }

    @Override
    public Boolean addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }

    @Override
    public Boolean deleteOneNotice(Integer nid) {
        return noticeDao.deleteOneNotice(nid);
    }

    @Override
    public Boolean alterCheck(Jsoncheck jsoncheck) {
        return noticeDao.alterCheck(jsoncheck);
    }

    @Override
    public Integer CheckNotice() {
        return noticeDao.CheckNotice();
    }

    @Override
    public Boolean donateNotice(Notice notice) {
        return noticeDao.donateNotice(notice);
    }

    @Override
    public Integer Selectdmoney(Integer id) {
        return noticeDao.Selectdmoney(id);
    }

    @Override
    public Integer Selectallmoney(Integer id) {
        return noticeDao.Selectallmoney(id);
    }

    @Override
    public Notice SelectLatestNotice() {
        return noticeDao.SelectLatestNotice();
    }

    @Override
    public List<String> SelectAllImage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.SelectAllImage();
    }
}
