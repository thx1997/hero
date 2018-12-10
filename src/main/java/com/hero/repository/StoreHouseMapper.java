package com.hero.repository;

import com.hero.entity.StoreHouse;

public interface StoreHouseMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(StoreHouse record);

    int insertSelective(StoreHouse record);

    StoreHouse selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(StoreHouse record);

    int updateByPrimaryKey(StoreHouse record);
}