package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.drug.entity.MainDepartment;
import com.drug.entity.MainEmployee;
/**
 * 类描述：部门管理
 * @author jhw
 * @dateTime 2019年10月23日下午7:47:50
 * @version 1.0
 */
public interface DeptMapper {
	/**
	 * 方法功能：添加部门
	 * @param department 部门对象
	 * @return String 添加结果信息
	 */
	void addDept(MainDepartment department);
	/**
	   *方法功能：根据部门名称查询部门对象
	 * @return MainDepartment 部门对象
	 */
	MainDepartment queryDeptByName(MainDepartment department);

	/**
	   *方法功能：根据部门id修改部门状态
	 * @param department 部门对象
	 */
	void updateDeptById(MainDepartment department);
	/**
	   *方法功能：分页查询部门信息
	 * @param map 页码和每页显示数
	 * @return List<MainDepartment> 部门集合
	 */
	List<MainDepartment> queryAllDept(Map<String, Integer> map);
	/**
	   *方法功能：根据部门id删除部门
	 * @param deptId 部门id
	 */
	void deletDeptById(String deptId);

	/**
	   *方法功能：根据部门id修改员工中的部门id
	 * @param deptId 部门id
	 */
	void updateEmpByDeptId(String deptId);

	/**
	   *方法功能：统计部门数量
	 * @return int 部门数量
	 */
	int queryCountDept();
	/**
	   *方法功能：查询部门
	 * @return List<MainDepartment> 部门集合
	 */
	@Select("select * from main_department where deptState='未删除'")
	List<MainDepartment> queryDeptGiveOption();

	/**
	   *方法功能：根据部门id修改角色中的部门id
	 * @param deptId 部门id
	 */
	void updateRoleByDeptId(String deptId);

	/**
	   *方法功能：分组查询部门中的员工人数
	 * @return List<MainEmployee> 员工集合
	 */
	List<MainEmployee> queryDeptPersonNumFromEmp();

	/**
	   *方法功能：通过员工中的部门id和和数量批量修改部门中的人数
	 * @param list 员工集合
	 */
	void updateDeptPersonNumById(List<MainEmployee> list);

}
