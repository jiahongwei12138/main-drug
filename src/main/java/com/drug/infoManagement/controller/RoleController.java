package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainRole;
import com.drug.infoManagement.service.DeptService;
import com.drug.infoManagement.service.RoleService;
import com.drug.util.ToolClass;

@Controller
public class RoleController {

	@Autowired
	private DeptService deptService;
	
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
	
	
}
