package com.drug.warehouse.mapper;
/**
 * 
 * @author bobo
 *
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.drug.entity.MainProductStorage;

public interface MainProductStorageMapper {
	/**
	 * 分页查询条件查询产品表信息
	 * @return List<MainProductStorage> 查询得到的map集合
	 */
	public List<MainProductStorage> getProductInf(Map<String, Object> map);
	/**
	 * 获取分页的总行数
	 * @return 总行数
	 */
	public int getCount(Map<String, Object> map);
	
	/**
	 * 向成品1仓里添加信息
	 * @param proId  产品表Id
	 * @return
	 */
	public int insInfToProStore1(int proId);
	
	/**
	 * 向成品2仓里添加信息
	 * @param proId 产品表Id
	 * @return
	 */
	public int insInfToProStore2(int proId);
	
	@Update("update main_ProductStorage set productNumber = productNumber - #{proNum} where whID = #{whID} and productId = #{proId}")
	int updMainProstoreProNum(Map<String, Object> map);
	
	
	
}
