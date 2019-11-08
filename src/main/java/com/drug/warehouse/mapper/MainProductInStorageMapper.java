package com.drug.warehouse.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.drug.entity.MainProductInStorage;
import com.drug.entity.MainProductStorage;
import com.drug.entity.MainProductionQuality;
import com.drug.entity.ProductionOrderDetails;

public interface MainProductInStorageMapper {
	/**
	 * 条件查询入库信息   分页
	 * @param map
	 * @return
	 */
	public List<MainProductInStorage> getInStorageInf(Map<String,Object> map);
	/**
	 * 分页总行数
	 * @param map
	 * @return
	 */
	public int getCountISI(Map<String,Object> map);
	/**
	 * 查询生产入库详情
	 * @param id
	 * @return
	 */
	public List<ProductionOrderDetails> getProductionOrderDetailsInf(int id);
	
	/**
	 * 根据订单详情给仓库插入信息
	 * @param mainProductStorage
	 * @return
	 */
	public int updProStorageInf(MainProductStorage mainProductStorage);
	/**
	 * 根据传入的Id 修改入库状态及审核状态
	 * @param piSId
	 * @return
	 */
	public int updProInStoInf(Map<String,Object> map);
	/**
	 * 查询生产审核未入库信息
	 * @return
	 */
	public List<MainProductionQuality> getMainProductionQualityInf();
	/**
	 * 查询未入库信息
	 * @return
	 */
	public List<MainProductInStorage> getNotChecked();
	/**
	 * 向成品库中添加信息
	 * @param pqId 生产成品管理(质检)Id
	 */
	public void insInfInStorage(int pqId);
	
	/**
	 * 修改生产成品管理(质检)入库状态
	 * @param pqId
	 */
	@Update("update productionQuality set insrock = '已入库' where pqId = #{pqId}")
	void updInfInProductionQuality(int pqId);
}
