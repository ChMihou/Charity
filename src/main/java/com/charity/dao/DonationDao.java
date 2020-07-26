package com.charity.dao;

import com.charity.entity.Donation;
import com.charity.entity.UserDonationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DonationDao {

    //查询收到物资总数
    public Integer CheckDonation();

    //收到的善款总数
    public Integer CheckDMoney();

    //查找所有物资
    public List<UserDonationVo> SelectAllDonation(@Param("duid") Integer Duid);

    //查找某个用户的捐赠物资
    public Donation SelectNameDonation(@Param("did") Integer duid);

    //添加某个用户的物资
    public Boolean AddDonation(Donation donation);

    //删除某个用户的物资
    public Boolean DeleteDonation(@Param("did") Integer id);

    //更新物资流向信息
    public Boolean UpdateDonation(Donation donation);

    //根据编号查询物资记录
    public Donation SelectIdDonation(@Param("did")Integer did);

    //根据文章编号查询物资记录
    public List<UserDonationVo> SelectNIdDonation(@Param("dnid")Integer dnid);
}
