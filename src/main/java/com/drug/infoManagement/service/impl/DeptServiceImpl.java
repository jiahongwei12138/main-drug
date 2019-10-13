package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainDepartment;
import com.drug.infoManagement.mapper.DeptMapper;
import com.drug.infoManagement.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper DeptMapper;
	
	@Override
	public String addDept(MainDepartment department) {
		MainDepartment dept=DeptMapper.queryDeptByName(department);
		if (dept!=null && "未删除".equals(dept.getDeptState())) {
			return "该部门已经存在";
		}else if(dept!=null && "已删除".equals(dept.getDeptState()) ) {
			DeptMapper.updateDeptById(dept);
			return "添加成功";
		}else {
			DeptMapper.addDept(department);
			return "添加成功";
		}
	}

	
	@Override
	public List<MainDepartment> queryAllDept(String page,String limit) {
		int pageIndex=0;
		if (page!=null) {
			pageIndex=Integer.parseInt(page);
		}
		int currentLimit=0;
		if (limit!=null) {
			currentLimit=Integer.parseInt(limit);
		}
		int currentPage=(pageIndex-1)*currentLimit;
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("page", currentPage);
		map.put("limit", currentLimit);
		
		return DeptMapper.queryAllDept(map);
	}


	@Override
	public void updateDeptById(MainDepartment department) {
		DeptMapper.updateDeptById(department);
	}


	@Override
	public void deletDeptById(String deptId) {
		DeptMapper.updateEmpByDeptId(deptId);
		DeptMapper.deletDeptById(deptId);
	}


	@Override
	public int queryCountDept() {
		return DeptMapper.queryCountDept();
	}


	@Override
	public List<MainDepartment> queryDeptGiveOption() {
		return DeptMapper.queryDeptGiveOption();
	}

}
