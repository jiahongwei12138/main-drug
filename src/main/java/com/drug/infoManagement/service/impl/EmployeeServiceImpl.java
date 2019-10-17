package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;
import com.drug.infoManagement.mapper.EmployeeMapper;
import com.drug.infoManagement.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<MainRole> queryRolesByDeptId(Integer deptId) {
		return employeeMapper.queryRolesByDeptId(deptId);
	}

	@Override
	public void addEmployee(MainEmployee mainEmployee) {
		employeeMapper.addEmployee(mainEmployee);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("flag", "jia");
		map.put("deptId", mainEmployee.getDeptId());
		//修改总体人数
		employeeMapper.updateHeadquartersPersonNum(map);
		//根据部门id修改部门人数
		employeeMapper.updateDeptPersonNum(map);
	}

	@Override
	public List<MainEmployee> queryAllEmp(Integer page,Integer limit,String empName) {
		int pageIndex=(page-1)*limit;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", pageIndex);
		map.put("limit", limit);
		map.put("empName", empName);
		
		return employeeMapper.queryAllEmp(map);
	}

	@Override
	public int getCountEmp() {
		return employeeMapper.getCountEmp();
	}

	@Override
	public void updateEmployeeById(MainEmployee mainEmployee) {
		employeeMapper.updateEmployeeById(mainEmployee);
	}

	@Override
	public void deletEmpById(Integer empId,Integer deptId) {
		employeeMapper.deletEmpById(empId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("flag", "jian");
		map.put("deptId", deptId);
		//修改总体人数
		employeeMapper.updateHeadquartersPersonNum(map);
		//根据员工id修改部门人数
		employeeMapper.updateDeptPersonNum(map);
	}

}
