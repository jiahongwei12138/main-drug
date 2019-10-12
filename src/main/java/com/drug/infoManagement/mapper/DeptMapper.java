package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainDepartment;

public interface DeptMapper {

	void addDept(MainDepartment department);
	
	MainDepartment queryDeptByName(MainDepartment department);

	void updateDeptById(MainDepartment department);
	
	List<MainDepartment> queryAllDept(Map<String, Integer> map);
	
	void deletDeptById(String deptId);

	void updateEmpByDeptId(String deptId);

	int queryCountDept();

}
