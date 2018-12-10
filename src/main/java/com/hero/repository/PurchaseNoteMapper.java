package com.hero.repository;

import com.hero.entity.PurchaseNote;

public interface PurchaseNoteMapper {
    int deleteByPrimaryKey(String pnId);

    int insert(PurchaseNote record);

    int insertSelective(PurchaseNote record);

    PurchaseNote selectByPrimaryKey(String pnId);

    int updateByPrimaryKeySelective(PurchaseNote record);

    int updateByPrimaryKey(PurchaseNote record);
}