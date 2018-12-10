package com.hero.repository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.hero.entity.Module;

public interface ModuleMapper {
	
	//删除
	//删除模块（rfy）
    int deleteByPrimaryKey(Integer mId);
    //查询该模块能否删除
    int selmodul(Integer mId);
    //根据parentid查询模块(rfy&thx)
    List<Module> selmodulByParentid(Integer mId);
    /**
     * 根据角色编号查询出所拥有的模块编号
     * @author thx
     * @param rid 角色编号集合
     * @return 模块编号集合
     */
  	public List<Integer> selectMidByRid(@Param("list")List<Integer> rid);

    int insert(Module record);
    
    //添加模块信息（rfy）
    int insertSelective(Module record);
    //根据模块名称和父id判断模块是否存在
    public int isExitByNameAndPid(@Param("mname")String mname,@Param("pid")Integer pid);
    
    //根据模块id查询模块信息(rfy)
    Module selectByPrimaryKey(Integer mId);

    //修改模块信息（rfy）
    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
    //根据父id和角色id查询角色拥有的模块信息(rfy)
    public List<Module> queryModuleByPidRid(@Param("pid") int pid,@Param("rids") List<Integer> rids);
    
    
    
    //查询出所有父模块（rfy）
  	public List<Module> queryParent(Module m);
  	//查询出父模块对应的子模块（rfy）
  	public List<Module> queryChildrenById(Integer parentId);
  	//查询总记录数（rfy）
  	public int queryAllCount();
    
    
  	
    //根据模块id查询模块信息（rfy）
  	public List<Module> queryTreeGridModuleByIds(@Param("rootIds") Set<Integer> rootIds);
  	//根据名称查询模块编号（rfy）
  	public List<Integer> queryModuleIdsByModuleNameLike(Module m);
  	//查询模块的父id（rfy）
  	public Integer queryParentIdByModuleId(@Param("moduleId") Integer moduleId);
  	//查询总记录数（rfy）
  	public int queryCount(String name);
  	public List<Module> queryMenuTreeChildrenById(@Param("parentId") Integer parentId,@Param("moduleIds") List<Integer> moduleIds);
  	
  	//根据模块id查询其子模块（rfy）
  	public List<Module> selectMoudleByMid(Integer mid);
  	//查询模块是否存在角色关联（rfy）
  	public int isExitRoleBymid(Integer mid);
  	
    
    
    
    
    
}