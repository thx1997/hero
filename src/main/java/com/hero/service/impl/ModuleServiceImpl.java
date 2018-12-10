package com.hero.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hero.entity.Module;
import com.hero.repository.ModuleMapper;
import com.hero.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	//<<<<<<<<<<<<<<<左侧菜单树(rfy)>>>>>>>>>>>>>>>>>>>>>
		@Override//(rfy)
		public List<Module> queryModuleByPidRid(int pid,List<Integer> rids) {
			
			return moduleMapper.queryModuleByPidRid(pid, rids);
		}

		@Override//(rfy)
		public List<Module> queryModuleTreeByRid(List<Integer> rids) {
			//查询出所有根菜单
			List<Module> rootList = this.queryModuleByPidRid(0, rids);
			//递归设置子菜单
			this.setChildrenTree(rootList,rids);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^最终得到的菜单列表=>"+rootList);
			return rootList;
		}
		//(rfy)
		private void setChildrenTree(List<Module> parentList,List<Integer> rids){
			for(Module m:parentList){
				//mids.contains(m.getmid);
				//查询出子菜单
				List<Module> childrenList = this.queryModuleByPidRid(m.getmId(),rids);
				System.out.println("*****************************************************设置子菜单=>"+m.getmName());
				//如果没有子菜单则递归结束
				if( childrenList !=null && !childrenList.isEmpty() ){//有子菜单
					//设置子菜单
					System.out.println("设置的子菜单是=>"+childrenList);
					m.setChildren(childrenList);
					//如果有子菜单则继续递归设置子菜单
					this.setChildrenTree(childrenList,rids);
				}
			}
		}
		
		
		
		
		//<<<<<<<<<<<<显示所有模块信息>>>>>>>>>>>>>>>>>>>>>
		/**
		 * 查询出父模块对应的子模块
		 */
		@Override
		public List<Module> queryChildrenById(Integer parentId) {
			return moduleMapper.queryChildrenById(parentId);
		}
		//查询所有父模块
		@Override
		public List<Module> queryParent(Module m) {
			
			return moduleMapper.queryParent(m);
		}
		
		@Override
		public int queryAllCount() {
			// TODO Auto-generated method stub
			return moduleMapper.queryAllCount();
		}
		
		/**
		 * 查询模块 TreeGrid 树形数据表格,所有模块信息
		 * @param parentList
		 */
		@Override
		public List<Module> queryModuleTree(Module m) {
			
			//查询出所有根菜单
			List<Module> rootList = this.queryParent(m);
			//递归设置子菜单
			this.setChildrens(rootList);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^最终得到的菜单列表=>"+rootList);
			return rootList;
		}
		
		/**
		 * 给菜单模块 设置孩子
		 * @param parentList
		 */
		private void setChildrens(List<Module> parentList){
			System.out.println("parentList>>>>>>>"+parentList);
			for(Module m:parentList){
				System.out.println("m.getmId()>>>>>>>"+m.getmId());
				//mids.contains(m.getmid);
				//查询出子菜单
				List<Module> childrenList = this.queryChildrenById(m.getmId());
				System.out.println("*****************************************************设置子菜单=>"+m.getmName());
				//如果没有子菜单则递归结束
				if( childrenList !=null && !childrenList.isEmpty() ){//有子菜单
					//设置子菜单
					System.out.println("设置的子菜单是=>"+childrenList);
					m.setChildren(childrenList);
					//如果有子菜单则继续递归设置子菜单
					this.setChildrens(childrenList);
				}
			}
		}
		
		
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<模糊查询>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		@Override
		public List<Integer> queryModuleIdsByModuleNameLike(Module m) {
			
			return moduleMapper.queryModuleIdsByModuleNameLike(m);
		}
		@Override
		public List<Module> queryTreeGridModuleByIds(Set<Integer> rootIds) {
			
			return moduleMapper.queryTreeGridModuleByIds(rootIds);
		}
		//模糊查询模块
		public List<Module> queryModuleByName(Module m) {
			
			//查询所有满足条件的模块Id
			List<Integer> likeList = this.queryModuleIdsByModuleNameLike(m);
			//找到这些模块的根模块,去重复
			Set<Integer> rootIds = new HashSet<Integer>();
			for(Integer id:likeList){
				rootIds.add(this.queryParentIdUntilZero(id));//
			}
					
			//查询出所有根菜单,条件查询从满足条件的跟模块开始查询
			List<Module> rootList = this.queryTreeGridModuleByIds(rootIds);
			System.out.println("父模块>>>>>>>>>"+rootList);
			//递归设置子菜单
			this.setMenuTreeChildrens(rootList, likeList);
			//this.setChildrens(rootList);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^最终得到的菜单列表=>"+rootList);
			return rootList;
			
			
		}
		
		private void setMenuTreeChildrens(List<Module> parentList,List<Integer> moduleIds){
			for(Module m:parentList){
				
				//查询出子菜单
				List<Module> childrenList = this.queryMenuTreeChildrenById(m.getmId(),moduleIds);
//				System.out.println("*****************************************************设置子菜单=>"+m.getModuleName());
				//如果没有子菜单则递归结束
				if( childrenList !=null && !childrenList.isEmpty() ){//有子菜单
					//设置子菜单
//					System.out.println("设置的子菜单是=>"+childrenList);
					m.setChildren(childrenList);
					//如果有子菜单则继续递归设置子菜单
					this.setMenuTreeChildrens(childrenList,moduleIds);
				}
			}
		}
		/**
		 * 找根模块
		 * 找父亲id为零的根模块
		 * 如果父Id不为零,则一直找
		 * @param moduleId
		 * @return
		 */
		private Integer queryParentIdUntilZero(Integer moduleId){
			Integer parentId = this.queryParentIdByModuleId(moduleId);//查找父亲id
			if(parentId == 0){//如果该模块父亲id为零,则该模块为根模块,则返回该模块id
				return moduleId;
			}else {
				return parentId;
				//return this.queryParentIdUntilZero(parentId);//如果该模块不是根模块,则继续找上一级模块的父Id
			}
		}
		@Override
		public Integer queryParentIdByModuleId(Integer moduleId) {

			return moduleMapper.queryParentIdByModuleId(moduleId);
		}
		@Override
		public int queryCount(String name) {
			
			return moduleMapper.queryCount(name);
		}
		@Override
		public List<Module> queryMenuTreeChildrenById(Integer parentId,
				List<Integer> moduleIds) {
			
			return moduleMapper.queryMenuTreeChildrenById(parentId, moduleIds);
		}

		
		
		@Override//rfy
		public int insertSelective(Module record) {
			// TODO Auto-generated method stub
			return moduleMapper.insertSelective(record);
		}

		@Override//rfy
		public int isExitByNameAndPid(String mname, Integer pid) {
			// TODO Auto-generated method stub
			return moduleMapper.isExitByNameAndPid(mname, pid);
		}

		@Override//rfy
		public int updateByPrimaryKeySelective(Module record) {
			// TODO Auto-generated method stub
			return moduleMapper.updateByPrimaryKeySelective(record);
		}

		@Override//rfy
		public Module selectByPrimaryKey(Integer mId) {
			// TODO Auto-generated method stub
			return moduleMapper.selectByPrimaryKey(mId);
		}

		
		
		
		
		
		
		
		
		
		
		
		/******************************级联删除************************/
		@Override//rfy
		public List<Module> selectMoudleByMid(Integer mid) {
			// TODO Auto-generated method stub
			return moduleMapper.selectMoudleByMid(mid);
		}

		@Override//rfy
		public int delModule(Integer mid) {
			//根据模块id查询子模块
			List<Module> childList=this.selectMoudleByMid(mid);
			
			if (childList!=null && !childList.isEmpty()) {
				this.delChildrens(childList);
			} 
				int e=this.isExitRoleBymid(mid);//判断是否存在角色关联
				if (e>0) {
					return 0;
				} else {
					int n=this.deleteByPrimaryKey(mid);//直接删除
					return n;
				}
			

		}

		private void delChildrens(List<Module> parentList){
			for(Module m:parentList){
				
				//查询出子菜单
				List<Module> childrenList = this.selectMoudleByMid(m.getmId());
//				System.out.println("*****************************************************设置子菜单=>"+m.getModuleName());
				//如果没有子菜单则递归结束
				if( childrenList !=null && !childrenList.isEmpty() ){//有子菜单
					int e=this.isExitRoleBymid(m.getmId());//判断是否存在角色关联
					if (e>0) {
						
					} else {
						this.deleteByPrimaryKey(m.getmId());//直接删除
						this.delChildrens(childrenList);
					}
				}
			}
		}
		
		
		@Override
		public int isExitRoleBymid(Integer mid) {
			// TODO Auto-generated method stub
			return moduleMapper.isExitRoleBymid(mid);
		}

		@Override
		public int deleteByPrimaryKey(Integer mId) {
			// TODO Auto-generated method stub
			return moduleMapper.deleteByPrimaryKey(mId);
		}
		
		@Override//thx
		public List<Module> queryModuleChecked(List<Integer> rid) {
			//查询出所有根菜单
			List<Module> rootList = moduleMapper.selmodulByParentid(0);
			//查询出角色已拥有的模块的编号
			List<Integer> midList=moduleMapper.selectMidByRid(rid);
			//递归设置子菜单
			this.setChildrensChecked(rootList,midList);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^最终得到的菜单列表=>"+rootList);
			return rootList;
			
		}
		/**
		 * 给菜单模块 设置孩子
		 * @author thx
		 * @param parentList 目标模块集合
		 */
		private void setChildrensChecked(List<Module> parentList,List<Integer> mList){
			for(Module m:parentList){
				//查询出子菜单
				List<Module> childrenList = this.queryChildrenById(m.getmId());
				System.out.println("*****************************************************设置子菜单=>"+m.getmName());
				//如果没有子菜单则递归结束
				if( childrenList !=null && !childrenList.isEmpty() ){//有子菜单
					
					//设置子菜单
					System.out.println("设置的子菜单是=>"+childrenList);
					m.setChildren(childrenList);
					//如果有子菜单则继续递归设置子菜单
					this.setChildrensChecked(childrenList,mList);
				}else{
					if (mList.contains(m.getmId())) {
						m.setChecked(true);
					} 
				}
			}
		}
		//查询角色已拥有的模块的编号
		@Override
		public List<Integer> selectMidByRid(List<Integer> rid) {
			return moduleMapper.selectMidByRid(rid);
		}
}
