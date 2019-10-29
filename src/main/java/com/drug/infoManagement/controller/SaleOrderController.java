package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainSaleOrder;
import com.drug.entity.MainSaleOrderdetail;
import com.drug.infoManagement.service.BranchStoreInfoService;
import com.drug.infoManagement.service.SaleOrderService;
import com.drug.util.ToolClass;
/**
 * 类描述：总店销售订单
 * @author jhw
 * @dateTime 2019年10月29日下午3:26:13
 * @version 1.0
 */
@Controller
public class SaleOrderController {

	@Autowired
	private SaleOrderService saleOrderService;
	
	/**
	 * 方法功能：查询销售订单
	 * @return Map<String,Object> 销售订单集合
	 */
	@RequestMapping("/querySaleOrder")
	@ResponseBody
	public Map<String, Object> querySaleOrder(String payTime,String branchStoreName,String checkState) {
		List<MainSaleOrder> saleorders=saleOrderService.querySaleOrder(payTime,branchStoreName,checkState);
		Map<String, Object> map = ToolClass.responseByData(saleorders, saleorders.size());
		return map;
	}
	/**
	 * 方法功能：查询销售订单详情
	 * @return Map<String,Object> 销售订单详情集合
	 */
	@RequestMapping("/querySaleOrderDetail")
	@ResponseBody
	public Map<String, Object> querySaleOrderDetail(Integer orderId) {
		List<MainSaleOrderdetail> saleOrderdetails=saleOrderService.querySaleOrderDetail(orderId);
		Map<String, Object> map = ToolClass.responseByData(saleOrderdetails, saleOrderdetails.size());
		return map;
	}
	/**
	 * 方法功能：删除订单
	 * @param orderId 订单id
	 * @return Object  true:删除成功  false：删除失败
	 */
	@RequestMapping("/deleteSaleOrder")
	@ResponseBody
	public Object deleteSaleOrder(Integer orderId) {
		try {
			saleOrderService.deleteSaleOrder(orderId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 方法功能：审核订单
	 * @param orderId 订单id
	 * @return Object  true:审核成功  false：审核失败
	 */
	@RequestMapping("/checkOrder")
	@ResponseBody
	public Object checkOrder(Integer orderId) {
		try {
			saleOrderService.checkOrder(orderId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
