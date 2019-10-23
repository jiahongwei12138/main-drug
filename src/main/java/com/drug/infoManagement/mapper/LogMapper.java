package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;

import com.drug.entity.MainLog;
/**
 * 类描述：日志管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:29:44
 * @version 1.0
 */
public interface LogMapper {
	/**
	   *方法功能：分页+模糊查询日志
	 * @param map 页码、每页显示数、开始时间、结束时间
	 * @return List<MainLog> 日志集合
	 */
	List<MainLog> queryLog(Map<String, Object> map);
	/**
	   *方法功能：统计日志
	 * @param map 开始时间、结束时间
	 * @return int 日志数量
	 */
	int getCountLog(Map<String, Object> map);
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
