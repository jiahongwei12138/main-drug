package com.drug.warehouse.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainStorage;
import com.drug.util.ToolClass;
import com.drug.warehouse.service.MainStorageService;

/**
 * 控制层(仓库类型)
 * @author Administrator
 *
 */
@Controller
public class MainStorageController {
	
	@Autowired
	public MainStorageService mainStorageService;
	
	/**
	 * 分页查询所有仓库总行数
	 * @return
	 */
	@RequestMapping("/AllMainStorage")
	@ResponseBody
	public Map<String, Object> AllMainStorage() {
		List<MainStorage> storagelist = mainStorageService.AllMainStorage();
		int count = mainStorageService.countMainStorage();
		Map<String,Object> map = ToolClass.responseByData(storagelist,count);
		return map;
	}
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/delMainStorage")
	@ResponseBody
	public int delMainStorage(Integer id) {
		int success = mainStorageService.delMainStorage(id);
		return success;
	}
	
	/**
	 * 执行修改
	 * @param ms
	 * @param id
	 * @return
	 */
	@RequestMapping("/editMainStorage")
	@ResponseBody
	public Integer editMainStorage(MainStorage ms) {
		int success = mainStorageService.editMainStorage(ms);
		return success;
	}
	
	/**
	 * 新增数据
	 * @param ms
	 * @return
	 */
	@RequestMapping("/newStorage")
	@ResponseBody
	public int newStorage(MainStorage ms) {
		ms.setStorageId(null);
		int num = mainStorageService.newStorage(ms);
		return num;
	}
	
	/**
	 * 根据仓库类型查询数据
	 * @param storageType
	 * @return
	 */
	@RequestMapping("/vagueMainStorage")
	@ResponseBody
	public Map<String,Object> vagueMainStorage(String storageType){
		int count = mainStorageService.countStorageType(storageType);
		List<MainStorage> list = mainStorageService.vagueMainStorage(storageType);
		Map<String,Object> map = ToolClass.responseByData(list,count);
		return map;
	} 
	
}
