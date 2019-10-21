package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

import com.drug.entity.MainLog;

public interface LogMapper {

	List<MainLog> queryLog(Map<String, Object> map);

	int getCountLog(Map<String, Object> map);

	void deletLogById(Integer logId);

	void deleteBatchLogById(Integer[] logIds);

}
