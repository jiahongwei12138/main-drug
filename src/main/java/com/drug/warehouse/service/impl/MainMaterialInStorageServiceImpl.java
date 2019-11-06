package com.drug.warehouse.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainPurchaseDetails;
import com.drug.entity.MainPurchasePlan;
import com.drug.warehouse.mapper.MainMaterialInStorageMapper;
import com.drug.warehouse.service.MainMaterialInStorageService;

/**
 * 业务层实现类(原料入库)
 * @author Administrator
 *
 */
@Service
public class MainMaterialInStorageServiceImpl implements MainMaterialInStorageService {

	@Autowired
	private MainMaterialInStorageMapper dao;
	
	@Override
	public List<MainPurchasePlan> AllMainPurchasePlan(Map<String, String> map) {
		return dao.AllMainPurchasePlan(map);
	}

	@Override
	public int countMainPurchasePlan(Map<String, String> map) {
		return dao.countMainPurchasePlan(map);
	}

	@Override
	public List<MainPurchaseDetails> getMainPurchaseDetails(int planId) {
		return dao.getMainPurchaseDetails(planId);
	}

	@Override
	public int countMainPurchaseDetails(int planId) {
		return dao.countMainPurchaseDetails(planId);
	}

	@Override
	public int delMainPurchasePlan(int id) {
		return dao.delMainPurchasePlan(id);
	}

	@Override
	public List<MainPurchaseDetails> getDetailsqualitystatus(Map<String, Object> map) {
		return dao.getDetailsqualitystatus(map);
	}

	@Override
	public int countDetailsqualitystatus(Map<String, Object> map) {
		return dao.countDetailsqualitystatus(map);
	}

	@Override
	public List<MainPurchaseDetails> getDetailsName(String detailsName) {
		return dao.getDetailsName(detailsName);
	}

}
