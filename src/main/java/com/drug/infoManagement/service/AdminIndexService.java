package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainModel;

public interface AdminIndexService {

	List<MainModel> queryByMenu();

	MainHeadquarters queryHeadquarter();

	void updateModelNameById(MainModel mainModel);

}
