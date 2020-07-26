package com.charity.service.impl;

import com.charity.dao.EmailDao;
import com.charity.entity.Email;
import com.charity.service.EmailService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmailServiceimpl implements EmailService {

    @Resource
    EmailDao emailDao;

    @Override
    public List<Email> SelectAllEmail(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return emailDao.SelectAllEmail();
    }

    @Override
    public Boolean DeleteEmail(Integer id) {
        return emailDao.DeleteEmail(id);
    }

    @Override
    public Boolean InsertEmail(Email email) {
        return emailDao.InsertEmail(email);
    }
}
