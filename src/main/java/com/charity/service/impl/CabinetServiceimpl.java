package com.charity.service.impl;

import com.charity.dao.CabinetDao;
import com.charity.entity.Cabinet;
import com.charity.service.CabinetService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CabinetServiceimpl implements CabinetService {

    @Resource
    private CabinetDao cabinetDao;

    @Override
    public List<Cabinet> SelectAllCabinet(Cabinet cabinet, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return cabinetDao.SelectAllCabinet(cabinet);
    }

    @Override
    public Boolean addCabinet(Cabinet cabinet) {
        return cabinetDao.addCabinet(cabinet);
    }

    @Override
    public Boolean deleteIdCabinet(Integer id) {
        return cabinetDao.deleteIdCabinet(id);
    }

    @Override
    public Boolean updateCabinet(Cabinet cabinet) {
        return cabinetDao.updateCabinet(cabinet);
    }
}
