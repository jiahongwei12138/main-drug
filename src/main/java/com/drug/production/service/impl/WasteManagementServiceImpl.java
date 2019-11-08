package com.drug.production.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.WasteManagement;
import com.drug.production.mapper.WasteManagementMapper;
import com.drug.production.service.WasteManagementService;

@Service
public class WasteManagementServiceImpl implements WasteManagementService{
	@Autowired
	public WasteManagementMapper wasteManagementMapper;
	
	@Override
	public List<WasteManagement> selectWasteManagement(Map<String,Object> map) {
		List<WasteManagement> list=wasteManagementMapper.selectWasteManagement(map);
		return list;
	}

	@Override
	public void checkWasreManagement(Integer wasteId) {
		wasteManagementMapper.checkWasreManagement(wasteId);
	}

	@Override
	public int selectWasteCount() {
		int count =wasteManagementMapper.selectWasteCount();
		return count;
	}

}
