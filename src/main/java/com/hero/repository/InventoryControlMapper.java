package com.hero.repository;

import com.hero.entity.InventoryControl;

public interface InventoryControlMapper {
    int deleteByPrimaryKey(Integer icId);

    int insert(InventoryControl record);

    int insertSelective(InventoryControl record);

    InventoryControl selectByPrimaryKey(Integer icId);

    int updateByPrimaryKeySelective(InventoryControl record);

    int updateByPrimaryKey(InventoryControl record);
}