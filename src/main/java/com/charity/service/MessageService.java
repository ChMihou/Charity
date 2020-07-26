package com.charity.service;

import com.charity.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageService {

    //查询单用户所有留言
    public List<Message> CheckoneMessage(Message message,int pageNum,int pageSize);

    //查询所有用户留言
    public List<Message> CheckallMessage(Message message,int pageNum,int pageSize);

    //删除留言
    public Boolean deleteOneMessage(Integer mid);

    //根据id查看单条留言
    public Message CheckIdMessage(@Param("mid") Integer mid);

    //增加某条留言
    public Boolean addMessage(Message message);

    //回复留言
    public Boolean addapply(Message message);

}
