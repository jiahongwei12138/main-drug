package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainDepartment;
import com.drug.infoManagement.service.DeptService;
import com.drug.util.ToolClass;
/**
 * 类描述：部门管理
 * @author jhw
 * @dateTime 2019年10月12日下午4:11:22
 * @version 1.0
 */
@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	/**
	 * 方法功能：添加部门
	 * @param department 部门对象
	 * @return String 添加结果信息
	 */
	@RequestMapping("/addDept")
	@ResponseBody
	public String addDept(MainDepartment department) {
		String addResult=deptService.addDept(department);
		return addResult;
	}
	
	/**
	 * 方法功能：查询部门信息
	 * @return Map<String,Object> 查询结果部门信息
	 */
	@RequestMapping("/queryAllDept")
	@ResponseBody
	public Map<String,Object> queryAllDept(Integer page,Integer limit) {
		List<MainDepartment> departments=deptService.queryAllDept(page,limit);
		int count=deptService.queryCountDept();
		Map<String, Object> map = ToolClass.responseByData(departments,count);
		return map;
	}
	/**
	 * 方法功能：
	 * @param department 部门对象
	 * @return boolean 修改结果      true：成功     false:失败
	 */
	@RequestMapping("/updateDeptById")
	@ResponseBody
	public boolean updateDeptById(MainDepartment department) {
		try {
			deptService.updateDeptById(department);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/deletDeptById")
	@ResponseBody
	public boolean deletDeptById(String deptId) {
		try {
			deptService.deletDeptById(deptId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
