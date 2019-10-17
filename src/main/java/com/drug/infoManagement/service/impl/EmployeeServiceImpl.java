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

	@Override
	public boolean addMoreEmp(MultipartFile file) {
		try {
			//获取表格输入流
			InputStream inputStream = file.getInputStream();
			//创建工作薄workbook,将读取到的excel放入workbook中，一个Excel文件就是一个workbook
			Workbook workbook=WorkbookFactory.create(inputStream);
			String sheetName = workbook.getSheetName(0);//获取索引位置的sheet单子名称
			Sheet sheet = workbook.getSheet(sheetName);//以sheet单子名称获取sheet单子
			//Sheet sheetAt = workbook.getSheetAt(0);//以sheet单子索引获取sheet单子
			Row row = sheet.getRow(0);//获取sheet单子行对象，如：此时获取的第一行row对象
			
			List<MainEmployee> empList=new ArrayList<MainEmployee>();
			//遍历打印Excel表格数据
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				MainEmployee mainEmployee=new MainEmployee();
				for (int j = 0; j < row.getLastCellNum(); j++) {
					String value=sheet.getRow(i).getCell(j).toString();
					if (j==0) {
						mainEmployee.setEmpName(value);
					}else if (j==1) {
						String substring = value.substring(0, value.indexOf("."));
						int empAge = Integer.parseInt(substring);
						mainEmployee.setEmpAge(empAge);
					}else if (j==2) {
						mainEmployee.setEmpSex(value);
					}else if (j==3) {
						DecimalFormat df = new DecimalFormat("#");
						String format = df.format(sheet.getRow(i).getCell(j).getNumericCellValue());
						mainEmployee.setEmpTel(format);
					}else if (j==4) {
						mainEmployee.setStudyUndergo(value);
					}else if (j==5) {
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
				empList.add(mainEmployee);
			}
			employeeMapper.addMoreEmp(empList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
