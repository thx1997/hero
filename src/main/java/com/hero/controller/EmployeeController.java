package com.hero.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hero.entity.Employee;
import com.hero.entity.Role;
import com.hero.entity.query.EmployeeQuery;
import com.hero.entity.query.QueryBase;
import com.hero.service.EmployeeService;
import com.hero.service.RoleService;
import com.hero.util.PasswordEncoder;
import com.hero.util.Result;
/**
 * 员工管理控制层
 * @author thx
 */
@RestController
@RequestMapping(value="/employee",name="员工管理")
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;
	@Autowired
	public RoleService RoleService;
	/**
	 *分页查询所有角色
	 *@author thx
	 * @param queryBase 分页条件
	 * @return json格式total&rows
	 */
	@RequestMapping(value="/queryAllRolePage",name="查询员工角色情况")
	//@RequestMapping(value="/queryAllRolePage")
	public Object queryRoleByEid(QueryBase queryBase) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Role> roles=RoleService.queryAllRole(queryBase);
		int total=RoleService.queryAllRoleCount(queryBase);
		map.put("total", total);
		map.put("rows", roles);
		return map;
	}
	/**
	 * 根据员工编号查询拥有的角色编号
	 * @author thx
	 * @param eid 员工编号
	 * @return 角色编号集合json
	 */
	//@RequestMapping(value="/queryRidsByEid",name="根据员工编号查询拥有的角色编号")
	@RequestMapping(value="/queryRidsByEid")
	public Object queryRidsByEid(int eid) {
		List<Integer> rids=RoleService.getRoleIdByeid(eid);
		return rids;
	}

	/**
	 * 给用户设置角色
	 * @author thx
	 * @param eid 用户编号
	 * @param rids 角色编号集合
	 * @return 
	 */
    //@RequestMapping(value="setRole",name="给用户设置角色")
    @RequestMapping(value="setRole")
	public Object setRole(int eid,@RequestParam("rids[]")String[] rids) {
		System.out.println("参数>>>>>>>"+rids);
		List<String> ridlist = new ArrayList<String>();
	    for (int i = 0; i < rids.length; i++) {
	    	ridlist.add(rids[i]);
	    }
	    List<Integer> ridslist =ridlist.stream().map(Integer::parseInt).collect(Collectors.toList());
	    System.out.println("最终参数>>>>>>>"+rids);
	    Map<String, Object> map = new HashMap<String, Object>();
	    //清除所有角色
	    try {
			employeeService.delRE(eid);
			int n=employeeService.addRe(eid, ridslist);
			if(n>0) {
				map.put("success", true);
				map.put("message", "设置成功");
			}else {
				map.put("success", false);
				map.put("message", "设置失败");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", "操作失败");
		}
	    return map;
	}
	
	
	/**
	 * 多条件分页查询员工
	 * @author thx
	 * http://localhost:8080/invoicing/employee/queryEmp?eIslockout=0&eIdcard=410
	 * @param employeeQuery 条件封装的实体对象
	 * @return 
	 * 
	 */
	//@RequestMapping(value="/queryEmp",name="多条件查询员工")
	@RequestMapping(value="/queryEmp")
	//public Object queryEmp(EmployeeQuery employeeQuery,BindingResult bindingResult) {
	public Object queryEmp(String eName,String eLoginname,EmployeeQuery employeeQuery,BindingResult bindingResult) {
	/*eName: $("#eName").textbox("getValue"),
	eLoginname: $("#eLoginname").textbox("getValue"),
	eSex: $("#eSex").textbox("getValue"),
	eIdcard:$("#eIdcard").textbox("getValue"),
	beginBirthday: beginBirthday,
	endBirthday: endBirthday,
	beginLogintime: beginLogintime,
	endLogintime: endLogintime,
	beginCreatetime: beginCreatetime,
	endCreatetime: endCreatetime,
	beginUpdatetime: beginUpdatetime,
	endUpdatetime: endUpdatetime,
	eIslockout: $("#eIslockout").combobox("getValue"),
	eEmail: $("#eName").textbox("getValue"),
	eTelphone: $("#eTelphone").textbox("getValue"),
	eDeptid: $("#eDeptid").combobox("getValue"),
	orderby: $("#orderby").combobox("getValue")*/
	    System.out.println("查询条件==》"+employeeQuery);
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			employeeQuery.seteName(new String(eName.getBytes("ISO-8859-1"),"utf-8"));
			employeeQuery.seteLoginname(new String(eLoginname.getBytes("ISO-8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		List<Employee> empList=employeeService.queryEmp(employeeQuery);
		Integer total=employeeService.queryEmpCount(employeeQuery);	
		System.out.println("查询结果==》集合："+empList+"总条数："+total);	
		map.put("total", total);
		map.put("rows", empList);
		return map;
	}
	/**
	 * 添加新员工
	 * http://localhost:8080/invoicing/employee/addEmp?eName=aa&ePwd=123
	 * @author thx
	 * @param emp 参数封装的员工实体
	 * @return
	 */
	@RequestMapping(value="/addEmp",name="添加新员工")
	//@RequestMapping(value="/addEmp")
	public Object addEmp(Employee emp) {
		System.out.println("添加参数==》" + emp);
		// 将用户输入的密码加密
		PasswordEncoder yanzhi = new PasswordEncoder(emp.geteLoginname(), "Md5");
		String pwd = yanzhi.encode("ysd123", 5);
		emp.setePwd(pwd);
		Map<String, Object> map = new HashMap<String, Object>();
         System.out.println("最终参数==》" + emp);
		Integer n = employeeService.insertSelective(emp);
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
	 * 修改员工资料
	 * http://localhost:8080/invoicing/employee/updateEmp?eId=2&eName=bb&ePwd=ysd123&eDeptid=1
	 * @author thx
	 * @param emp 参数封装的员工实体
	 * @return
	 */
	@RequestMapping(value="/updateEmp",name="修改员工资料")
	//@RequestMapping(value="/updateEmp")
	public Object updateEmp(Employee emp) {
		System.out.println("修改参数==》"+emp);
		Map<String, Object> map = new HashMap<String, Object>();
		Integer n=employeeService.updateByPrimaryKeySelective(emp);
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
	 * 根据编号删除某个员工
	 * http://localhost:8080/invoicing/employee/delEmp?eId=1
	 * @author thx
	 * @param emp 参数封装的员工实体
	 * @return
	 */
	String rname="";
	@RequestMapping(value="/delEmp",name="根据编号删除某个员工")
	//@RequestMapping(value="/delEmp")
	public Object delEmp(int eId) {
		Map<String, Object> map = new HashMap<String, Object>();
		//先判断该员工是否拥有某些角色
		List<Role> rlist=employeeService.queryEmpHaveRole(eId);
		
		if(rlist.size()>0) {
			for (Role role : rlist) {
				rname+=role.getrName()+"、";
			}
			map.put("success", false);
			map.put("message", "该用户拥有"+rname+"角色,请先移除它们"); 
		}else {
		Integer n=employeeService.delEmpByeid(eId);
		if(n>0) {
		     map.put("success", true);
		     map.put("message", "刪除成功");     
		}else {
			 map.put("success", false);
			 map.put("message", "删除失败"); 
		}
		}
		return map;
	}
	/**
	 * 重置员工密码
	 * @author thx
	 * @param eId 员工编号
	 * @param eLoginname 员工的登录名
	 * @return
	 */                                                                                                          
	@RequestMapping(value="/resetPwd",name="重置员工密码")
	//@RequestMapping(value="/resetPwd")
	public Object resetPwd(int eId,String eLoginname) {
		System.out.println("重置参数==》"+eId+eLoginname);
		Map<String, Object> map = new HashMap<String, Object>();
		//将用户输入的密码加密
		PasswordEncoder yanzhi=new PasswordEncoder(eLoginname,"Md5");		
		String pwd=yanzhi.encode("ysd123", 5);
		Integer n=employeeService.resetPwd(pwd, eId);
		if(n>0) {
		     map.put("success", true);
		     map.put("message", "重置成功");     
		}else {
			 map.put("success", false);
			 map.put("message", "重置失败"); 
		}
		return map;
	}
	/**
	 * 锁定解锁
	 * http://localhost:8080/invoicing/employee/lockEmp?eid=2&uIsLockout=0
	 * @author thx
	 * @param emp 参数封装的员工实体
	 * @return
	 */
	@RequestMapping(value="/lockEmp",name="锁定解锁操作")
	//@RequestMapping(value="/lockEmp")
	public Object lockEmp(int eid,int eIslockout) {
		System.out.println("锁定参数==》"+eid+eIslockout);
		Map<String, Object> map = new HashMap<String, Object>();
		Integer n=employeeService.lockEmp(eid, eIslockout);
		if(n>0) {
		     map.put("success", true);
		     map.put("message", "锁定成功");     
		}else {
			 map.put("success", false);
			 map.put("message", "锁定失败"); 
		}
		return map;
	}
	
	
	/**
	 * 修改密码(rfy)
	 * @param u
	 * @return
	 */
	@RequestMapping(value="/updPwd")
	public Object updPwd(Employee u,String oldPwd,String loginname){
		PasswordEncoder encoder=null;
		//对原密码进行加密
		encoder = new PasswordEncoder(loginname, "Md5");	
		String oldPass=encoder.encode(oldPwd, 5);
		//对新密码进行加密
		encoder = new PasswordEncoder(loginname, "Md5");	
		String pwd=encoder.encode(u.getePwd(), 5);
		u.setePwd(pwd);
		
		Employee user=employeeService.getEmpByEloginname(loginname);//根据登录名查询用户信息
		if (!user.getePwd().equals(oldPass)) {//判断原密码输入是否正确
			return new Result("原密码输入错误",0);
		} else {
			int n=employeeService.updateBySelective(u);
			if (n>0) {
				return new Result("操作成功",1);
			} else {
				return new Result("操作失败",0);
			}
		}
		
	}
	
	
	
	/**
	 * (rfy)
	 * 测试token是否有效
	 */
	@RequestMapping("/testToken")
	public Object testToken(){
		return new Result(1, 0, "token有效,请放心使用");
	}
	
}
