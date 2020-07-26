package com.charity.dao;

import com.charity.entity.Jsoncheck;
import com.charity.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeDao {

    //根据关键字查询数据news
    public List<Notice> SelectNotice1(Notice notice);

    //根据关键字查询数据project
    public List<Notice> SelectNotice2(Notice notice);

    //根据关键字查询数据special
    public List<Notice> SelectNotice3(Notice notice);

    //根据关键字查询数据news,审核过的
    public List<Notice> SelectreadNotice1(Notice notice);

    //根据关键字查询数据project，审核过的
    public List<Notice> SelectreadNotice2(Notice notice);

    //根据关键字查询数据special，审核过的
    public List<Notice> SelectreadNotice3(Notice notice);

    //根据文章id查询文章
    public Notice SelectNoticeId(@Param("nid")Integer id);

    //修改文章信息
    public Boolean updateNotice1(Notice notice);

    //修改文章信息
    public Boolean updateNotice2(Notice notice);

    //添加文章
    public Boolean addNotice(Notice notice);

    //根据文章id删除文章
    public Boolean deleteOneNotice(@Param("nid") Integer nid);

    //审核文章
    public  Boolean alterCheck(Jsoncheck jsoncheck);

    //开展项目
    public Integer CheckNotice();

    //增加文章捐款
    public Boolean donateNotice(Notice notice);

    //查询文章筹款
    public  Integer Selectdmoney(@Param("nid") Integer id);

    //查询文章筹款
    public  Integer Selectallmoney(@Param("nid") Integer id);

    //查找最新的一个专项扶持案例
    public Notice SelectLatestNotice();

    //查找所有图片
    public List<String> SelectAllImage();
}
