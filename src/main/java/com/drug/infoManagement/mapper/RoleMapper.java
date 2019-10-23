package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainModel;
import com.drug.entity.MainRole;
/**
 * 类描述：角色管理
 * @author jhw
 * @dateTime 2019年10月23日下午9:07:06
 * @version 1.0
 */
public interface RoleMapper {
	/**
	   *方法功能：添加角色
	 * @param role 角色对象
	 */
	void addRole(MainRole role);
	/**
	   *方法功能：根据角色名称查询角色对象
	 * @param mainRole 角色对象
	 * @return MainRole 角色对象
	 */
	MainRole queryRoleByName(MainRole mainRole);
	/**
	   *方法功能：修改角色状态
	 * @param role 角色对象
	 */
	void updateRoleById(MainRole role);
	/**
	   *方法功能：分页查询角色
	 * @param page 页码
	 * @param limit 每页显示数
	 * @return List<MainRole> 角色集合
	 */
	List<MainRole> queryAllRole(Map<String, Integer> map);
	/**
	   *方法功能：统计角色数量
	 * @return int 角色数量
	 */
	int getCountRole();

	/**
	   *方法功能：根据角色id修改员工中的角色id
	 * @param roleId 角色id
	 */
	void updateEmpByRoleId(String roleId);

	/**
	   *方法功能：根据角色id删除角色
	 * @param roleId 角色id
	 */
	void deletRoleById(String roleId);
	/**
	   *方法功能：查询模块
	 * @return List<MainModel> 模块集合
	 */
	List<MainModel> queryModel();
	/**
	   *方法功能：分配权限
	 * @param roleId 角色id
	 * @param modelIds 模块id数组
	 */
	void addAuthority(Map<String, Object> map);

	/**
	   *方法功能：根据角色id删除权限(根据角色id删除该角色所拥有的模块id)
	 * @param roleId 角色id
	 */
	void deleteAuthorityByRoleId(String roleId);
	/**
	   *方法功能：通过角色id查询模块
	 * @param roleId 角色id
	 * @return List<MainModel> 模块集合
	 */
	List<Integer> queryModelIdByRoleId(Integer roleId);


}
