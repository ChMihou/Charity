package com.charity.service.impl;

import com.charity.dao.ScoreDao;
import com.charity.entity.Score;
import com.charity.entity.UserScoreVo;
import com.charity.service.ScoreService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScoreServiceimpl implements ScoreService {

    @Resource
    private ScoreDao scoreDao;

    @Override
    public List<UserScoreVo> selectPersonScore(Integer Suid,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return scoreDao.selectPersonScore(Suid);
    }

    @Override
    public Integer updatescore(Score score) {
        return scoreDao.updatescore(score);
    }

    @Override
    public Boolean deletescore(Integer sid) {
        return scoreDao.deletescore(sid);
    }

    @Override
    public Boolean updateOne(Score score) {
        return scoreDao.updateOne(score);
    }

    @Override
    public Score selectIdScore(Integer sid) {
        return scoreDao.selectIdScore(sid);
    }
}
