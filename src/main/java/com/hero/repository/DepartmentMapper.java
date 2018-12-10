package com.hero.repository;

import java.util.List;

import com.hero.entity.Department;
import com.hero.entity.query.DepartmentQuery;

public interface DepartmentMapper {
	
	/**
	 * 多条件分页查询部门
	 * @param departmentQuery 条件封装成的实体
	 * @return 满足条件的部门集合
	 */
	public List<Department> queryDep(DepartmentQuery departmentQuery);
	/**
	 * 多条件分页查询部门
	 * @param departmentQuery 条件封装成的实体
	 * @return 满足条件的部门集合的总条数
	 */
	public int queryDepCount(DepartmentQuery departmentQuery);	
	/**
	 * 查询所有部门
	 * @return 部门集合
	 */
	public List<Department> queryAllDep();	
    /**
     * 添加新部门
     * @param record 条件封装的部门实体
     * @return 受影响的行数
     */
    int insertSelective(Department record);
	/**
	 * 更新部门信息
	 * @param record 修改后的目标对象
	 * @return 受影响的行数
	 * 
	 */
    int updateByPrimaryKeySelective(Department record);
	/**
	 * 根据编号删除部门
	 * @param dId  目标对象的编号
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Integer dId);

	
	
	
    int insert(Department record);


    Department selectByPrimaryKey(Integer dId);


    int updateByPrimaryKey(Department record);
}