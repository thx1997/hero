package com.hero.repository;

import com.hero.entity.PurchaseDetail;

public interface PurchaseDetailMapper {
    int deleteByPrimaryKey(Integer pdId);

    int insert(PurchaseDetail record);

    int insertSelective(PurchaseDetail record);

    PurchaseDetail selectByPrimaryKey(Integer pdId);

    int updateByPrimaryKeySelective(PurchaseDetail record);

    int updateByPrimaryKey(PurchaseDetail record);
}