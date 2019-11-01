package com.drug.infoManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.BranchPurchaseOrderDetails;
import com.drug.entity.BranchPurchaseReturnDetails;
import com.drug.entity.MainProduct;
import com.drug.infoManagement.service.BranchClientService;
/**
 * 类描述：分店销售退货接口
 * @author jhw
 * @dateTime 2019年11月1日下午1:42:06
 * @version 1.0
 */
@Controller
public class BranchClientController {

	@Autowired
	private BranchClientService branchClientService;
	/**
	 * 方法功能：查询药品
	 * @return Object 药品集合
	 */
	@RequestMapping("/getProduct")
	@ResponseBody
	public Object getProduct() {
		List<MainProduct> products=branchClientService.getProduct();
		return products;
	}
	/**
	 * 方法功能：接收分店采购订单
	 * @param bsfId 分店id
	 * @param branchPurchaseOrderDetails 分店采购订单集合
	 */
	@RequestMapping("/getBranchPurchaseOrderDetails")
	@ResponseBody
	public void getData(Integer bsfId,@RequestBody List<BranchPurchaseOrderDetails> branchPurchaseOrderDetails) {
		branchClientService.addSaleOrder(bsfId,branchPurchaseOrderDetails);
	}
	/**
	 * 方法功能：接收分店退货订单集合
	 * @param bsfId 分店id
	 * @param branchPurchaseReturnDetails 分店退货订单集合
	 */
	@RequestMapping("/getBranchPurchaseReturnDetails")
	@ResponseBody
	public void getBranchPurchaseReturnDetails(Integer bsfId,@RequestBody List<BranchPurchaseReturnDetails> branchPurchaseReturnDetails) {
		branchClientService.addBackSale(bsfId,branchPurchaseReturnDetails);
	}
}
