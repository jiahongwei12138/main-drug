package com.drug.infoManagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;

public interface AdminIndexService {

	List<MainModel> queryByMenu();

	MainHeadquarters queryHeadquarter();

	void updateModelNameById(MainModel mainModel);

	MainEmployee login(MainEmployee mainEmployee,HttpSession session);

	List<MainModel> queryByMenuByRoleId(Integer roleId);

}
