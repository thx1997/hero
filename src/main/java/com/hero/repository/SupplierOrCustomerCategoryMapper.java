package com.hero.repository;

import java.util.List;
import com.hero.entity.SupplierOrCustomerCategory;
import com.hero.entity.query.SupplierOrCustomerCategoryQuery;


public interface SupplierOrCustomerCategoryMapper {
	//删除类别（rfy）
    int deleteByPrimaryKey(Integer scId);

    int insert(SupplierOrCustomerCategory record);

    //添加类别信息（rfy）
    int insertSelective(SupplierOrCustomerCategory record);

    SupplierOrCustomerCategory selectByPrimaryKey(Integer scId);
    
    //修改类别信息(rfy)
    int updateByPrimaryKeySelective(SupplierOrCustomerCategory record);

    int updateByPrimaryKey(SupplierOrCustomerCategory record);
    //根据stype查询所有类别信息(rfy)
    public List<SupplierOrCustomerCategory> selectAllCate(Integer stype);
   //多条件分页查询供应商客户类别信息(rfy)
    public List<SupplierOrCustomerCategory> selectAllByCount(SupplierOrCustomerCategoryQuery scquery);
    //查询分页总记录数(rfy)
    public int selectCount(SupplierOrCustomerCategoryQuery scquery);
    //根据名称查询是否已存在(rfy)
    public int isExitByName(String name);
}