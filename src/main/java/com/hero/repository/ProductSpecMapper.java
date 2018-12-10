package com.hero.repository;

import com.hero.entity.ProductSpec;

public interface ProductSpecMapper {
    int deleteByPrimaryKey(Integer psId);

    int insert(ProductSpec record);

    int insertSelective(ProductSpec record);

    ProductSpec selectByPrimaryKey(Integer psId);

    int updateByPrimaryKeySelective(ProductSpec record);

    int updateByPrimaryKey(ProductSpec record);
}