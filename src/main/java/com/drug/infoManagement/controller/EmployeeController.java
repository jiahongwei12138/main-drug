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

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/queryRolesByDeptId")
	@ResponseBody
	public List<MainRole> queryRolesByDeptId(Integer deptId) {
		List<MainRole> roleList=employeeService.queryRolesByDeptId(deptId);
		return roleList;
	}
	
	@RequestMapping("/addMoreEmp")
	@ResponseBody
	public boolean addMoreEmp(@RequestParam(required=false) MultipartFile file) {
		boolean result = employeeService.addMoreEmp(file);
		return result;
	}
	
	@RequestMapping("/queryAllEmp")
	@ResponseBody
	public Map<String, Object> queryAllEmp(Integer page,Integer limit,String empName) {
		List<MainEmployee> employees=employeeService.queryAllEmp(page,limit,empName);
		int count=employeeService.getCountEmp();
		Map<String, Object> map = ToolClass.responseByData(employees, count);
		return map;
	}
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
	
	@RequestMapping("/addEmployee")
	@ResponseBody
	public Object addEmployee(MainEmployee mainEmployee,
			@RequestParam(required=false) MultipartFile file,
			HttpSession session) {
		try {
			Properties properties=new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("system.properties");
			properties.load(in);
			String path = properties.getProperty("directory");
			//获取上传的文件名
			String oriName = file.getOriginalFilename();
			//获取上传的图片后缀，使用FilenameUtils工具类，但不会获取.，得自己拼接一个
			String extName = FilenameUtils.getExtension(oriName);
			//为防止存储到数据库的图片重名，设置图片名称
			String picName=UUID.randomUUID().toString();
			//开始上传（transferTo：保存到..），前提得有该文件夹image
			file.transferTo(new File(path+"/"+picName+"."+extName));
			
			String headUrl=picName+"."+extName;
			mainEmployee.setHeadUrl(headUrl);
			employeeService.addEmployee(mainEmployee);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@RequestMapping("/updateEmployeeById")
	@ResponseBody
	public boolean updateEmployeeById(MainEmployee mainEmployee,
			@RequestParam(required=false) MultipartFile file,
			HttpSession session) {
		try {
			Properties properties=new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("fileUploadDir.properties");
			properties.load(in);
			String path = properties.getProperty("directory");
			//获取上传的文件名
			String oriName = file.getOriginalFilename();
			//获取上传的图片后缀，使用FilenameUtils工具类，但不会获取.，得自己拼接一个
			String extName = FilenameUtils.getExtension(oriName);
			//为防止存储到数据库的图片重名，设置图片名称
			String picName=UUID.randomUUID().toString();
			//开始上传（transferTo：保存到..），前提得有该文件夹image
			file.transferTo(new File(path+"/"+picName+"."+extName));
			
			String headUrl=picName+"."+extName;
			mainEmployee.setHeadUrl(headUrl);
			employeeService.updateEmployeeById(mainEmployee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
