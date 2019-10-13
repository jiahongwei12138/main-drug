package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainRole;

public interface RoleService {

	String addRole(MainRole role);

	List<MainRole> queryAllRole(String page,String limit);

	int getCountRole();

	void deletRoleById(String roleId);

	void updateRoleById(MainRole mainRole);

}
