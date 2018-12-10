package com.hero.repository;

import com.hero.entity.StorePartition;

public interface StorePartitionMapper {
    int deleteByPrimaryKey(Integer spId);

    int insert(StorePartition record);

    int insertSelective(StorePartition record);

    StorePartition selectByPrimaryKey(Integer spId);

    int updateByPrimaryKeySelective(StorePartition record);

    int updateByPrimaryKey(StorePartition record);
}