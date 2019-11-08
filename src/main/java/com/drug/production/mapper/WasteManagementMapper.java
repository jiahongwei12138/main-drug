package com.drug.production.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.entity.WasteManagement;

@Repository
public interface WasteManagementMapper {

	public List<WasteManagement> selectWasteManagement(Map<String,Object> map);
	
	public int selectWasteCount();
	
	public void checkWasreManagement(Integer wasteId);
	
}
