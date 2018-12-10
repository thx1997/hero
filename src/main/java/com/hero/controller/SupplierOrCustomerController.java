package com.hero.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hero.entity.SupplierOrCustomer;
import com.hero.entity.query.SupplierOrCustomerQuery;
import com.hero.service.SupplierOrCustomerService;

@RestController
@RequestMapping(value="/supplierorcustomer",name="供应商客户管理")
public class SupplierOrCustomerController {
	@Autowired
	private SupplierOrCustomerService supplierOrCustomerService;
	
	/**
	 * 多条件查询供应商客户信息(rfy)
	 * @param scquery
	 * @return
	 */
	@RequestMapping(value="/queryAllByCount")
	public Object queryAll(SupplierOrCustomerQuery scquery){
		Map<String, Object> map = new HashMap<String, Object>();
		List<SupplierOrCustomer> list=supplierOrCustomerService.selectAllByCount(scquery);
		int total=supplierOrCustomerService.selectCount(scquery);
		map.put("total", total);
		map.put("rows",list);
		return map;
	}
	/**
	 * 添加信息(rfy)
	 * @param sc
	 * @return
	 */
	@RequestMapping(value="/insert",name="新增供应商或客户")
	public Object insert(SupplierOrCustomer sc){
		System.out.println("表单序列化参数>>>>>"+sc);
		Map<String, Object> map = new HashMap<String, Object>();
		int e=supplierOrCustomerService.isExitByName(sc.getsName());
		if (e>0) {
			map.put("success", false);
			map.put("message", "该信息已存在，请勿重复添加");
		} else {
			int n=supplierOrCustomerService.insertSelective(sc);
			if (n>0) {
				map.put("success", true);
				map.put("message", "添加成功");
			} else {
				map.put("success", false);
				map.put("message", "添加失败");
			}
		}
		
		return map;
	}
	
	/**
	 * 修改信息(rfy)
	 * @param sc
	 * @return
	 */
	@RequestMapping(value="/update",name="修改供应商或客户")
	public Object update(SupplierOrCustomer sc){
		System.out.println("表单序列化参数>>>>>"+sc);
		Map<String, Object> map = new HashMap<String, Object>();
		int n=supplierOrCustomerService.updateByPrimaryKeySelective(sc);
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
	 * 删除信息(rfy)
	 * @param sc
	 * @return
	 */
	@RequestMapping(value="/delete",name="删除供应商或客户")
	public Object delete(Integer sid){
		Map<String, Object> map = new HashMap<String, Object>();
		int n=supplierOrCustomerService.updexit(sid);
		if (n>0) {
			map.put("success", true);
			map.put("message", "删除成功");
		} else {
			map.put("success", false);
			map.put("message", "删除失败");
		}
		return map;
	}
	
	
	/**
	 * 批量修改供应商、客户的类别
	 * @param askerId
	 * @param stuId
	 * @return
	 */
	@RequestMapping(value="/batch",name="批量修改供应商或客户类别")
	public Object batchStu(int cateId,@RequestParam("sIds")List<Integer> sIds){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("编号>>>>>>>>>>>>>>>>>>"+sIds);
		int n=supplierOrCustomerService.updBatch(cateId, sIds);
		if (n>0) {
			map.put("success", true);
			map.put("message", "修改成功");
		} else {
			map.put("success", false);
			map.put("message", "修改失败");
		}
		return map;
	}
}
