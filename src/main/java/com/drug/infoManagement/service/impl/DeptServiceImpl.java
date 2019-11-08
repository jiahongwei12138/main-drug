package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainEmployee;
import com.drug.infoManagement.mapper.DeptMapper;
import com.drug.infoManagement.service.DeptService;
/**
 * 类描述：部门管理
 * @author jhw
 * @dateTime 2019年10月23日下午7:35:00
 * @version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper DeptMapper;
	/**
	 * 方法功能：添加部门
	 * @param department 部门对象
	 * @return String 添加结果信息
	 */
	@Override
	public String addDept(MainDepartment department) {
		//通过部门名称查询部门
		MainDepartment dept=DeptMapper.queryDeptByName(department);
		//判断如果部门对象不为空并且部门状态是未删除，返回结果信息
		if (dept!=null && "未删除".equals(dept.getDeptState())) {
			return "该部门已经存在";
			////判断如果部门对象不为空并且部门状态是已删除，则修改部门的状态为未删除，返回结果信息
		}else if(dept!=null && "已删除".equals(dept.getDeptState()) ) {
			//根据部门id修改部门状态
			DeptMapper.updateDeptById(dept);
			return "添加成功";
		}else {
			//新增部门
			DeptMapper.addDept(department);
			return "添加成功";
		}
	}

	/**
	   *方法功能：分页查询所有部门
	 * @param page 页码
	 * @param limit 每页显示数
	 * @return List<MainDepartment> 部门集合
	 */
	@Override
	public List<MainDepartment> queryAllDept(Integer page,Integer limit) {
		//计算开始页
		int currentPage=(page-1)*limit;
		//分组查询部门中的员工人数，返回员工集合
		List<MainEmployee> list=DeptMapper.queryDeptPersonNumFromEmp();
		//通过查询出的员工集合中的部门id和部门人数批量修改部门人数
		DeptMapper.updateDeptPersonNumById(list);
		//将开始页和每页显示数放入map集合
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", currentPage);
		map.put("limit", limit);
		return DeptMapper.queryAllDept(map);
	}

	/**
	 * 方法功能：根据部门id修改部门信息
	 * @param department 部门对象
	 */
	@Override
	public void updateDeptById(MainDepartment department) {
		DeptMapper.updateDeptById(department);
	}

	/**
	   *方法功能：根据部门id删除部门
	 * @param deptId 部门id
	 */
	@Override
	public void deletDeptById(String deptId) {
		//根据部门id修改员工中的部门id
		DeptMapper.updateEmpByDeptId(deptId);
		//根据部门id修改角色中的部门id
		DeptMapper.updateRoleByDeptId(deptId);
		//删除部门
		DeptMapper.deletDeptById(deptId);
	}

	/**
	   *方法功能：统计部门数量
	 * @return int 部门数量
	 */
	@Override
	public int queryCountDept() {
		return DeptMapper.queryCountDept();
	}

	/**
	   *方法功能：查询所有部门
	 * @return List<MainDepartment> 部门集合
	 */
	@Override
	public List<MainDepartment> queryDeptGiveOption() {
		return DeptMapper.queryDeptGiveOption();
	}

}
