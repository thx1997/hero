package com.hero.controller;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hero.entity.Employee;
import com.hero.entity.Role;
import com.hero.entity.Token;
import com.hero.service.EmployeeService;
import com.hero.service.PermissionService;
import com.hero.service.RoleService;
import com.hero.util.JwtToken;
import com.hero.util.PasswordEncoder;
import com.hero.util.Result;


@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PermissionService permissionService;	
	
	@Autowired
	private RoleService roleService;
	
	int count;
	@RequestMapping("/confirm")
	public Object login(String un,String pwd){
		//先把用户输入的密码进行加密
		PasswordEncoder encoder=null;
		encoder = new PasswordEncoder(un, "Md5");	
		pwd=encoder.encode(pwd, 5);
		
		Employee user=employeeService.getEmpByEloginname(un);//根据用户名获取用户信息
		System.out.println("加密密码"+pwd+"正确密码"+user.getePwd());
		if(user==null)
			return new Result("用户名错误",0);
		if(user.geteIslockout()==1)
			return new Result("用户已被锁定,请联系管理员解锁.QQ : 993206626 ",0);
		if(!user.getePwd().equals(pwd)){//用户密码输入错误时
			if (user.getePwdwrongcount()<5) {//并且密码错误次数小于5
				count+=1;//每输错一次加1
				System.out.println("密码错误次数>>>>>>>>"+count);
				Employee e1=new Employee();
				e1.setePwdwrongcount(count);
				e1.seteId(user.geteId());
				employeeService.updateBySelective(e1);//用户的密码错误次数加1
				return new Result("密码错误",0);
			} else {//错误次数达到上限，锁定用户
				Employee e2=new Employee();
				e2.seteIslockout(1);
				e2.seteId(user.geteId());
				e2.seteLockouttime(new Date());
				
				employeeService.updateBySelective(e2);//锁定用户、更新锁定时间
				count=0;//设为0
				Employee e3=new Employee();
				e3.setePwdwrongcount(count);
				e3.seteId(user.geteId());
				employeeService.updateBySelective(e3);//锁定后，密码错误次数恢复初始值
				return new Result("密码错误次数已达到上限，用户已被锁定,请联系管理员解锁.QQ : 993206626 ",0);
			}
			
		}
			
		Employee e4=new Employee();
		e4.seteLogintime(new Date());
		e4.seteId(user.geteId());
		employeeService.updateBySelective(e4);//更新登录时间
		System.out.println("最后登录时间>>"+e4.geteLogintime());
		//根据用户Id查询出该用户的所有权限
		List<String> permissionValueList = permissionService.getPermissionValueByEid(user.geteId());
		//根据用户Id查询该用户的所有角色的编号
		List<Integer> roleIdList=roleService.getRoleIdByeid(user.geteId());
		//根据用户Id查询该用户的所有角色名称
		List<Role> rlist=roleService.getRoleByEid(user.geteId());
		List<String> rnameList=new ArrayList<String>();
		for (Role r:rlist) {
			rnameList.add(r.getrName());	
		}
		//构造一个token对象,存储用户和权限信息
		int uid=user.geteId();
		Token tokenObj = new Token(uid,roleIdList, permissionValueList);		
		String token = null;
		try {
			token = JwtToken.sign(tokenObj, 4*60*60*1000);// 4*60*60*1000 四个小时有效期的token
			System.out.println("生成token大小=>"+token.length());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);//响应给客户端的token令牌
		map.put("permission", permissionValueList);//响应给客户端的当前用户权限
		map.put("roleId", roleIdList);
		map.put("uId", uid);
		map.put("roleName", rnameList);
		System.out.println("登录响应》》"+map);
		count=0;
		System.out.println("登录成功时密码错误次数>>>>>>>>>>"+count);
		return new Result(map);//登录成功
	}

	
}
