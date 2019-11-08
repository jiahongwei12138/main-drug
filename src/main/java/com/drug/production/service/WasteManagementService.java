package com.drug.production.service;

import java.util.List;
import java.util.Map;

import com.drug.entity.WasteManagement;

public interface WasteManagementService {

	public List<WasteManagement> selectWasteManagement(Map<String,Object> map);
	
	public int selectWasteCount();
	
	public void checkWasreManagement(Integer wasteId);
}
