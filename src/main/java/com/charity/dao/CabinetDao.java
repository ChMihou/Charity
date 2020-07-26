package com.charity.dao;

import com.charity.entity.Cabinet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CabinetDao {

    //查询条件符合的所有公益柜
    public List<Cabinet> SelectAllCabinet(Cabinet cabinet);

    //添加公益柜
    public Boolean addCabinet(Cabinet cabinet);

    //根据Id删除公益柜
    public Boolean deleteIdCabinet(@Param("cid") Integer id);

    //修改公益柜信息
    public Boolean updateCabinet(Cabinet cabinet);

}
