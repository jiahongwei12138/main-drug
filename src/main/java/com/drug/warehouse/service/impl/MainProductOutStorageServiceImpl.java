package com.drug.warehouse.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainProductInStorage;
import com.drug.entity.MainProductOutStorage;
import com.drug.entity.MainSaleOrderdetail;
import com.drug.warehouse.mapper.MainProductOutStorageMapper;
import com.drug.warehouse.service.MainProductOutStorageService;
@Service
public class MainProductOutStorageServiceImpl implements MainProductOutStorageService{
	@Autowired
	private MainProductOutStorageMapper MainProductOutStorageMapper;
	@Override
	public List<MainProductOutStorage> getOutStorageInf(Map<String, Object> map) {
		return MainProductOutStorageMapper.getOutStorageInf(map);
	}

	@Override
	public int getCountOSI(Map<String, Object> map) {
		return MainProductOutStorageMapper.getCountOSI(map);
	}

	@Override
	public List<MainSaleOrderdetail> getMainSaleOrderdetailInf(int orderId) {
		return MainProductOutStorageMapper.getMainSaleOrderdetailInf(orderId);
	}

	@Override
	public int updOutStoreInf(Map<String,Object> map) {
		return MainProductOutStorageMapper.updOutStoreInf(map);
	}

	@Override
	public int updMainSaleorderOutStoreState(int orderId) {
		return MainProductOutStorageMapper.updMainSaleorderOutStoreState(orderId);
	}

	@Override
	public List<MainProductOutStorage> getOutStorageInfReady(Map<String, Object> map) {
		return MainProductOutStorageMapper.getOutStorageInfReady(map);
	}

	@Override
	public int getCountOSIR(Map<String, Object> map) {
		return MainProductOutStorageMapper.getCountOSIR(map);
	}
	
}
