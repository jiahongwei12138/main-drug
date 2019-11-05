package com.drug.infoManagement.service;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainSaleOrder;
import com.drug.entity.MainSaleOrderdetail;
/**
 * 类描述：总店销售订单
 * @author jhw
 * @dateTime 2019年10月29日下午3:29:30
 * @version 1.0
 */
public interface SaleOrderService {

	/**
	   *   方法功能：查询销售订单
	 * @return
	 * @return List<MainSaleorder>
	 */
	List<MainSaleOrder> querySaleOrder(String payTime,String branchStoreName,String checkState);
	/**
	 * 方法功能：查询销售订单详情
	 * @return List<MainSaleOrderdetail> 销售订单详情集合
	 */
	List<MainSaleOrderdetail> querySaleOrderDetail(Integer orderId);
	/**
	 * 方法功能：删除订单
	 * @param orderId 订单id
	 */
	void deleteSaleOrder(Integer orderId);
	/**
	 * 方法功能：审核订单
	 * @param orderId 订单id
	 */
	void checkOrder(Integer orderId,String bpoId);
	/**
	 * 方法功能：查询销售报表
	 * @return Map<String,Object> 
	 */
	Map<String, Object> querySaleReport();

}
