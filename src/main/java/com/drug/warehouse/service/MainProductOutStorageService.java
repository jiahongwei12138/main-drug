package com.drug.warehouse.service;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainProductInStorage;
import com.drug.entity.MainProductOutStorage;
import com.drug.entity.MainProductStorage;
import com.drug.entity.MainProductionQuality;
import com.drug.entity.MainSaleOrderdetail;
import com.drug.entity.ProductionOrderDetails;

public interface MainProductOutStorageService {
	/**
	 * 条件查询入库信息   分页
	 * @param map
	 * @return
	 */
	public List<MainProductOutStorage> getOutStorageInf(Map<String,Object> map);
	/**
	 * 分页总行数
	 * @param map
	 * @return
	 */
	public int getCountOSI(Map<String,Object> map);
	/**
	 * 根据销售订单Id  获取详情
	 * @param orderId
	 * @return
	 */
	List<MainSaleOrderdetail> getMainSaleOrderdetailInf(int orderId);
	
	/**
	 * 
	 * @param posId
	 * @param empId
	 * @return
	 */
	int updOutStoreInf(Map<String,Object> map);
	
	/**
	 * 根据销售单Id修改销售出库状态
	 * @param orderId
	 * @return
	 */
	int updMainSaleorderOutStoreState(int orderId);
	
	public List<MainProductOutStorage> getOutStorageInfReady(Map<String,Object> map);
	
	public int getCountOSIR(Map<String,Object> map);
}
