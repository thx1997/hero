package com.hero.repository;

import com.hero.entity.BreakageOverflowDetail;

public interface BreakageOverflowDetailMapper {
    int deleteByPrimaryKey(Integer bodId);

    int insert(BreakageOverflowDetail record);

    int insertSelective(BreakageOverflowDetail record);

    BreakageOverflowDetail selectByPrimaryKey(Integer bodId);

    int updateByPrimaryKeySelective(BreakageOverflowDetail record);

    int updateByPrimaryKey(BreakageOverflowDetail record);
}