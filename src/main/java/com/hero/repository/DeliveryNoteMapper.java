package com.hero.repository;

import com.hero.entity.DeliveryNote;

public interface DeliveryNoteMapper {
    int deleteByPrimaryKey(String dnId);

    int insert(DeliveryNote record);

    int insertSelective(DeliveryNote record);

    DeliveryNote selectByPrimaryKey(String dnId);

    int updateByPrimaryKeySelective(DeliveryNote record);

    int updateByPrimaryKey(DeliveryNote record);
}