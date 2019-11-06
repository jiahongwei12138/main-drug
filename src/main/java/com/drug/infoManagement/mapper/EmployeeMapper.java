package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;
/**
   * 类描述：员工管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:23:08
 * @version 1.0
 */
public interface EmployeeMapper {
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
	List<MainEmployee> queryAllEmp(Map<String, Object> map);
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
	void deletEmpById(Integer empId);
	/**
	   *方法功能：通过Excel批量添加员工
	 * @param file Excel文件
	 * @return boolean 添加结果 true：添加成功  false：添加失败
	 */
	void addMoreEmp(List<MainEmployee> empList);
	/**
	 *方法功能：重置员工密码
	 * @param empId 员工id
	 */
	void resetEmpPwd(Map<String, Object> map);


}
