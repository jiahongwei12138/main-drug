package com.drug.infoManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
