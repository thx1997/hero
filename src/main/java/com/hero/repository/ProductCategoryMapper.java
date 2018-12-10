package com.hero.repository;

import com.hero.entity.ProductCategory;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer pcId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer pcId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}