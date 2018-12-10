package com.hero.service;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.hero.entity.Module;


public interface ModuleService {
	
	/**
	 * 给角色设置模块，已拥有角色处选中状态
	 * @author thx
	 * @param rid 角色编号
	 * @return
	 */
	public 	List<Module> queryModuleChecked(List<Integer> rid);
	/**
	 * 根据角色编号查询出所拥有的模块编号
	 * @author thx
	 * @param rid 角色编号集合
	 * @return 模块编号集合
	 */
	public List<Integer> selectMidByRid(List<Integer> rid);
	
	// 根据父id和角色id查询角色拥有的模块信息(rfy)
	public List<Module> queryModuleByPidRid(int pid, List<Integer> rids);
	// 查询左侧菜单树(rfy)
	public List<Module> queryModuleTreeByRid(List<Integer> rids);
	
	
	
	
	//查询出父模块对应的子模块（thx&rfy）
	public List<Module> queryChildrenById(Integer parentId);
	//查询所有父模块
	public List<Module> queryParent(Module m);
	// 查询模块 TreeGrid 树形数据表格,所有模块信息
	public List<Module> queryModuleTree(Module m);
	//查询总记录数
  	public int queryAllCount();
	
	
	//根据模块id查询模块信息
	public List<Module> queryTreeGridModuleByIds(Set<Integer> rootIds);
	//根据名称查询模块编号
	public List<Integer> queryModuleIdsByModuleNameLike(Module m);
	//查询模块的父id
	public Integer queryParentIdByModuleId(Integer moduleId);
	//查询总记录数
	public int queryCount(String name);
	//模糊查询模块
	public List<Module> queryModuleByName(Module m);
	public List<Module> queryMenuTreeChildrenById(Integer parentId, List<Integer> moduleIds);
	
	
	
	 //添加模块信息（rfy）
    int insertSelective(Module record);
    //根据模块名称和父id判断模块是否存在
    public int isExitByNameAndPid(String mname,Integer pid);
	
    //修改模块信息（rfy）
    int updateByPrimaryKeySelective(Module record);
    //根据模块id查询模块信息(rfy)
    Module selectByPrimaryKey(Integer mId);
	
    
    
    //根据模块id查询其子模块（rfy）
  	public List<Module> selectMoudleByMid(Integer mid);
  	//级联删除模块（rfy）
  	public int delModule(Integer mid);
    //查询模块是否存在角色关联（rfy）
  	public int isExitRoleBymid(Integer mid);
    //删除模块（rfy）
    int deleteByPrimaryKey(Integer mId);
	
}
