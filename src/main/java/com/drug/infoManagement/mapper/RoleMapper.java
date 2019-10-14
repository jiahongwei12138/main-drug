package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainModel;
import com.drug.entity.MainRole;

public interface RoleMapper {

	void addRole(MainRole role);

	MainRole queryRoleByName(MainRole mainRole);

	void updateRoleById(MainRole role);

	List<MainRole> queryAllRole(Map<String, Integer> map);

	int getCountRole();

	void updateEmpByRoleId(String roleId);

	void deletRoleById(String roleId);

	List<MainModel> queryModel();

	void addAuthority(Map<String, Object> map);

	void deleteAuthorityByRoleId(String roleId);

	List<Integer> queryModelIdByRoleId(Integer roleId);


}
