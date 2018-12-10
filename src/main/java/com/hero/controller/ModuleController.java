package com.hero.controller;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.hero.entity.Module;

import com.hero.service.ModuleService;

/**
 * 
 * @author xkt
 *
 */
@RestController
@RequestMapping(value="/module",name="模块管理")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	private List<Module> list = new ArrayList<Module>();
//	@Autowired
//	private ModuleServiceImpl moduleService;
	/**
	 * 查询角色所拥有的模块,加载左侧菜单树(rfy)
	 * @param request
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/queryByRid")
	public Object queryModuleTreeByRid(@RequestParam("rids[]")String[] rids){
		System.out.println("参数>>>>>>>"+rids);
		List<String> ridlist = new ArrayList<String>();
	    for (int i = 0; i < rids.length; i++) {
	    	ridlist.add(rids[i]);
	    }
	    
	    List<Integer> ridslist =ridlist.stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Module> mList=moduleService.queryModuleTreeByRid(ridslist);
		System.out.println("mList==>"+mList);
		return mList;
	}
	
	/**
	 * 查询所有模块信息(rfy)
	 * @return
	 */
	@RequestMapping(value="/queryAll")
	@ResponseBody
	public Object queryModuleTree(Module m){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("模块名称>>>>>>>>>>>>>>"+m.getmName());
		List<Module> mList=new ArrayList<Module>();
		int total=0;
		if (m.getmName()==null||m.getmName()=="") {//查询所有模块信息
			mList=moduleService.queryModuleTree(m);
			total=moduleService.queryAllCount();
		} else {//根据名称模糊查询
			mList=moduleService.queryModuleByName(m);
			total=moduleService.queryCount(m.getmName());
		}
		map.put("total", total);
		map.put("rows", mList);
		return map;
		
	}
	
	
	/**
	 * 添加模块(rfy)
	 * @param m
	 * @param request
	 * @return 
	 */
	@RequestMapping(value="/insert",name="模块新增")
	@ResponseBody
	public Object insertModule(Module m){
		Map<String, Object> map = new HashMap<String, Object>();
		int e=moduleService.isExitByNameAndPid(m.getmName(),m.getmParentid());
		System.out.println("是否存在"+e);
		if (e>0) {//判断同一父模块下新添加的模块是否存在
			map.put("success", false);
			map.put("message", "该模块已存在");
		} else {
			int n=moduleService.insertSelective(m);
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
	 * 修改模块信息，同一个父节点下节点名称不能相同(rfy)
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update",name="模块修改")
	@ResponseBody
	public Object updateModuleById(Module m){
		Map<String, Object> map = new HashMap<String, Object>();
		Module module=moduleService.selectByPrimaryKey(m.getmId());
		int n=0;
		if (module.getmName().equals(m.getmName())) {//先判断用户在页面是否修改了名称，若修改名称则需判断修改后的名称在同一父模块下是否存在
			n=moduleService.updateByPrimaryKeySelective(m);
			if (n>0) {
				map.put("success", true);
				map.put("message", "修改成功");
			} else {
				map.put("success", false);
				map.put("message", "修改失败");
			}
		} else {//若修改名称则需判断修改后的名称在同一父模块下是否存在
			int e=moduleService.isExitByNameAndPid(m.getmName(),m.getmParentid());
			System.out.println("是否存在"+e);
			if (e>0) {
				map.put("success", false);
				map.put("message", "该节点已存在，请修改节点名称");
			} else {
				n=moduleService.updateByPrimaryKeySelective(m);
				if (n>0) {
					map.put("success", true);
					map.put("message", "修改成功");
				} else {
					map.put("success", false);
					map.put("message", "修改失败");
				}
			}
		}
		return map;
	}
	
	/**
	 * 给角色设置模块时，查询模块信息，角色已拥有模块选中
	 * @author thx
	 * @param rId 角色编号
	 * @return
	 */
	@RequestMapping(value="/queryCheckedByRid",name="设置角色模块")
	@ResponseBody
	public Object queryModuleChecked(@RequestParam(value="rId",required=true)List<Integer> rId){
		return moduleService.queryModuleChecked(rId);		
	}
	
	/**
	 * 级联删除模块(rfy)
	 * @param mid
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete",name="模块删除")
	@ResponseBody
	public Object deleteModuleById(int mid){
		Map<String, Object> map = new HashMap<String, Object>();		
			int n=moduleService.delModule(mid);
			if (n>0) {
				map.put("success", true);
				map.put("message", "删除成功");
			} else {
				map.put("success", false);
				map.put("message", "删除失败，模块与其他角色有关联");
			}
		return map;
	}
}
