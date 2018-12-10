package com.hero.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hero.entity.SupplierOrCustomer;
import com.hero.entity.SupplierOrCustomerCategory;
import com.hero.entity.query.SupplierOrCustomerCategoryQuery;
import com.hero.entity.query.SupplierOrCustomerQuery;
import com.hero.service.SupplierOrCustomerCategoryService;
@RestController
@RequestMapping(value="/scategory",name="供应商客户类别管理")
public class SupplierOrCustomerCategoryController {

	@Autowired
	private SupplierOrCustomerCategoryService supplierOrCustomerCategoryService;
	/**
	 * 根据类型查询所有类别信息（rfy)
	 * 0：客户  1：供应商
	 * @param stype
	 * @return
	 */
	@RequestMapping(value="/selectAllCate")
	public Object selectAllCate(Integer stype){
		List<SupplierOrCustomerCategory> list=supplierOrCustomerCategoryService.selectAllCate(stype);
		return list;
	}
	
	/**
	 * 多条件查询供应商客户类别信息(rfy)
	 * @param scquery
	 * @return
	 */
	@RequestMapping(value="/queryAllByCount",name="管理供货商或客户类别")
	public Object queryAll(SupplierOrCustomerCategoryQuery scquery){
		Map<String, Object> map = new HashMap<String, Object>();
		List<SupplierOrCustomerCategory> list=supplierOrCustomerCategoryService.selectAllByCount(scquery);
		int total=supplierOrCustomerCategoryService.selectCount(scquery);
		map.put("total", total);
		map.put("rows",list);
		return map;
	}
	/**
	 * 添加类别信息(rfy)
	 * @param sc
	 * @return
	 */
	@RequestMapping(value="/insert",name="新增供应商或客户类别")
	public Object insert(SupplierOrCustomerCategory sc){
		Map<String, Object> map = new HashMap<String, Object>();
		int n=supplierOrCustomerCategoryService.insertSelective(sc);
		if (n>0) {
			map.put("success", true);
			map.put("message", "添加成功");
		} else {
			map.put("success", false);
			map.put("message", "添加失败");
		}
		return map;
	}
	
	/**
	 * 修改类别信息(rfy)
	 * @param sc
	 * @return
	 */
	@RequestMapping(value="/update",name="修改供应商或客户类别")
	public Object update(SupplierOrCustomerCategory sc){
		System.out.println("参数>>>>>"+sc);
		Map<String, Object> map = new HashMap<String, Object>();
		int n=supplierOrCustomerCategoryService.updateByPrimaryKeySelective(sc);
		if (n>0) {
			map.put("success", true);
			map.put("message", "修改成功");
		} else {
			map.put("success", false);
			map.put("message", "修改失败");
		}
		return map;
	}
	
	/**
	 * 删除类别信息(rfy)
	 * @param sc
	 * @return
	 */
	@RequestMapping(value="/delete",name="删除供应商或客户类别")
	public Object delete(Integer sid){
		Map<String, Object> map = new HashMap<String, Object>();
		int n=supplierOrCustomerCategoryService.deleteByPrimaryKey(sid);
		if (n>0) {
			map.put("success", true);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("message", "删除失败");
		}
		return map;
	}
}
