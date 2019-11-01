package com.drug.infoManagement.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainBranchbacksale;
import com.drug.entity.MainProduct;
import com.drug.entity.MainSaleOrder;
/**
 * 类描述：分店销售退货接口
 * @author jhw
 * @dateTime 2019年11月1日下午1:42:06
 * @version 1.0
 */
public interface BranchClientMapper {
	/**
	 * 方法功能：查询药品
	 * @return Object 药品集合
	 */
	List<MainProduct> getProduct();

	/**
	 * 方法功能：新增销售订单
	 * @param saleOrder 销售单对象
	 */
	void addSaleOrder(MainSaleOrder saleOrder);

	/**
	 * 方法功能：新增销售详情单
	 * @param map 分店id和分店采购详情集合
	 */
	void addSaleOrderDetail(Map<String, Object> map);

	/**
	 * 方法功能：新增退货单
	 * @param branchbacksale 退货单
	 */
	void addBackSale(MainBranchbacksale branchbacksale);

	/**
	 * 方法功能：新增退货详情单
	 * @param map
	 * @return void
	 */
	void addBackSaleDetail(Map<String, Object> map);

}
