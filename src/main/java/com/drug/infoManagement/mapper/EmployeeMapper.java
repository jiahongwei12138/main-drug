package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;

public interface EmployeeMapper {

	List<MainRole> queryRolesByDeptId(Integer deptId);

	void addEmployee(MainEmployee mainEmployee);

	List<MainEmployee> queryAllEmp(Map<String, Object> map);

	int getCountEmp();

	void updateEmployeeById(MainEmployee mainEmployee);

	void updateHeadquartersPersonNum(Map<String, Object> map);

	void updateDeptPersonNum(Map<String, Object> map);

	void deletEmpById(Integer empId);

	void addMoreEmp(List<MainEmployee> empList);


}
