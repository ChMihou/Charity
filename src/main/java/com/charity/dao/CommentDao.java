package com.charity.dao;

import com.charity.entity.Comment;
import com.charity.entity.UserCommentNoticeVo;
import com.charity.entity.UserCommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {

    //查询所有评论留言
    public List<UserCommentNoticeVo> SelectAllComment();

    //查询平台留言
    public List<UserCommentVo> SelectComment();

    //根据文章id查询评论留言
    public List<UserCommentVo> SelectComentId(@Param("cnid") Integer id);

    //插入评论留言
    public Boolean InsertComment(Comment comment);

    //根据Id删除留言
    public Boolean DeleteComent(@Param("cid") Integer id);

    //回复评论
    public Boolean UpdateApply(Comment comment);
}
