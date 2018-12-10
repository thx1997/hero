package com.hero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.Employee;
import com.hero.entity.Role;
import com.hero.entity.query.EmployeeQuery;
import com.hero.repository.EmployeeMapper;
import com.hero.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override//thx
	public int queryEmpCount(EmployeeQuery employeeQuery) {
		return employeeMapper.queryEmpCount(employeeQuery);
	}
	@Override//thx
	public List<Employee> queryEmp(EmployeeQuery employeeQuery) {
		return employeeMapper.queryEmp(employeeQuery);
	}
	@Override//thx
	public int insertSelective(Employee record) {
		return employeeMapper.insertSelective(record);
	}
	@Override//thx
	public int updateByPrimaryKeySelective(Employee record) {
		return employeeMapper.updateByPrimaryKeySelective(record);
	}
	@Override//thx
	public List<Role> queryEmpHaveRole(int eid) {
		return employeeMapper.queryEmpHaveRole(eid);
	}
	@Override//thx
	public int delEmpByeid(int eid) {
		return employeeMapper.delEmpByeid(eid);
	}
	@Override//thx
	public int resetPwd(String pwd, int eid) {
		return employeeMapper.resetPwd(pwd, eid);
	}
	@Override//thx
	public int lockEmp(Integer eid, Integer uIsLockout) {
		return employeeMapper.lockEmp(eid, uIsLockout);
	}
	@Override//thx
	public int delRE(int eid) {
		return employeeMapper.delRE(eid);
	}
	@Override//thx
	public int addRe(int eid, List<Integer> rids) {
		return employeeMapper.addRe(eid, rids);
	}
	@Override
	public Employee getEmpByEloginname(String ename) {
		return employeeMapper.getEmpByEloginname(ename);
	}
	@Override
	public int updateBySelective(Employee record) {
		return employeeMapper.updateBySelective(record);
	}
	
	

}
