package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainLog;
import com.drug.infoManagement.mapper.LogMapper;
import com.drug.infoManagement.service.LogService;
@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogMapper logMapper;
	
	@Override
	public List<MainLog> queryLog(Integer page,Integer limit,String startTime,String endTime) {
		Integer currentPage=(page-1)*limit;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", currentPage);
		map.put("limit", limit);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logMapper.queryLog(map);
	}

	@Override
	public int getCountLog(String startTime,String endTime) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logMapper.getCountLog(map);
	}

	@Override
	public void deletLogById(Integer logId) {
		logMapper.deletLogById(logId);
	}

	@Override
	public void deleteBatchLogById(Integer[] logIds) {
		logMapper.deleteBatchLogById(logIds);
	}

}
