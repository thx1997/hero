package com.hero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.Node;
import com.hero.entity.Role;
import com.hero.entity.query.QueryBase;
import com.hero.entity.query.RoleQuery;
import com.hero.repository.PermissionMapper;
import com.hero.repository.RoleMapper;
import com.hero.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	private PermissionMapper permissionMapper;
	@Override//thx
	public List<Role> queryRole(RoleQuery roleQuery) {
		return roleMapper.queryRole(roleQuery);
	}

	@Override//thx
	public int queryRoleCount(RoleQuery roleQuery) {
		return roleMapper.queryRoleCount(roleQuery);
	}
	@Override // rfy
	public List<Integer> getRoleIdByeid(int eid) {
		return roleMapper.getRoleIdByeid(eid);
	}

	@Override // rfy
	public List<Role> getRoleByEid(int eid) {
		return roleMapper.getRoleByEid(eid);
	}
	@Override//thx
	public List<Role> queryAllRole(QueryBase queryBase) {
		return roleMapper.queryAllRole(queryBase);
	}
	@Override//thx
	public int queryAllRoleCount(QueryBase queryBase) {
		return roleMapper.queryAllRoleCount(queryBase);
	}
	@Override//thx
	public int delRoleModule(int rid) {
		return roleMapper.delRoleModule(rid);
	}

	@Override//thx
	public int addRoleModule(int rid, List<Integer> mids) {
		return roleMapper.addRoleModule(rid, mids);
	}
	@Override//thx
	public List<Node> queryRoleSetPermission(List<Integer> roleIds) {
		System.out.println("serviceImpl参数"+roleIds);
		List<Integer> permissionIds = permissionMapper.queryPermissionIdsByRoleIds(roleIds);//查询出角色拥有的权限Ids
		List<Node> permissionTree = permissionMapper.queryNode();//查询出所有的权限树
		//把角色拥有的权限树设置为选中
		this.setPermissionTreeChecked(permissionTree, permissionIds);
		return permissionTree;
	}
	/**
	 * 把角色拥有的权限树设置为选中
	 * @author thx
	 * @param permissionTree
	 * @param permissionIds
	 */
	private void setPermissionTreeChecked(List<Node> permissionTree,List<Integer> permissionIds){
		for(Node module:permissionTree){//遍历出所有权限所属模块
			for(Node p:module.getChildren()){//遍历出所有权限节点
				if(permissionIds.contains(p.getId()))
					p.setChecked(true);//角色拥有的权限勾选中
				
			}
			
		}
	}
	@Override//wxk
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override//wxk
	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	

	@Override//wxk
	public int delRoleByrid(int rid) {
		return roleMapper.delRoleByrid(rid);
	}

	@Override
	public List<Role> queryAllRoles() {
		return roleMapper.queryAllRoles();
	}

	

}
