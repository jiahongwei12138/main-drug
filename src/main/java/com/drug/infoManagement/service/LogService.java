package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.MainLog;

public interface LogService {
	/**
	   *方法功能：分页+模糊查询日志
	 * @param page 页码
	 * @param limit 每页显示数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return List<MainLog> 日志集合
	 */
	List<MainLog> queryLog(Integer page,Integer limit,String startTime,String endTime);

	/**
	   *方法功能：统计日志
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return int 日志数量
	 */
	int getCountLog(String startTime,String endTime);
	/**
	   *方法功能：删除日志
	 * @param logId 日志id
	 */
	void deletLogById(Integer logId);
	/**
	   *方法功能：批量删除日志
	 * @param logIds 日志id数组
	 */
	void deleteBatchLogById(Integer[] logIds);

}
