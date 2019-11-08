package com.drug.infoManagement.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;
import com.drug.infoManagement.mapper.AdminIndexMapper;
import com.drug.infoManagement.mapper.EmployeeMapper;
import com.drug.infoManagement.service.AdminIndexService;
import com.drug.util.MD5Util;
/**
 * 类描述：后台首页
 * @author jhw
 * @dateTime 2019年10月23日下午7:16:30
 * @version 1.0
 */
@Service
public class AdminIndexServiceImpl implements AdminIndexService {

	@Autowired
	private AdminIndexMapper adminIndexMapper;
	
	@Autowired
	private EmployeeMapper EmployeeMapper;
	/**
	   *方法功能：查询模块
	 * @return List<MainModel> 模块集合
	 */
	@Override
	public List<MainModel> queryByMenu() {
		return adminIndexMapper.queryByMenu();
	}
	/**
	   *方法功能：查询总店信息
	 * @return MainHeadquarters 总店信息对象
	 */
	@Override
	public MainHeadquarters queryHeadquarter() {
		//查询统计员工人数
		int countEmp = EmployeeMapper.getCountEmp();
		//修改总店信息表中的总店人数
		adminIndexMapper.updateHeadquarterPersonNum(countEmp);
		return adminIndexMapper.queryHeadquarter();
	}
	/**
	   *方法功能：通过模块id修改模块名称
	 * @param mainModel 模块对象
	 */
	@Override
	public void updateModelNameById(MainModel mainModel) {
		adminIndexMapper.updateModelNameById(mainModel);
	}
	/**
	   *方法功能：登录
	 * @param mainEmployee 员工对象中保存的账号和密码
	 * @param session 会话对象
	 * @return MainEmployee 员工对象
	 */
	@Override
	public MainEmployee login(MainEmployee mainEmployee,HttpSession session) {
		//修改员工中的明文密码
		String empPwd = mainEmployee.getEmpPwd();
		//加密
		mainEmployee.setEmpPwd(MD5Util.digest(empPwd));
		//根据员工对象中的账号和密码查询员工对象
		MainEmployee employee = adminIndexMapper.login(mainEmployee);
		//将员工对象保存在会话域中
		session.setAttribute("employee", employee);
		return employee;
	}
	/**
	   *方法功能：根据角色id查询角色所拥有的模块菜单
	 * @param roleId 角色id
	 * @return List<MainModel>
	 */
	@Override
	public List<MainModel> queryByMenuByRoleId(Integer roleId) {
		return adminIndexMapper.queryByMenuByRoleId(roleId);
	}

}
