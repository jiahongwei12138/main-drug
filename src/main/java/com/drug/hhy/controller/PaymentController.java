package com.drug.hhy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainPayment;
import com.drug.entity.MainPurchasePlan;
import com.drug.hhy.Service.PaymentService;
import com.drug.purchase.biz.MainPurchasePlanBiz;
import com.drug.util.ToolClass;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private MainPurchasePlanBiz mainPurchasePlanBiz;
	
	
	@RequestMapping("getAllPurchasePlan")
	public Map<String, Object> getAllPurchasePlan() {
		String planState="通过";
		List<MainPurchasePlan> list = mainPurchasePlanBiz.getPurchasePlanOrder(planState);
		System.err.println(list);
		Map<String, Object> map = ToolClass.responseByData(list, 10);
		return map;
	}
	
	
	@RequestMapping("updPurchasePlan")
	public void updPurchasePlan(MainPurchasePlan m,HttpSession session) {
		//获取登录的session用户信息   得到用户Id
		MainEmployee employee=(MainEmployee) session.getAttribute("employee");
		String name = employee.getEmpName();
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("planRealTotalPrices", m.getPlanRealTotalPrices());
		map.put("planRealTotalPrices", m.getPlanRealTotalPrices());
		map.put("planId", m.getPlanId());
		paymentService.insertMainPaymentInf(map);
		paymentService.updPurchasePlan(m.getPlanId());
	}
	
	@RequestMapping("getAllPaymentInf")
	public Map<String, Object> getAllPaymentInf() {
		List<MainPayment> list = paymentService.AllMainPayment();
		System.err.println(list);
		Map<String, Object> map = ToolClass.responseByData(list, 10);
		return map;
	}
}
