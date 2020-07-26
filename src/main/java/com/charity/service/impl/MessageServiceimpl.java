package com.charity.service.impl;

import com.charity.dao.MessageDao;
import com.charity.entity.Message;
import com.charity.service.MessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("messageservice")
public class MessageServiceimpl implements MessageService {

    @Resource
    private MessageDao messageDao;

    public List<Message> CheckoneMessage(Message message,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return messageDao.CheckoneMessage(message);
    }

    public List<Message> CheckallMessage(Message message,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return messageDao.CheckallMessage(message);
    }

    @Override
    public Boolean deleteOneMessage(Integer mid) {
        return messageDao.deleteOneMessage(mid);
    }

    @Override
    public Message CheckIdMessage(Integer mid) {
        return messageDao.CheckIdMessage(mid);
    }

    @Override
    public Boolean addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public Boolean addapply(Message message) {
        return messageDao.addapply(message);
    }


}
