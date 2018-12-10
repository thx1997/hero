package com.hero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.SupplierOrCustomerCategory;
import com.hero.entity.query.SupplierOrCustomerCategoryQuery;
import com.hero.repository.SupplierOrCustomerCategoryMapper;
import com.hero.service.SupplierOrCustomerCategoryService;
@Service
public class SupplierOrCustomerCategoryServiceImpl implements SupplierOrCustomerCategoryService {

	@Autowired
	private SupplierOrCustomerCategoryMapper supplierOrCustomerCategoryMapper;

	@Override//(rfy)
	public List<SupplierOrCustomerCategory> selectAllCate(Integer stype) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.selectAllCate(stype);
	}

	@Override
	public List<SupplierOrCustomerCategory> selectAllByCount(SupplierOrCustomerCategoryQuery scquery) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.selectAllByCount(scquery);
	}

	@Override
	public int selectCount(SupplierOrCustomerCategoryQuery scquery) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.selectCount(scquery);
	}

	@Override
	public int insertSelective(SupplierOrCustomerCategory record) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(SupplierOrCustomerCategory record) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer scId) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.deleteByPrimaryKey(scId);
	}

	@Override
	public int isExitByName(String name) {
		// TODO Auto-generated method stub
		return supplierOrCustomerCategoryMapper.isExitByName(name);
	}
	
	
}
