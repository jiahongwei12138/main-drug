package com.drug.warehouse.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.MainProductStorage;
import com.drug.util.ToolClass;
import com.drug.warehouse.service.MainProductStorageService;

@RestController
public class MainProductStorageController {
	@Autowired
	private MainProductStorageService mianProductStorageService;
	
	/**
	 * 按仓库名分页查询
	 * @param whID 仓库名
	 * @param page 页数
	 * @param limit 每页显示数
	 * @return 转换成json的map集合
	 */
	@RequestMapping("getProductStorageInf")
	public Map<String, Object> getProductStorageInf(Integer whID,Integer page ,Integer limit){
		System.err.println(whID);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whID", whID);
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<MainProductStorage>  list = mianProductStorageService.getProductInf(map);
		int count = mianProductStorageService.getCount(map);
		Map<String, Object> rmap = ToolClass.responseByData(list, count);
		return rmap;
	}
	
}
