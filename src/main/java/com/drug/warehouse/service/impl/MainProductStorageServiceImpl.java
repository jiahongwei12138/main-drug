package com.drug.warehouse.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainProductStorage;
import com.drug.warehouse.mapper.MainProductStorageMapper;
import com.drug.warehouse.service.MainProductStorageService;
@Service
public class MainProductStorageServiceImpl implements MainProductStorageService {
	@Autowired
	private MainProductStorageMapper mainProductStorageMapper;
	@Override
	public List<MainProductStorage> getProductInf(Map<String, Object> map) {
		return mainProductStorageMapper.getProductInf(map);
	}
	@Override
	public int getCount(Map<String, Object> map) {
		return mainProductStorageMapper.getCount(map);
	}
	@Override
	public int updMainProstoreProNum(Map<String, Object> map) {
		return mainProductStorageMapper.updMainProstoreProNum(map);
	}

}
