package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainDepartment;

public interface DeptService {

	String addDept(MainDepartment department);

	List<MainDepartment> queryAllDept(Integer page,Integer limit);

	void updateDeptById(MainDepartment department);

	void deletDeptById(String deptId);

	int queryCountDept();

	List<MainDepartment> queryDeptGiveOption();
}
