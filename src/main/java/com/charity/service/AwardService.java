package com.charity.service;

import com.charity.entity.Award;
import com.charity.entity.UserAwardVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AwardService {

    public List<UserAwardVo> SelectPersonAward(@Param("auid") Integer id,int pageNum,int pageSize);

    //添加获奖情况
    public Boolean AddAward(Award award);

    //删除获奖选项
    public  Boolean deleteAward(@Param("aid") Integer id);

    //填写寄语
    public Boolean UpdateAcomment(Award award);

}
