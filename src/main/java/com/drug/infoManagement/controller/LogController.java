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
/**
 * 类描述：日志管理
 * @author jhw
 * @dateTime 2019年10月23日下午8:23:24
 * @version 1.0
 */
@Controller
public class LogController {

	@Autowired
	private LogService logService;
	/**
	   *方法功能：分页+模糊查询日志
	 * @param page 页码
	 * @param limit 每页显示数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
 	 * @return Map<String,Object> 日志集合
	 */
	@RequestMapping("/queryLog")
	@ResponseBody
	public Map<String, Object> queryLog(Integer page,Integer limit,String startTime,String endTime) {
		//分页+模糊查询日志
		List<MainLog> logs=logService.queryLog(page,limit,startTime,endTime);
		//统计日志数量
		int count=logService.getCountLog(startTime,endTime);
		Map<String, Object> map = ToolClass.responseByData(logs, count);
		return map;
	}
	/**
	   *方法功能：删除日志
	 * @param logId 日志id
	 * @return boolean 删除结果 true：删除成功  false：删除失败
	 */
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
	/**
	   *方法功能：批量删除日志
	 * @param logIds 日志id数组
	 * @return boolean 删除结果 true：删除成功  false：删除失败
	 */
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
