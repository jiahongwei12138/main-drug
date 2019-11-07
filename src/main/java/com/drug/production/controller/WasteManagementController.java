package com.drug.production.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.WasteManagement;
import com.drug.production.service.WasteManagementService;
import com.drug.util.ToolClass;

@RestController
public class WasteManagementController {
	@Autowired
	private WasteManagementService wasteManagementService;
	@RequestMapping("selectWasteManagement.do")
	public Map<String, Object> selectWasteManagement(int page, int limit){
		int pages=(page-1)*limit;
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("page", pages);
		map1.put("limit", limit);
		List<WasteManagement> list=wasteManagementService.selectWasteManagement(map1);
		int count = wasteManagementService.selectWasteCount();
		Map<String, Object> map=ToolClass.responseByData(list, count);
		return map;
	}
	@RequestMapping("checkWasreManagement.do")
	public boolean checkWasreManagement(Integer wasteId) {
		wasteManagementService.checkWasreManagement(wasteId);
		return true;
	}
	
}
