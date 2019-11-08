package com.drug.warehouse.service;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainProductStorage;
/**
 * 
 * @author bobo
 *
 */
public interface MainProductStorageService {
	/**
	 * 分页查询条件查询产品表信息
	 * @return
	 */
	public List<MainProductStorage> getProductInf(Map<String, Object> map);
	/**
	 * 获取分页的总行数
	 * @return 总行数
	 */
	public int getCount(Map<String, Object> map);
	
	int updMainProstoreProNum(Map<String, Object> map);
}
