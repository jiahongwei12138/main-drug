package com.drug.infoManagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainModel;
import com.drug.entity.MainRole;
import com.drug.infoManagement.service.AdminIndexService;
import com.drug.infoManagement.service.DeptService;
import com.drug.infoManagement.service.RoleService;
import com.drug.util.ToolClass;

@Controller
public class RoleController {

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private AdminIndexService adminIndexService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/queryDeptGiveOption")
	@ResponseBody
	public Map<String, Object> queryDeptGiveOption(){
		List<MainDepartment> depts=deptService.queryDeptGiveOption();
		Map<String, Object> map = ToolClass.responseByData(depts, 0);
		return map;
	}
	
	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(MainRole role){
		String result=roleService.addRole(role);
		return result;
	}
	
	@RequestMapping("/queryAllRole")
	@ResponseBody
	public Map<String, Object> queryAllRole(String page,String limit){
		List<MainRole> roles=roleService.queryAllRole(page,limit);
		int count=roleService.getCountRole();
		Map<String, Object> map = ToolClass.responseByData(roles, count);
		return map;
	}
	
	@RequestMapping("/deletRoleById")
	@ResponseBody
	public boolean deletRoleById(String roleId){
		try {
			roleService.deletRoleById(roleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/updateRoleById")
	@ResponseBody
	public boolean updateRoleById(MainRole mainRole){
		try {
			roleService.updateRoleById(mainRole);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/queryAllModel")
	@ResponseBody
	public List<MainModel> queryAllModel(Integer roleId){
		
		List<MainModel> modelList=new ArrayList<MainModel>();
		
		List<MainModel> allModels=adminIndexService.queryByMenu();
		List<Integer> modelIdList=roleService.queryModelIdByRoleId(roleId);
		
		Map<Integer, MainModel> map=new HashMap<Integer, MainModel>();
		for (MainModel mainModel : allModels) {
			/*
			 * layui节点的特性：子节点被选中，那么父节点也会被选项。
			   *    如果父节点被选中那么该父节点下的所有子节点都将被选中。
			   *     所以这里判断modelIdList集合中是否包含遍历出的所有模块id，包含则设置模块的checked值都设置为true,否则为false  
			   *    注意在下面需要判断将modelIdList集合中包含的父模块（父节点）的checked值都设置为false  
			 */
			if (modelIdList.contains(mainModel.getId())) {
				mainModel.setChecked(true);
			}else {
				mainModel.setChecked(false);
			}
			if (mainModel.getParentModelId()==0) {
				mainModel.setSpread(true);
			}
			map.put(mainModel.getId(), mainModel);
		}
		
		for (MainModel m : allModels) {
			MainModel childModel=m;
			if (childModel.getParentModelId()==0) {
				modelList.add(childModel);
			}else {
				MainModel parentModel=map.get(childModel.getParentModelId());
				/*
				 * layui节点的特性：子节点被选中，那么父节点也会被选项。
				   *    如果父节点被选中那么该父节点下的所有子节点都将被选中。
				   *     所以这里判断将modelIdList集合中包含的父模块（父节点）的checked值都设置为false  
				 */
				if (modelIdList.contains(parentModel.getId())) {
					parentModel.setChecked(false);
				}
				parentModel.getChildren().add(childModel);
			}
		}
		return modelList;
	}
	
	@RequestMapping("/assignAuthority")
	@ResponseBody
	public boolean assignAuthority(String roleId,Integer[] modelIds){
		try {
			roleService.assignAuthority(roleId,modelIds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
