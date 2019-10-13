package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainRole;
import com.drug.infoManagement.mapper.RoleMapper;
import com.drug.infoManagement.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public String addRole(MainRole mainRole) {
		MainRole role=roleMapper.queryRoleByName(mainRole);
		if (role!=null && "未删除".equals(role.getRoleState())) {
			return "该角色已经存在";
		}else if(role!=null && "已删除".equals(role.getRoleState())) {
			roleMapper.updateRoleById(role);
			return "添加成功";
		}else {
			roleMapper.addRole(mainRole);
			return "添加成功";
		}
	}

	@Override
	public List<MainRole> queryAllRole(String page,String limit) {
		int pageIndex=0;
		if (page!=null) {
			pageIndex=Integer.parseInt(page);
		}
		int currentLimit=0;
		if (limit!=null) {
			currentLimit=Integer.parseInt(limit);
		}
		int currentPage=(pageIndex-1)*currentLimit;
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", currentPage);
		map.put("limit", currentLimit);
		
		return roleMapper.queryAllRole(map);
	}

	@Override
	public int getCountRole() {
		return roleMapper.getCountRole();
	}

	@Override
	public void deletRoleById(String roleId) {
		roleMapper.updateEmpByRoleId(roleId);
		roleMapper.deletRoleById(roleId);
	}

	@Override
	public void updateRoleById(MainRole mainRole) {
		roleMapper.updateRoleById(mainRole);
	}

}
