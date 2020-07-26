package com.charity.service.impl;

import com.charity.dao.CommentDao;
import com.charity.entity.Comment;
import com.charity.entity.UserCommentNoticeVo;
import com.charity.entity.UserCommentVo;
import com.charity.service.CommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceimpl implements CommentService {

    @Resource
    CommentDao commentDao;

    @Override
    public List<UserCommentNoticeVo> SelectAllComment(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return commentDao.SelectAllComment();
    }

    @Override
    public List<UserCommentVo> SelectComment(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return commentDao.SelectComment();
    }

    @Override
    public List<UserCommentVo> SelectComentId(Integer id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return commentDao.SelectComentId(id);
    }

    @Override
    public Boolean InsertComment(Comment comment) {
        return commentDao.InsertComment(comment);
    }

    @Override
    public Boolean DeleteComent(Integer id) {
        return commentDao.DeleteComent(id);
    }

    @Override
    public Boolean UpdateApply(Comment comment) {
        return commentDao.UpdateApply(comment);
    }
}
