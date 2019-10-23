package com.drug.infoManagement.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;
import com.drug.infoManagement.service.EmployeeService;
import com.drug.util.ToolClass;
/**
 * 类描述：员工管理
 * @author jhw
 * @dateTime 2019年10月23日下午7:48:42
 * @version 1.0
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	/**
	   *方法功能：通过部门id查询角色
	 * @param deptId 部门id
	 * @return List<MainRole> 角色集合
	 */
	@RequestMapping("/queryRolesByDeptId")
	@ResponseBody
	public List<MainRole> queryRolesByDeptId(Integer deptId) {
		//通过部门id查询角色,返回角色集合
		List<MainRole> roleList=employeeService.queryRolesByDeptId(deptId);
		return roleList;
	}
	/**
	   *方法功能：通过Excel批量添加员工
	 * @param file Excel文件
	 * @return boolean 添加结果 true：添加成功  false：添加失败
	 */
	@RequestMapping("/addMoreEmp")
	@ResponseBody
	public boolean addMoreEmp(@RequestParam(required=false) MultipartFile file) {
		boolean result = employeeService.addMoreEmp(file);
		return result;
	}
	/**
	   *方法功能：分页+模糊查询员工
	 * @param page 页码
	 * @param limit 每页显示数
	 * @param empName 员工姓名
	 * @return Map<String,Object> 员工集合
	 */
	@RequestMapping("/queryAllEmp")
	@ResponseBody
	public Map<String, Object> queryAllEmp(Integer page,Integer limit,String empName) {
		//分页+模糊查询员工
		List<MainEmployee> employees=employeeService.queryAllEmp(page,limit,empName);
		//统计员工数量
		int count=employeeService.getCountEmp();
		Map<String, Object> map = ToolClass.responseByData(employees, count);
		return map;
	}
	/**
	   *方法功能：根据员工id删除员工
	 * @param empId 员工id
	 * @param deptId 部门id
	 * @return boolean 删除结果 true：添加成功  false：添加失败
	 */
	@RequestMapping("/deletEmpById")
	@ResponseBody
	public boolean deletEmpById(Integer empId,Integer deptId) {
		try {
			employeeService.deletEmpById(empId,deptId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	   *方法功能：添加员工
	 * @param mainEmployee 员工对象
	 * @param file 员工头像图片
	 * @param session 会话对象
	 * @return Object 添加结果 true：添加成功 false：添加失败
	 */
	@RequestMapping("/addEmployee")
	@ResponseBody
	public Object addEmployee(MainEmployee mainEmployee,
			@RequestParam(required=false) MultipartFile file,
			HttpSession session) {
		try {
			//创建配置文件集合
			Properties properties=new Properties();
			//通过类加载器加载资源文件，获得输入流
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("system.properties");
			//将流加载到配置文件集合
			properties.load(in);
			//获取配种文件中的“键”所对应的目录
			String path = properties.getProperty("directory");
			//获取上传的文件名
			String oriName = file.getOriginalFilename();
			//获取上传的图片后缀，使用FilenameUtils工具类，但不会获取.，得自己拼接一个
			String extName = FilenameUtils.getExtension(oriName);
			//为防止存储到数据库的图片重名，设置图片名称
			String picName=UUID.randomUUID().toString();
			//开始上传（transferTo：保存到..），前提得有该文件夹image
			file.transferTo(new File(path+"/"+picName+"."+extName));
			//拼接图片名称
			String headUrl=picName+"."+extName;
			//赋值给员工对象中的头像路径属性
			mainEmployee.setHeadUrl(headUrl);
			//调用添加员工方法
			employeeService.addEmployee(mainEmployee);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	   *方法功能：根据员工id修改员工信息
	 * @param mainEmployee 员工对象
	 * @param file 员工头像图片
	 * @param session 会话对象
	 * @return boolean 修改结果 true：修改成功 false：修改失败
	 */
	@RequestMapping("/updateEmployeeById")
	@ResponseBody
	public boolean updateEmployeeById(MainEmployee mainEmployee,
			@RequestParam(required=false) MultipartFile file,
			HttpSession session) {
		try {
			//创建配置文件集合
			Properties properties=new Properties();
			//通过类加载器加载资源文件，获得输入流
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("system.properties");
			//将流加载到配置文件集合
			properties.load(in);
			//获取配种文件中的“键”所对应的目录
			String path = properties.getProperty("directory");
			//获取上传的文件名
			String oriName = file.getOriginalFilename();
			//获取上传的图片后缀，使用FilenameUtils工具类，但不会获取.，得自己拼接一个
			String extName = FilenameUtils.getExtension(oriName);
			//为防止存储到数据库的图片重名，设置图片名称
			String picName=UUID.randomUUID().toString();
			//开始上传（transferTo：保存到..），前提得有该文件夹image
			file.transferTo(new File(path+"/"+picName+"."+extName));
			//拼接图片名称
			String headUrl=picName+"."+extName;
			//赋值给员工对象中的头像路径属性
			mainEmployee.setHeadUrl(headUrl);
			//天涯修改员工方法
			employeeService.updateEmployeeById(mainEmployee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
