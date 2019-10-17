package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.drug.entity.MainDepartment;

public interface DeptMapper {

	void addDept(MainDepartment department);
	
	MainDepartment queryDeptByName(MainDepartment department);

	void updateDeptById(MainDepartment department);
	
	List<MainDepartment> queryAllDept(Map<String, Integer> map);
	
	void deletDeptById(String deptId);

	void updateEmpByDeptId(String deptId);

	int queryCountDept();
	
	@Select("select * from main_department where deptState='未删除'")
	List<MainDepartment> queryDeptGiveOption();

	void updateRoleByDeptId(String deptId);

}
