package com.hero.repository;

import com.hero.entity.ChangeStorehouse;

public interface ChangeStorehouseMapper {
    int deleteByPrimaryKey(Integer cshId);

    int insert(ChangeStorehouse record);

    int insertSelective(ChangeStorehouse record);

    ChangeStorehouse selectByPrimaryKey(Integer cshId);

    int updateByPrimaryKeySelective(ChangeStorehouse record);

    int updateByPrimaryKey(ChangeStorehouse record);
}