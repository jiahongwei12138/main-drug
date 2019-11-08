package com.drug.infoManagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;

public interface AdminIndexService {

	/**
	   *方法功能：查询模块
	 * @return List<MainModel> 模块集合
	 */
	List<MainModel> queryByMenu();

	/**
	   *方法功能：查询总店信息
	 * @return MainHeadquarters 总店信息对象
	 */
	MainHeadquarters queryHeadquarter();
	
	/**
	   *方法功能：通过模块id修改模块名称
	 * @param mainModel 模块对象
	 */
	void updateModelNameById(MainModel mainModel);
	/**
	   *方法功能：登录
	 * @param mainEmployee 员工对象中保存的账号和密码
	 * @param session 会话对象
	 * @return MainEmployee 员工对象
	 */
	MainEmployee login(MainEmployee mainEmployee,HttpSession session);
	/**
	   *方法功能：根据角色id查询角色所拥有的模块菜单
	 * @param roleId 角色id
	 * @return List<MainModel>
	 */
	List<MainModel> queryByMenuByRoleId(Integer roleId);

}
