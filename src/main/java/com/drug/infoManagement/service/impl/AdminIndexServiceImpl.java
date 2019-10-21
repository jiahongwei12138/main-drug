package com.drug.infoManagement.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;
import com.drug.infoManagement.mapper.AdminIndexMapper;
import com.drug.infoManagement.mapper.EmployeeMapper;
import com.drug.infoManagement.service.AdminIndexService;
@Service
public class AdminIndexServiceImpl implements AdminIndexService {

	@Autowired
	private AdminIndexMapper adminIndexMapper;
	
	@Autowired
	private EmployeeMapper EmployeeMapper;
	
	@Override
	public List<MainModel> queryByMenu() {
		return adminIndexMapper.queryByMenu();
	}

	@Override
	public MainHeadquarters queryHeadquarter() {
		int countEmp = EmployeeMapper.getCountEmp();
		adminIndexMapper.updateHeadquarterPersonNum(countEmp);
		return adminIndexMapper.queryHeadquarter();
	}

	@Override
	public void updateModelNameById(MainModel mainModel) {
		adminIndexMapper.updateModelNameById(mainModel);
	}

	@Override
	public MainEmployee login(MainEmployee mainEmployee,HttpSession session) {
		MainEmployee employee = adminIndexMapper.login(mainEmployee);
		session.setAttribute("employee", employee);
		return employee;
	}

	@Override
	public List<MainModel> queryByMenuByRoleId(Integer roleId) {
		return adminIndexMapper.queryByMenuByRoleId(roleId);
	}

}
