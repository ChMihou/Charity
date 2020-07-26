package com.charity.dao;

import com.charity.entity.Award;
import com.charity.entity.UserAwardVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AwardDao {

    //查询用户的获奖情况
    public List<UserAwardVo> SelectPersonAward(@Param("auid") Integer id);

    //添加获奖情况
    public Boolean AddAward(Award award);

    //删除获奖选项
    public  Boolean deleteAward(@Param("aid") Integer id);

    //填写寄语
    public Boolean UpdateAcomment(Award award);
}
