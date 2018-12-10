package com.hero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.Permission;
import com.hero.repository.PermissionMapper;
@Service
public class PermissionServiceImpl implements com.hero.service.PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	@Override//rfy
	public List<String> getPermissionValueByEid(int eid) {
		// TODO Auto-generated method stub
		return permissionMapper.getPermissionValueByEid(eid);
	}
	@Override//rfy
	public List<String> queryAll() {
		// TODO Auto-generated method stub
		return permissionMapper.queryAll();
	}
	@Override//rfy
	public int batchInsert(List<Permission> pList) {
		// TODO Auto-generated method stub
		return permissionMapper.batchInsert(pList);
	}
	@Override//rfy
	public int delPermission() {
		// TODO Auto-generated method stub
		return permissionMapper.delPermission();
	}

}
