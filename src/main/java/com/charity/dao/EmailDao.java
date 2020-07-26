package com.charity.dao;

import com.charity.entity.Email;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmailDao {

    //查询所有邮件
    public List<Email> SelectAllEmail();

    //删除邮件
    public Boolean DeleteEmail(@Param("eid") Integer id);

    //保存email记录
    public Boolean InsertEmail(Email email);
}
