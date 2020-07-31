package com.charity.service.impl;

import com.charity.dao.AwardDao;
import com.charity.entity.Award;
import com.charity.entity.UserAwardVo;
import com.charity.service.AwardService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("AwardService")
public class AwadServiceimpl implements AwardService {

    @Resource
    AwardDao awardDao;

    @Override
    public List<UserAwardVo> SelectPersonAward(Integer id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return awardDao.SelectPersonAward(id);
    }

    @Override
    public Boolean AddAward(Award award) {
        return awardDao.AddAward(award);
    }

    @Override
    public Boolean deleteAward(Integer id) {
        return awardDao.deleteAward(id);
    }

    @Override
    public Boolean UpdateAcomment(Award award) {
        return awardDao.UpdateAcomment(award);
    }
}
