package com.drug.warehouse.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainProductInStorage;
import com.drug.entity.MainProductStorage;
import com.drug.entity.MainProductionQuality;
import com.drug.entity.ProductionOrderDetails;
import com.drug.warehouse.mapper.MainProductInStorageMapper;
import com.drug.warehouse.service.MainProductInStorageService;
@Service
public class MainProductInStorageServiceImpl implements MainProductInStorageService{
	@Autowired
	private MainProductInStorageMapper mainProductInStorageMapper;
	@Override
	public List<MainProductInStorage> getInStorageInf(Map<String, Object> map) {
		return mainProductInStorageMapper.getInStorageInf(map);
	}
	@Override
	public int getCountISI(Map<String, Object> map) {
		return mainProductInStorageMapper.getCountISI(map);
	}
	@Override
	public List<ProductionOrderDetails> getProductionOrderDetailsInf(int id) {
		return mainProductInStorageMapper.getProductionOrderDetailsInf(id);
	}
	@Override
	public int updProStorageInf(MainProductStorage mainProductStorage) {
		return mainProductInStorageMapper.updProStorageInf(mainProductStorage);
	}
	@Override
	public int updProInStoInf(Map<String,Object> map) {
		return mainProductInStorageMapper.updProInStoInf(map);
	}
	@Override
	public List<MainProductionQuality> getMainProductionQualityInf() {
		return mainProductInStorageMapper.getMainProductionQualityInf();
	}
	@Override
	public List<MainProductInStorage> getNotChecked() {
		return mainProductInStorageMapper.getNotChecked();
	}
	@Override
	public void insInfInStorage(int pqId) {
		mainProductInStorageMapper.insInfInStorage(pqId);
	}
	@Override
	public void updInfInProductionQuality(int pqId) {
		mainProductInStorageMapper.updInfInProductionQuality(pqId);
	}

}
