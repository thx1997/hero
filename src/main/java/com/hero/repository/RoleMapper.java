package com.hero.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hero.entity.Role;
import com.hero.entity.query.QueryBase;
import com.hero.entity.query.RoleQuery;

public interface RoleMapper {
	/**
 	 * 多条件分页查询角色
 	 * @author thx
 	 * @param roleQuery 条件封装成的实体
 	 * @return 满足条件的角色集合
 	 */
 	public List<Role> queryRole(RoleQuery roleQuery);
 	/**
 	 * 多条件分页查询角色
 	 * @author thx
 	 * @param roleQuery 条件封装成的实体
 	 * @return 满足条件的角色集合的总条数
 	 */
 	public int queryRoleCount(RoleQuery roleQuery);
 	/**
 	 * 移除指定角色管理的所有模块（操作中间表而已）
 	 * @author thx
 	 * @param rid 角色编号
 	 * @return 受影响的行数
 	 */
	public int delRoleModule(int rid);
	/**
	 * 为指定角色设置管理模块
	 * @author thx
	 * @param rid 角色编号
	 * @param mids 模块编号集合
	 * @return 受影响的行数
	 */
	public int addRoleModule(@Param("rid")int rid,@Param("mids") List<Integer> mids);
	
	/**
	 * 修改角色
	 * 
	 * @param record
	 *            修改条件封装的实体
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Role record);

    //根据用户编号查询用户的角色编号(rfy)
  	public List<Integer> getRoleIdByeid(int eid);
  	//根据用户编号查询查询用户所拥有的角色(rfy)
  	public List<Role> getRoleByEid(int eid);
  	/**
  	 * 查询所有角色
  	 * @author thx
  	 * @param queryBase 分页条件
  	 * @return 角色集合
  	 */  	
  	public List<Role> queryAllRole(QueryBase queryBase);
  	/**
  	 * 查询所有角色
  	 * @author thx
  	 * @param queryBase 分页条件
  	 * @return 角色集合总条数
  	 */  
  	public int queryAllRoleCount(QueryBase queryBase);
  	
	/**
	 * 添加新角色
	 * 
	 * @param record
	 *            新目标
	 * @return 受影响的行数
	 */
	int insertSelective(Role record);
     
 	 /**
     * 跟据编号删除某个角色
     * @param rid 要删除目标的编号
     * @return 受影响的行数
     */
    public int delRoleByrid(int rid);
	List<Role> queryAllRoles();
}