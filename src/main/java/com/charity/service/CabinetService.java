package com.charity.service;

import com.charity.entity.Cabinet;

import java.util.List;

public interface CabinetService {

    //查询条件符合的所有公益柜
    public List<Cabinet> SelectAllCabinet(Cabinet cabinet,int pageNum,int pageSize);

    //添加公益柜
    public Boolean addCabinet(Cabinet cabinet);

    //根据Id删除公益柜
    public Boolean deleteIdCabinet(Integer id);

    //修改公益柜信息
    public Boolean updateCabinet(Cabinet cabinet);
}
