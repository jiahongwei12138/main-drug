package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainLog;
import com.drug.infoManagement.service.LogService;
import com.drug.util.ToolClass;

@Controller
public class LogController {

	@Autowired
	private LogService logService;
	
	@RequestMapping("/queryLog")
	@ResponseBody
	public Map<String, Object> queryLog(Integer page,Integer limit,String startTime,String endTime) {
		List<MainLog> logs=logService.queryLog(page,limit,startTime,endTime);
		int count=logService.getCountLog(startTime,endTime);
		Map<String, Object> map = ToolClass.responseByData(logs, count);
		return map;
	}
	@RequestMapping("/deletLogById")
	@ResponseBody
	public boolean deletLogById(Integer logId) {
		try {
			logService.deletLogById(logId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@RequestMapping("/deleteBatchLogById")
	@ResponseBody
	public boolean deleteBatchLogById(Integer[] logIds) {
		try {
			logService.deleteBatchLogById(logIds);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
