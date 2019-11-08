package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainModel;
import com.drug.entity.MainRole;
/**
 * 类描述：角色管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:58:19
 * @version 1.0
 */
public interface RoleService {
	/**
	   *方法功能：添加角色
	 * @param role 角色对象
	 * @return String 添加结果
	 */
	String addRole(MainRole role);
	/**
	   *方法功能：分页查询角色
	 * @param page 页码
	 * @param limit 每页显示数
	 * @return List<MainRole> 角色集合
	 */
	List<MainRole> queryAllRole(Integer page,Integer limit);

	/**
	   *方法功能：统计角色数量
	 * @return int 角色数量
	 */
	int getCountRole();
	/**
	   *方法功能：根据角色id删除角色
	 * @param roleId 角色id
	 */
	void deletRoleById(String roleId);
	/**
	   *方法功能：根据角色id修改角色
	 * @param mainRole 角色对象
	 */
	void updateRoleById(MainRole mainRole);
	/**
	   *方法功能：分配权限
	 * @param roleId 角色id
	 * @param modelIds 模块id数组
	 */
	void assignAuthority(String roleId, Integer[] modelIds);
	/**
	   *方法功能：通过角色id查询模块
	 * @param roleId 角色id
	 * @return List<MainModel> 模块集合
	 */
	List<Integer> queryModelIdByRoleId(Integer roleId);

}
