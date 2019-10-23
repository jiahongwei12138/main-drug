package com.drug.infoManagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainLog;
import com.drug.infoManagement.mapper.LogMapper;
import com.drug.infoManagement.service.LogService;
/**
 * 类描述：日志管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:28:17
 * @version 1.0
 */
@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private LogMapper logMapper;
	/**
	   *方法功能：分页+模糊查询日志
	 * @param page 页码
	 * @param limit 每页显示数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List<MainLog> 日志集合
	 */
	@Override
	public List<MainLog> queryLog(Integer page,Integer limit,String startTime,String endTime) {
		//计算页码
		Integer currentPage=(page-1)*limit;
		//将数据放入map集合
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", currentPage);
		map.put("limit", limit);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logMapper.queryLog(map);
	}
	/**
	   *方法功能：统计日志
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return int 日志数量
	 */
	@Override
	public int getCountLog(String startTime,String endTime) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return logMapper.getCountLog(map);
	}
	/**
	   *方法功能：删除日志
	 * @param logId 日志id
	 */
	@Override
	public void deletLogById(Integer logId) {
		logMapper.deletLogById(logId);
	}
	/**
	   *方法功能：批量删除日志
	 * @param logIds 日志id数组
	 */
	@Override
	public void deleteBatchLogById(Integer[] logIds) {
		logMapper.deleteBatchLogById(logIds);
	}

}
