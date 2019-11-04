package com.drug.infoManagement.service.impl;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainRole;
import com.drug.infoManagement.mapper.EmployeeMapper;
import com.drug.infoManagement.service.EmployeeService;
import com.drug.util.MD5Util;
/**
 * 类描述：员工管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:16:16
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	/**
	   *方法功能：通过部门id查询角色
	 * @param deptId 部门id
	 * @return List<MainRole> 角色集合
	 */
	@Override
	public List<MainRole> queryRolesByDeptId(Integer deptId) {
		return employeeMapper.queryRolesByDeptId(deptId);
	}
	/**
	   *  方法功能：添加员工
	 * @param mainEmployee 员工对象
	 */
	@Override
	public void addEmployee(MainEmployee mainEmployee) {
		//设置员工初始密码为123456并加密
		String pwd = MD5Util.digest("123456");
		mainEmployee.setEmpPwd(pwd);
		employeeMapper.addEmployee(mainEmployee);
	}
	/**
	   *方法功能：分页+模糊查询员工
	 * @param page 页码
	 * @param limit 每页显示数
	 * @param empName 员工姓名
	 * @return List<MainEmployee> 员工集合
	 */
	@Override
	public List<MainEmployee> queryAllEmp(Integer page,Integer limit,String empName) {
		//计算页码
		int pageIndex=(page-1)*limit;
		//将页码，每页显示数，员工姓名放入map集合
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", pageIndex);
		map.put("limit", limit);
		map.put("empName", empName);
		
		return employeeMapper.queryAllEmp(map);
	}
	/**
	   *方法功能：统计员工数量
	 * @return int 员工
	 */
	@Override
	public int getCountEmp() {
		return employeeMapper.getCountEmp();
	}
	/**
	   *  方法功能：根据员工id修改员工信息
	 * @param mainEmployee 员工对象
	 */
	@Override
	public void updateEmployeeById(MainEmployee mainEmployee) {
		employeeMapper.updateEmployeeById(mainEmployee);
	}
	/**
	   *方法功能：根据员工id删除员工
	 * @param empId 员工id
	 * @param deptId 部门id
	 */
	@Override
	public void deletEmpById(Integer empId,Integer deptId) {
		employeeMapper.deletEmpById(empId);
	}
	/**
	   *方法功能：通过Excel批量添加员工
	 * @param file Excel文件
	 * @return boolean 添加结果 true：添加成功  false：添加失败
	 */
	@Override
	public boolean addMoreEmp(MultipartFile file) {
		try {
			//获取表格输入流
			InputStream inputStream = file.getInputStream();
			//创建工作薄workbook,将读取到的excel放入workbook中，一个Excel文件就是一个workbook
			Workbook workbook=WorkbookFactory.create(inputStream);
			//获取索引位置的sheet单子名称
			String sheetName = workbook.getSheetName(0);
			//以sheet单子名称获取sheet单子
			Sheet sheet = workbook.getSheet(sheetName);
			//Sheet sheetAt = workbook.getSheetAt(0);//以sheet单子索引获取sheet单子
			//获取sheet单子行对象，如：此时获取的第一行row对象
			Row row = sheet.getRow(0);
			//创建空的员工集合对象用于存储员工对象
			List<MainEmployee> empList=new ArrayList<MainEmployee>();
			//遍历打印Excel表格数据，i从1开始不获取第一行数据
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				//创建员工对象
				MainEmployee mainEmployee=new MainEmployee();
				//设置初始密码并加密
				mainEmployee.setEmpPwd(MD5Util.digest("123456"));
				for (int j = 0; j < row.getLastCellNum(); j++) {
					//获取第i行第j列的内容并转换为字符串
					String value=sheet.getRow(i).getCell(j).toString();
					//判断j列的内容属于哪一列
					if (j==0) {
						mainEmployee.setEmpName(value);
					}else if (j==1) {
						String substring = value.substring(0, value.indexOf("."));
						int empAge = Integer.parseInt(substring);
						mainEmployee.setEmpAge(empAge);
					}else if (j==2) {
						mainEmployee.setEmpSex(value);
					}else if (j==3) {
						//转换excel中读取的电话号码数据
						DecimalFormat df = new DecimalFormat("#");
						String format = df.format(sheet.getRow(i).getCell(j).getNumericCellValue());
						mainEmployee.setEmpTel(format);
					}else if (j==4) {
						mainEmployee.setStudyUndergo(value);
					}else if (j==5) {
						//转换excel中的读取的时间数据
						short format = sheet.getRow(i).getCell(j).getCellStyle().getDataFormat();  
					    SimpleDateFormat sdf = null;  
					    if(format == 14 || format == 31 || format == 57 || format == 58){  
					        //日期  
					        sdf = new SimpleDateFormat("yyyy-MM-dd");  
					    }else if (format == 20 || format == 32) {  
					        //时间  
					        sdf = new SimpleDateFormat("HH:mm");  
					    }  
					    double v = sheet.getRow(i).getCell(j).getNumericCellValue();  
					    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(v);  
					    String format2 = sdf.format(date);  
						mainEmployee.setJoinTime(format2);
					}
				}
				//将赋值好的员工对象添加到员工对象集合
				empList.add(mainEmployee);
			}
			//调用批量添加员工方法
			employeeMapper.addMoreEmp(empList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
