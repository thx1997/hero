package com.hero.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hero.entity.Department;
import com.hero.entity.Employee;
import com.hero.entity.Role;
import com.hero.entity.query.DepartmentQuery;
import com.hero.service.DepartmentService;
import com.hero.util.PasswordEncoder;

@RestController
@RequestMapping(value="/department",name="部门管理")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * 多条件分页查询部门
	 * @author thx
	 * http://localhost:8080/invoicing/department/queryDep?dName=部&beginCreatetime=&endCreatetime&beginUpdatetime&endUpdatetime
	 * @param departmentQuery 条件封装的实体对象
	 * @return 
	 * 
	 */
	//@RequestMapping(value="/queryDep",name="多条件查询部门")
	@RequestMapping(value="/queryDep")
	public Object queryDep(DepartmentQuery departmentQuery,BindingResult bindingResult) {
		System.out.println("查询条件==》"+departmentQuery);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Department> depList=departmentService.queryDep(departmentQuery);
		Integer total=departmentService.queryDepCount(departmentQuery);
		System.out.println("查询结果==》集合："+depList+"总条数："+total);	
		map.put("total", total);
		map.put("rows", depList);
		return map;
	}
	/**
	 * 查询所有部门
	 * http://localhost:8080/invoicing/department/queryAllDep
	 * @author thx
	 * @return
	 */
	//@RequestMapping(value="/queryAllDep",name="查询所有部门")
	@RequestMapping(value="/queryAllDep")
	public Object queryAllDep() {
		List<Department> depList=departmentService.queryAllDep();
		return depList;
	}
	/**
	 * 添加新部门
	 * http://localhost:8080/invoicing/department/addDep?dName=a&dRemark=a
	 * @author thx
	 * @param dep 参数封装的部门实体对象
	 * @return
	 */
	@RequestMapping(value="/addDep",name="添加新部门")
	//@RequestMapping(value="/addDep")
	public Object addEmp(Department dep) {
		System.out.println("添加参数==》" + dep);
		Map<String, Object> map = new HashMap<String, Object>();
   		Integer n = departmentService.insertSelective(dep);
		if(n>0) {
		     map.put("success", true);
		     map.put("message", "添加成功");     
		}else {
			 map.put("success", false);
			 map.put("message", "添加失败"); 
		}
		return map;
	}
	/**
	 * 修改部门
	 * http://localhost:8080/invoicing/department/updateDep?dName=a&dRemark=a&dId=11
	 * @author thx
	 * @param dep 参数封装的部门实体
	 * @return
	 */
	@RequestMapping(value="/updateDep",name="修改部门信息")
	//@RequestMapping(value="/updateDep")
	public Object updateDep(Department dep,int dId) {
		System.out.println("修改参数==》" + dep);
		Map<String, Object> map = new HashMap<String, Object>();
		dep.setdId(dId);
		System.out.println("最终修改参数==》" + dep);
   		Integer n = departmentService.updateByPrimaryKeySelective(dep);
		if(n>0) {
		     map.put("success", true);
		     map.put("message", "修改成功");     
		}else {
			 map.put("success", false);
			 map.put("message", "修改失败"); 
		}
		return map;
	}
	/**
	 * 根据编号删除某个部门
	 * http://localhost:8080/invoicing/department/delDep?dId=11
	 * @author thx
	 * @param eId 目标编号
	 * @return
	 */
	Integer n;
	@RequestMapping(value="/delDep",name="根据编号某个部门")
	//@RequestMapping(value="/delDep")
	public Object delDep(int dId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			n = departmentService.deleteByPrimaryKey(dId);
			if(n>0) {
			     map.put("success", true);
			     map.put("message", "刪除成功");     
			}else {
				 map.put("success", false);
				 map.put("message", "删除失败"); 
			}
		} catch (Exception e) {
			 map.put("success", false);
			 map.put("message", "删除失败,该部门有人");
		}
		
		return map;
	}
	
}
