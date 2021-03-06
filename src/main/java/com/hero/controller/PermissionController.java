package com.hero.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.hero.entity.Permission;
import com.hero.service.PermissionService;
import com.hero.service.RoleService;
import com.hero.util.Result;



@RestController
@RequestMapping(value="permission")
public class PermissionController {
	
	/**
	 * springmvc在启动时候将所有贴有请求映射标签：RequestMapper方法收集起来封装到该对象中
	 */
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;//SpringMVC所有控制器中的请求映射集合
	
    
	@Autowired
	private PermissionService permissionService;
	
	
	
	/**
	 * 清除所有权限(rfy)
	 * @return
	 */
	@RequestMapping(value="/deletePermission",name="清除权限")
	public Object deletePermission(){
		Map<String, Object> map = new HashMap<String, Object>();
		int d=permissionService.delPermission();
		if(d>0){
			map.put("success", true);
			map.put("message", "操作成功");
		}else{
			map.put("success", false);
			map.put("message", "操作失败");
		}
		return map;
	}
	/**,name="更新系统权限"
	 *http://localhost:8080/invoicing/permission/updatePermission
	 * 更新系统权限信息(rfy)
	 */    
	@RequestMapping(value="/updatePermission")
	public Object updatePermission(){
		System.out.println("更新系统中所有权限...");
		int k =this.updateSysPermission();//收集系统中所有权限数据更新到数据库
		System.out.println("系统中所有权限全部"+k+"条更新完毕 ^_^ ");
		return new Result("更新成功",1);
	}
	
	
	
	/**
	 * 收集系统中所有权限数据更新到数据库(rfy)
	 */
	public int updateSysPermission(){
		
		List<String> ownList = permissionService.queryAll();//查询出数据库中现有的所有权限数据集合
		System.out.println("查询出数据库中现有的所有权限数据集合=>"+ownList);
		Map<RequestMappingInfo, HandlerMethod> requestMap = handlerMapping.getHandlerMethods();//SpringMVC所有控制器中的请求映射集合
		System.out.println("SpringMVC所有控制器中的请求映射集合=>"+requestMap);
		Collection<HandlerMethod> handlerMethods = requestMap.values();//获取所有controller中所有带有@RequestMapper注解的方法
		if(handlerMethods == null || handlerMethods.size() < 1 ) return 0;//成功更新0条数据
		List<Permission> pList = new ArrayList<Permission>();//收集到的待新增的权限集合
		Permission permission = null;//待添加的权限对象
		
		for(HandlerMethod method : handlerMethods){//遍历所有带有@RequestMapper注解的方法			
			RequestMapping anno = method.getMethodAnnotation(RequestMapping.class);//从控制器映射方法上取出@RequestMapper注解对象
			//@RequestMapper注解有没有name备注是作为一个权限的标志
			if( !"".equals(anno.name()) ){//@RequestMapper注解写了name属性才做权限收集：所以@RequestMapper注解有没有name备注是作为一个权限的标志
				RequestMapping namespaceMapping = method.getBeanType().getAnnotation(RequestMapping.class);//带有@RequestMapper注解的方法所在控制器类上的RequestMapping注解对象
				String namespace =  namespaceMapping.value()[0];//得到RequestMapping注解的value值,即命名空间,即模块
				String permissionValue = (namespace+":"+anno.value()[0]).replace("/", "");//得到权限 ,例如：user:delete 用户模块的删除权限
				System.out.println("得到权限 ,例如：user:delete 用户模块的删除权限=>"+permissionValue +"权限说明:"+anno.name());
				if( ownList.contains(permissionValue) )continue;//如果数据库已经存储有这个注解权限,则忽略不收集
//				if( pList.contains(permissionValue) )continue;//如果已经收集到该权限,则忽略不再重复收集
				//构造权限对象,三个参数:权限,模块说明,权限说明
				permission = new Permission(permissionValue,namespaceMapping.name(), anno.name());//把权限控制注解@Permission解析为权限控制对象SysPermission,方便插入数据库权限表
				pList.add(permission);//把数据库没有存储的,收集容器中也没有收集到的的权限加入收集容器中.
			}			
		}		
		return pList.size()>0?permissionService.batchInsert(pList):0;
	}
	
}
