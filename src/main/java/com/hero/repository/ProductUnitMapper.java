package com.hero.repository;

import com.hero.entity.ProductUnit;

public interface ProductUnitMapper {
    int deleteByPrimaryKey(Integer puId);

    int insert(ProductUnit record);

    int insertSelective(ProductUnit record);

    ProductUnit selectByPrimaryKey(Integer puId);

    int updateByPrimaryKeySelective(ProductUnit record);

    int updateByPrimaryKey(ProductUnit record);
}