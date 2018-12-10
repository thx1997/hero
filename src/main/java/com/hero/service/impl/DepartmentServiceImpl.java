package com.hero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.Department;
import com.hero.entity.query.DepartmentQuery;
import com.hero.repository.DepartmentMapper;
import com.hero.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
	@Override//thx
	public List<Department> queryDep(DepartmentQuery departmentQuery) {
		return departmentMapper.queryDep(departmentQuery);
	}

	@Override//thx
	public int queryDepCount(DepartmentQuery departmentQuery) {
		return departmentMapper.queryDepCount(departmentQuery);
	}

	@Override//thx
	public List<Department> queryAllDep() {
		return departmentMapper.queryAllDep();
	}

	@Override//thx
	public int insertSelective(Department record) {
		return departmentMapper.insertSelective(record);
	}

	@Override//thx
	public int updateByPrimaryKeySelective(Department record) {
		return departmentMapper.updateByPrimaryKeySelective(record);
	}

	@Override//thx
	public int deleteByPrimaryKey(Integer dId) {
		return departmentMapper.deleteByPrimaryKey(dId);
	}

}
