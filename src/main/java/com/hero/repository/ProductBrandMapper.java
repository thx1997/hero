package com.hero.repository;

import com.hero.entity.ProductBrand;

public interface ProductBrandMapper {
    int deleteByPrimaryKey(Integer pbId);

    int insert(ProductBrand record);

    int insertSelective(ProductBrand record);

    ProductBrand selectByPrimaryKey(Integer pbId);

    int updateByPrimaryKeySelective(ProductBrand record);

    int updateByPrimaryKey(ProductBrand record);
}