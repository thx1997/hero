package com.hero.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hero.entity.Employee;
import com.hero.entity.Role;
import com.hero.entity.query.EmployeeQuery;
/**
 * 
 * @author thx
 *
 */
public interface EmployeeMapper {
	/**
	 * 多条件分页查询员工
	 * @param employeeQuery 条件封装成的实体
	 * @return 满足条件的员工集合
	 */
	public List<Employee> queryEmp(EmployeeQuery employeeQuery);
	/**
	 * 多条件分页查询员工
	 * @param employeeQuery 条件封装成的实体
	 * @return 满足条件的员工集合的总条数
	 */
	public int queryEmpCount(EmployeeQuery employeeQuery);	

    /**
     * 添加新员工
     * @param record 新目标
     * @return 受影响的行数
     */
    int insertSelective(Employee record);
    /**
     * 修改员工资料
     * @param record 修改条件封装的实体
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(Employee record);
    /**
     * 根据员工编号查询已经拥有的角色集合
     * @param eid 员工编号
     * @return  角色集合
     */
     public List<Role> queryEmpHaveRole(int eid);
    /**
     * 跟据编号删除某个员工
     * @param eid 要删除目标的编号
     * @return 受影响的行数
     */
    public int delEmpByeid(int eid);
    /**
     * 重置密码(thx)
     * @param pwd 经过加密后的密码
     * @param eid 员工编号
     * @return 受影响的行数
     */
    public int resetPwd(@Param("pwd")String pwd,@Param("eid")int eid);
    /**
     * 根据编号锁定解锁(thx)
     * @param eid 员工编号
     * @param uIsLockout (0:否：1是)
     * @return 受影响的行数
     */
    public int lockEmp(@Param("eid")Integer eid,@Param("uIsLockout")Integer uIsLockout);
    /**
     * 根据员工编号移除他的所有角色(thx)
     * @param eid 员工编号
     * @return 受影响的行数
     */
    public int delRE(int eid);
    /**
     * 为某个员工设置角色(thx)
     * @param eid 员工编号
     * @param rids 角色编号集合
     * @return 受影响的行数
     */
    public int addRe(@Param("eid")int eid,@Param("rids") List<Integer> rids);
    //更新用户信息：锁定解锁、锁定时间、登录时间、密码错误次数（rfy）
    int updateBySelective(Employee record);
    //根据员工登录名获取员工信息（rfy）
    public Employee getEmpByEloginname(String ename);
    
    int insert(Employee record);
    int deleteByPrimaryKey(Integer eId);
    Employee selectByPrimaryKey(Integer eId);
    

    int updateByPrimaryKey(Employee record);
}