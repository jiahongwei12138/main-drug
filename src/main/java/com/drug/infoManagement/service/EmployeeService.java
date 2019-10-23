package com.drug.infoManagement.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;

public interface EmployeeService {
	/**
	   *方法功能：通过部门id查询角色
	 * @param deptId 部门id
	 * @return List<MainRole> 角色集合
	 */
	List<MainRole> queryRolesByDeptId(Integer deptId);
	/**
	   *  方法功能：添加员工
	 * @param mainEmployee 员工对象
	 */
	void addEmployee(MainEmployee mainEmployee);
	/**
	   *方法功能：分页+模糊查询员工
	 * @param page 页码
	 * @param limit 每页显示数
	 * @param empName 员工姓名
	 * @return List<MainEmployee> 员工集合
	 */
	List<MainEmployee> queryAllEmp(Integer page,Integer limit,String empName);

	/**
	   *方法功能：统计员工数量
	 * @return int 员工
	 */
	int getCountEmp();
	/**
	   *  方法功能：根据员工id修改员工信息
	 * @param mainEmployee 员工对象
	 */
	void updateEmployeeById(MainEmployee mainEmployee);
	/**
	   *方法功能：根据员工id删除员工
	 * @param empId 员工id
	 * @param deptId 部门id
	 */
	void deletEmpById(Integer empId,Integer deptId);
	/**
	   *方法功能：通过Excel批量添加员工
	 * @param file Excel文件
	 * @return boolean 添加结果 true：添加成功  false：添加失败
	 */
	boolean addMoreEmp(MultipartFile file);

}
