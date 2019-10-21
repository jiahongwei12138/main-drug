package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainLog;

public interface LogService {

	List<MainLog> queryLog(Integer page,Integer limit,String startTime,String endTime);

	int getCountLog(String startTime,String endTime);

	void deletLogById(Integer logId);

	void deleteBatchLogById(Integer[] logIds);

}
