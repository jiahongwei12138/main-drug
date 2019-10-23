package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainModel;
import com.drug.entity.MainRole;
import com.drug.infoManagement.mapper.RoleMapper;
import com.drug.infoManagement.service.RoleService;
/**
 * 类描述：角色管理
 * @author jhw
 * @dateTime 2019年10月23日下午9:04:20
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	/**
	   *方法功能：添加角色
	 * @param role 角色对象
	 * @return String 添加结果
	 */
	@Override
	public String addRole(MainRole mainRole) {
		//根据角色名称查询角色对象
		MainRole role=roleMapper.queryRoleByName(mainRole);
		//如果角色对象不为空并且未删除，返回结果
		if (role!=null && "未删除".equals(role.getRoleState())) {
			return "该角色已经存在";
			//如果角色对象不为空并且已删除
		}else if(role!=null && "已删除".equals(role.getRoleState())) {
			role.setDeptId(mainRole.getDeptId());
			//修改角色状态
			roleMapper.updateRoleById(role);
			return "添加成功";
		}else {
			//添加角色
			roleMapper.addRole(mainRole);
			return "添加成功";
		}
	}
	/**
	   *方法功能：分页查询角色
	 * @param page 页码
	 * @param limit 每页显示数
	 * @return List<MainRole> 角色集合
	 */
	@Override
	public List<MainRole> queryAllRole(Integer page,Integer limit) {
		//计算页码
		int currentPage=(page-1)*limit;
		//将页码和每页显示数放入map集合
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", currentPage);
		map.put("limit", limit);
		
		return roleMapper.queryAllRole(map);
	}
	/**
	   *方法功能：统计角色数量
	 * @return int 角色数量
	 */
	@Override
	public int getCountRole() {
		return roleMapper.getCountRole();
	}
	/**
	   *方法功能：根据角色id删除角色
	 * @param roleId 角色id
	 */
	@Override
	public void deletRoleById(String roleId) {
		//根据角色id修改员工中的角色id
		roleMapper.updateEmpByRoleId(roleId);
		//根据角色id删除权限
		roleMapper.deleteAuthorityByRoleId(roleId);
		//根据角色id删除角色
		roleMapper.deletRoleById(roleId);
	}
	/**
	   *方法功能：根据角色id修改角色
	 * @param mainRole 角色对象
	 */
	@Override
	public void updateRoleById(MainRole mainRole) {
		roleMapper.updateRoleById(mainRole);
	}
	/**
	   *方法功能：分配权限
	 * @param roleId 角色id
	 * @param modelIds 模块id数组
	 */
	@Override
	public void assignAuthority(String roleId, Integer[] modelIds) {
		//将角色id和模块id数组方法map集合
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("roleId", roleId);
		map.put("modelIds", modelIds);
		//先根据角色id删除该角色所拥有的模块id
		roleMapper.deleteAuthorityByRoleId(roleId);
		//再为该角色添加新分配的模块id
		roleMapper.addAuthority(map);
	}
	/**
	   *方法功能：通过角色id查询模块
	 * @param roleId 角色id
	 * @return List<MainModel> 模块集合
	 */
	@Override
	public List<Integer> queryModelIdByRoleId(Integer roleId) {
		return roleMapper.queryModelIdByRoleId(roleId);
	}

}
