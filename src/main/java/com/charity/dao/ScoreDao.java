package com.charity.dao;

import com.charity.entity.Score;
import com.charity.entity.UserScoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ScoreDao {
    //查询用户积分记录
    public List<UserScoreVo> selectPersonScore(@Param("suid") Integer Suid);

    //修改用户积分
    public Integer updatescore(Score score);

    //删除用户积分记录
    public Boolean deletescore(Integer sid);

    //更新积分记录
    public Boolean updateOne(Score score);

    //根据编号查询积分记录
    public Score selectIdScore(@Param("sid") Integer sid);
}
