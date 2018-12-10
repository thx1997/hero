package com.hero.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;



import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.hero.entity.SupplierOrCustomer;
import com.hero.excel.PoiUtils;
import com.hero.service.SupplierOrCustomerService;


@RestController
@RequestMapping(value="/excel")
public class PoiExcelController {
	@Autowired
	private SupplierOrCustomerService supplierOrCustomerService;
	
	
	/**
	 * 导出学生信息
	 * @param sidList
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/exportExcel",produces="text/html;charset=UTF-8")
	public Object createStuExcel(@RequestParam("idList")List<Integer> sidList,HttpServletResponse response){
		String downloadName="学生信息.xls";//需要导出的学生的编号
		System.out.println("导出的编号"+sidList);
		
		List<SupplierOrCustomer> slist=supplierOrCustomerService.getSupplierOrCustomerBySid(sidList);
		System.out.println("导出的集合"+slist);

		try {
			PoiUtils poiUtils=new PoiUtils();
			response.setCharacterEncoding("UTF-8");//指明响应的字符编码格式
			response.setContentType("application/vnd.ms-excel");//指明响应文件为excel类型
			response.setHeader("Content-disposition","attachment;filename="+new String(downloadName.getBytes("GB2312"),"ISO8859-1"));
			ServletOutputStream outputStream=response.getOutputStream();//获取响应的字节输出流
			poiUtils.createExcel(slist, SupplierOrCustomer.class,outputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
}
