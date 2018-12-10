package com.hero.repository;

import com.hero.entity.StorehouseDetail;

public interface StorehouseDetailMapper {
    int deleteByPrimaryKey(Integer sdId);

    int insert(StorehouseDetail record);

    int insertSelective(StorehouseDetail record);

    StorehouseDetail selectByPrimaryKey(Integer sdId);

    int updateByPrimaryKeySelective(StorehouseDetail record);

    int updateByPrimaryKey(StorehouseDetail record);
}