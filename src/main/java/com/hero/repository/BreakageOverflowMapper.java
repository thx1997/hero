package com.hero.repository;

import com.hero.entity.BreakageOverflow;

public interface BreakageOverflowMapper {
    int deleteByPrimaryKey(Integer boId);

    int insert(BreakageOverflow record);

    int insertSelective(BreakageOverflow record);

    BreakageOverflow selectByPrimaryKey(Integer boId);

    int updateByPrimaryKeySelective(BreakageOverflow record);

    int updateByPrimaryKey(BreakageOverflow record);
}