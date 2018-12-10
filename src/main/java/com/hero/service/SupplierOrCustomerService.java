package com.hero.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hero.entity.SupplierOrCustomer;
import com.hero.entity.query.SupplierOrCustomerQuery;

public interface SupplierOrCustomerService {
	//多条件分页查询供应商客户信息(rfy)
    public List<SupplierOrCustomer> selectAllByCount(SupplierOrCustomerQuery scquery);
    //查询分页总记录数(rfy)
    public int selectCount(SupplierOrCustomerQuery scquery);
    //添加（rfy）
    int insertSelective(SupplierOrCustomer record);
    //修改（rfy）
    int updateByPrimaryKeySelective(SupplierOrCustomer record);
    //软删（rfy）
    public int updexit(Integer sId);
    //根据名称查询是否已存在(rfy)
    public int isExitByName(String name);
    //批量修改供应商、客户的类别（rfy）
    public int updBatch(int cateid,List<Integer> sid);
    //根据编号查询供货商客户信息（rfy）
  	public List<SupplierOrCustomer> getSupplierOrCustomerBySid(@Param("list")List<Integer> sList);
}
