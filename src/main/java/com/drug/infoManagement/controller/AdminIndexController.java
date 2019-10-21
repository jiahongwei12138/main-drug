package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;
import com.drug.infoManagement.service.AdminIndexService;
import com.drug.util.ToolClass;


@Controller
public class AdminIndexController {

	@Autowired
	private AdminIndexService adminIndexService;
	
	@RequestMapping("/queryMenu")
	@ResponseBody
	public Map<String,Object> queryByMenu(HttpSession session){
		MainEmployee employee=(MainEmployee) session.getAttribute("employee");
		List<MainModel> menuList =null;
		if (employee!=null) {
			menuList = adminIndexService.queryByMenuByRoleId(employee.getRoleId());
		}
		Map<String,Object> map = ToolClass.responseByData(menuList,0);
		return map;
	}
	
	@RequestMapping("/queryHeadquarter")
	@ResponseBody
	public Map<String,Object> queryHeadquarter(){
		MainHeadquarters headquarter = adminIndexService.queryHeadquarter();
		Map<String,Object> map = ToolClass.responseByData(headquarter,0);
		return map;
	} 
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(MainEmployee mainEmployee,HttpSession session){
		MainEmployee employee=adminIndexService.login(mainEmployee,session);
		if (employee!=null) {
			return true;
		}else {
			return false;
		}
		
	} 
}
