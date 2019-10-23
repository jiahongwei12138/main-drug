package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainDepartment;

public interface DeptService {
	/**
	 * 方法功能：添加部门
	 * @param department 部门对象
	 * @return String 添加结果信息
	 */
	String addDept(MainDepartment department);
	/**
	   *方法功能：分页查询所有部门
	 * @param page 页码
	 * @param limit 每页显示数
	 * @return List<MainDepartment> 部门集合
	 */
	List<MainDepartment> queryAllDept(Integer page,Integer limit);
	/**
	 * 方法功能：根据部门id修改部门信息
	 * @param department 部门对象
	 */
	void updateDeptById(MainDepartment department);
	/**
	   *方法功能：根据部门id删除部门
	 * @param deptId 部门id
	 */
	void deletDeptById(String deptId);

	/**
	   *方法功能：统计部门数量
	 * @return int 部门数量
	 */
	int queryCountDept();

	/**
	   *方法功能：查询所有部门
	 * @return List<MainDepartment> 部门集合
	 */
	List<MainDepartment> queryDeptGiveOption();
}
