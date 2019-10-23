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

/**
   *   类描述：后台首页
 * @author jhw
 * @dateTime 2019年10月23日下午7:05:22
 * @version 1.0
 */
@Controller
public class AdminIndexController {

	@Autowired
	private AdminIndexService adminIndexService;
	
	/**
	 * 方法功能：查询功能模块
	 * @param session 会话对象
	 * @return Map<String,Object> 模块集合
	 */
	@RequestMapping("/queryMenu")
	@ResponseBody
	public Map<String,Object> queryByMenu(HttpSession session){
		//获取会话域中的用户对象
		MainEmployee employee=(MainEmployee) session.getAttribute("employee");
		//声明模块集合
		List<MainModel> menuList =null;
		//判断用户对象不为空
		if (employee!=null) {
			//根据用户对象中的角色id查询该角色拥有的模块集合
			menuList = adminIndexService.queryByMenuByRoleId(employee.getRoleId());
		}
		//将模块集合放入工具类map中
		Map<String,Object> map = ToolClass.responseByData(menuList,0);
		return map;
	}
	/**
	 * 方法功能：查询总店信息
	 * @param session 会话对象
	 * @return Map<String,Object> 总店信息对象
	 */
	@RequestMapping("/queryHeadquarter")
	@ResponseBody
	public Map<String,Object> queryHeadquarter(HttpSession session){
		//查询总店信息对象
		MainHeadquarters headquarter = adminIndexService.queryHeadquarter();
		//判断总店信息对象不为空
		if (headquarter!=null) {
			//将总店对象保存在会话域中
			session.setAttribute("headquarter", headquarter);
		}
		Map<String,Object> map = ToolClass.responseByData(headquarter,0);
		return map;
	} 
	/**
	   * 方法功能：登录
	 * @param mainEmployee 登录账号和密码参数
	 * @param session 会话对象
	 * @return boolean true：登录成功  false：登录失败
	 */
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(MainEmployee mainEmployee,HttpSession session){
		//根据员工输入的账号和密码查询员工对象
		MainEmployee employee=adminIndexService.login(mainEmployee,session);
		if (employee!=null) {
			return true;
		}else {
			return false;
		}
		
	} 
	/**
	   *方法功能：登出系统
	 * @param session 会话对象
	 * @return String 跳转到登录页面
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		//销毁会话对象
		session.invalidate();
		return "login";
	} 
}
