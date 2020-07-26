package com.charity.service;

import com.charity.entity.Email;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmailService {

    //查询所有邮件
    public List<Email> SelectAllEmail(int pageNum,int pageSize);

    //删除邮件
    public Boolean DeleteEmail(@Param("eid") Integer id);

    //保存email记录
    public Boolean InsertEmail(Email email);
}
