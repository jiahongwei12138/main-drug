package com.drug.production.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.ReturnOf;
import com.drug.production.service.ReturnOfService;
import com.drug.util.ToolClass;

@RestController
public class ReturnOfController {
	@Autowired
	private ReturnOfService returnOfService;
	
	@RequestMapping("selectReturnOfAll.do")
	public Map<String, Object> selectReturnOfAll(int page,int limit){
		System.err.println(page);
		int pages=(page-1)*limit;
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("page", pages);
		map1.put("limit", limit);
		List<ReturnOf> list=returnOfService.selectReturnOfAll(map1);
		int count = returnOfService.selectReturnOfCount();
		Map<String, Object> map=ToolClass.responseByData(list, count);
		return map;
	}
	
	@RequestMapping("deleteReturnOfById.do")
	public boolean deleteReturnOfById(Integer returnOfId) {
		returnOfService.deleteReturnOfById(returnOfId);
		return true;
	}
	@RequestMapping("checkReturnOfStatus.do")
	public boolean checkReturnOfStatus(Integer returnOfId) {
		returnOfService.checkReturnOfStatus(returnOfId);
		return true;
	}
	
	
}
