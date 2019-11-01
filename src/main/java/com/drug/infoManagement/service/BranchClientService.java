package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.BranchPurchaseOrderDetails;
import com.drug.entity.BranchPurchaseReturnDetails;
import com.drug.entity.MainProduct;
/**
 * 类描述：分店销售退货接口
 * @author jhw
 * @dateTime 2019年11月1日下午1:42:06
 * @version 1.0
 */
public interface BranchClientService {
	/**
	 * 方法功能：查询药品
	 * @return Object 药品集合
	 */
	List<MainProduct> getProduct();
	/**
	 * 方法功能：新增销售订单和销售详情单
	 * @param bsfId 分店id
	 * @param branchPurchaseOrderDetails 分店采购订单集合
	 */
	void addSaleOrder(Integer bsfId, List<BranchPurchaseOrderDetails> branchPurchaseOrderDetails);

	/**
	 * 方法功能：新增退货订单和退货详情单
	 * @param bsfId 分店id
	 * @param branchPurchaseReturnDetails 分店采购退货单集合
	 */
	void addBackSale(Integer bsfId, List<BranchPurchaseReturnDetails> branchPurchaseReturnDetails);

}
