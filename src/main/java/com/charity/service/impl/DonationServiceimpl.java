package com.charity.service.impl;

import com.charity.dao.DonationDao;
import com.charity.entity.Donation;
import com.charity.entity.UserDonationVo;
import com.charity.service.DonationService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DonationServiceimpl implements DonationService {

    @Resource
    private DonationDao donationDao;

    @Override
    public Integer CheckDonation() {
        return donationDao.CheckDonation();
    }

    @Override
    public Integer CheckDMoney() {
        return donationDao.CheckDMoney();
    }

    @Override
    public List<UserDonationVo> SelectAllDonation(Integer duid,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return donationDao.SelectAllDonation(duid);
    }

    @Override
    public Donation SelectNameDonation(Integer did) {
        return donationDao.SelectNameDonation(did);
    }

    @Override
    public Boolean AddDonation(Donation donation) {
        return donationDao.AddDonation(donation);
    }

    @Override
    public Boolean DeleteDonation(Integer did) {
        return donationDao.DeleteDonation(did);
    }

    @Override
    public Boolean UpdateDonation(Donation donation) {
        return donationDao.UpdateDonation(donation);
    }

    @Override
    public Donation SelectIdDonation(Integer did) {
        return donationDao.SelectIdDonation(did);
    }

    @Override
    public List<UserDonationVo> SelectNIdDonation(Integer dnid,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return donationDao.SelectNIdDonation(dnid);
    }
}
