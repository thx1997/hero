package com.hero.repository;

import com.hero.entity.DeliveryDetail;

public interface DeliveryDetailMapper {
    int deleteByPrimaryKey(Integer ddId);

    int insert(DeliveryDetail record);

    int insertSelective(DeliveryDetail record);

    DeliveryDetail selectByPrimaryKey(Integer ddId);

    int updateByPrimaryKeySelective(DeliveryDetail record);

    int updateByPrimaryKey(DeliveryDetail record);
}