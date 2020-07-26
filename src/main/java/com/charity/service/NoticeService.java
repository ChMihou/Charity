package com.charity.service;

import com.charity.entity.Jsoncheck;
import com.charity.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NoticeService {

    //根据关键字查询数据news
    public List<Notice> SelectNotice1(Notice notice,int pageNum,int pageSize);

    //根据关键字查询数据project
    public List<Notice> SelectNotice2(Notice notice,int pageNum,int pageSize);

    //根据关键字查询数据special
    public List<Notice> SelectNotice3(Notice notice,int pageNum,int pageSize);

    //根据关键字查询数据news,审核过的
    public List<Notice> SelectreadNotice1(Notice notice,int pageNum,int pageSize);

    //根据关键字查询数据project，审核过的
    public List<Notice> SelectreadNotice2(Notice notice,int pageNum,int pageSize);

    //根据关键字查询数据special，审核过的
    public List<Notice> SelectreadNotice3(Notice notice,int pageNum,int pageSize);

    public Notice SelectNoticeId(Integer id);

    public Boolean updateNotice1(Notice notice);

    public Boolean updateNotice2(Notice notice);

    //添加爱心时讯文章
    public Boolean addNotice(Notice notice);

    public Boolean deleteOneNotice(@Param("nid") Integer nid);

    //审核文章
    public  Boolean alterCheck(Jsoncheck jsoncheck);

    //开展项目
    public Integer CheckNotice();

    //增加文章捐款
    public Boolean donateNotice(Notice notice);

    //查询文章筹款
    public  Integer Selectdmoney(@Param("nid")Integer id);

    //查询文章筹款
    public  Integer Selectallmoney(@Param("nid") Integer id);

    //查找最新的一个专项扶持案例
    public Notice SelectLatestNotice();

    //查找所有图片
    public List<String> SelectAllImage(int pageNum,int pageSize);
}
