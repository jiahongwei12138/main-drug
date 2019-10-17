package com.drug.infoManagement.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;

public interface EmployeeService {

	List<MainRole> queryRolesByDeptId(Integer deptId);

	void addEmployee(MainEmployee mainEmployee);

	List<MainEmployee> queryAllEmp(Integer page,Integer limit,String empName);

	int getCountEmp();

	void updateEmployeeById(MainEmployee mainEmployee);

	void deletEmpById(Integer empId,Integer deptId);

	boolean addMoreEmp(MultipartFile file);

}
