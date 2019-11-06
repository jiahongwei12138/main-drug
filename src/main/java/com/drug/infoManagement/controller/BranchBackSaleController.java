package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 类描述：分店退货订单
 * @author jhw
 * @dateTime 2019年10月30日上午9:31:31
 * @version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainBranchbacksale;
import com.drug.entity.MainBranchbacksaledetail;
import com.drug.infoManagement.service.BranchBackSaleService;
import com.drug.util.ToolClass;
@Controller
public class BranchBackSaleController {

	@Autowired
	private BranchBackSaleService branchBackSaleService;
	/**
	 * 方法功能：查询退货订单
	 * @param branchbacksale 退货单对象
	 * @return Map<String, Object> 退货单集合
	 */
	@RequestMapping("/queryBranchBackSaleOrder")
	@ResponseBody
	public Map<String, Object> queryBranchBackSaleOrder(MainBranchbacksale branchbacksale) {
		List<MainBranchbacksale> branchbacksales=branchBackSaleService.queryBranchBackSaleOrder(branchbacksale);
		Map<String, Object> map = ToolClass.responseByData(branchbacksales, branchbacksales.size());
		return map;
	}
	/**
	 * 方法功能：查询退货订单详情
	 * @param backSaleId 退货单id
	 * @return Map<String, Object> 退货单详情集合
	 */
	@RequestMapping("/queryBackSaleOrderDetail")
	@ResponseBody
	public Map<String, Object> queryBackSaleOrderDetail(Integer backSaleId) {
		List<MainBranchbacksaledetail> branchbacksaledetails=branchBackSaleService.queryBackSaleOrderDetail(backSaleId);
		Map<String, Object> map = ToolClass.responseByData(branchbacksaledetails, branchbacksaledetails.size());
		return map;
	}
	/**
	 * 方法功能：审核退货单
	 * @param backSaleId 退货单id
	 * @param bprId 分店退货单id
	 * @return Object true：审核成功   false:审核失败
	 */
	@RequestMapping("/checkbackOrder")
	@ResponseBody
	public Object checkbackOrder(Integer backSaleId,Integer bprId) {
		try {
			branchBackSaleService.checkbackOrder(backSaleId,bprId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 方法功能：质检退货单
	 * @param backSaleId 退货单id
	 * @return Object true：质检成功   false:质检失败
	 */
	@RequestMapping("/checkOrderInStoreCheckState")
	@ResponseBody
	public Object checkOrderInStoreCheckState(Integer backSaleId) {
		try {
			branchBackSaleService.checkOrderInStoreCheckState(backSaleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 方法功能：删除退货单
	 * @param backSaleId 退货单id
	 * @return Object true：删除成功   false:删除失败
	 */
	@RequestMapping("/deleteBackSaleOrder")
	@ResponseBody
	public Object deleteBackSaleOrder(Integer backSaleId) {
		try {
			branchBackSaleService.deleteBackSaleOrder(backSaleId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
