package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainSaleOrder;
import com.drug.entity.MainSaleOrderdetail;
/**
 * 类描述：总店销售管理
 * @author jhw
 * @dateTime 2019年10月29日下午3:30:28
 * @version 1.0
 */
public interface SaleOrderMapper {
	/**
	 * 方法功能：查询销售订单
	 * @return
	 * @return List<MainSaleOrder>
	 */
	List<MainSaleOrder> querySaleOrder(Map<String, Object> map);
	/**
	 * 方法功能：查询销售订单详情
	 * @return List<MainSaleOrderdetail> 销售订单详情集合
	 */
	List<MainSaleOrderdetail> querySaleOrderDetail(Integer orderId);
	/**
	 * 方法功能：根据订单id删除订单详情
	 * @param orderId 订单id
	 */
	void deleteSaleOrderDetailById(Integer orderId);
	/**
	 * 方法功能：删除订单
	 * @param orderId 订单id
	 */
	void deleteSaleOrder(Integer orderId);
	/**
	 * 方法功能：审核订单
	 * @param orderId 订单id
	 */
	void checkOrder(Integer orderId);
	/**
	 * 方法功能：查询今年的每个月
	 * @return List<String> 月份集合
	 */
	List<String> querySaleReportGroupByMonth();
	/**
	 * 方法功能：查询每个月的订单
	 * @return List<Integer> 订单数集合
	 */
	List<Integer> querySaleReportOrderNumberByMonth();

}
