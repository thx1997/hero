package com.hero.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 系统Token令牌对象:存储用户信息 和用户权限信息
 * 当登录成功以后把Token令牌信息响应给客户端,
 * 服务器每次通过token 对请求进行 登录拦截,权限拦截
 * @Description:   Token令牌对象
 * @author         Mashuai 
 * @Date           2018-5-17 上午12:12:35  
 * @Email          1119616605@qq.com
 */
@JsonInclude(Include.NON_NULL)	//如果该属性为NULL则不参与序列化
public class Token {
	
	/**
	 * 用户Id
	 */
	private Integer userId;
	/**
	 * 角色Id集合
	 */
	private List<Integer> roleIdList;
	/**
	 * 用户拥有的权限集合
	 */
	private List<String> permissionValueList;
	
	
	
	
	public Token(Integer userId, List<Integer> roleIdList,
			List<String> permissionValueList) {
		super();
		this.userId = userId;
		this.roleIdList = roleIdList;
		this.permissionValueList = permissionValueList;
	}
	public Token(Integer userId, List<String> permissionValueList) {
		super();
		this.userId = userId;
		this.permissionValueList = permissionValueList;
	}
	public Token(List<String> permissionValueList) {
		super();
		this.permissionValueList = permissionValueList;
	}
	public Token() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Integer> getRoleIdList() {
		return roleIdList;
	}
	public void setRoleIdList(List<Integer> roleIdList) {
		this.roleIdList = roleIdList;
	}
	public List<String> getPermissionValueList() {
		return permissionValueList;
	}
	public void setPermissionValueList(List<String> permissionValueList) {
		this.permissionValueList = permissionValueList;
	}
	@Override
	public String toString() {
		return "Token [userId=" + userId + ", roleIdList=" + roleIdList
				+ ", permissionValueList=" + permissionValueList + "]";
	}
	
	
	
	
	
	
	
	
	

}
