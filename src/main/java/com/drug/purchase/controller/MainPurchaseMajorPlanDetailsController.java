package com.drug.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.purchase.biz.MainPurchaseMajorPlanDetailsBiz;
import com.drug.entity.MainPurchaseMajorPlanDetails;

@Controller
public class MainPurchaseMajorPlanDetailsController {
	@Autowired
	private MainPurchaseMajorPlanDetailsBiz mainPurchaseMajorPlanDetailsBiz;
	
	@RequestMapping("/setPurchaseMajorPlanDetailsSession.do")
	@ResponseBody
	public HttpSession setPurchaseMajorPlanDetailsSession(HttpSession session,Integer majorPlanId) {
		System.out.println(majorPlanId);
		List<MainPurchaseMajorPlanDetails> list = mainPurchaseMajorPlanDetailsBiz.getMajorPlanDetails(majorPlanId);
		session.setAttribute("MajorPlanDetails", list);
		return session;
	}
	
	@RequestMapping("/PurchaseMajorPlanDetails.do")
	@ResponseBody
	public Map<String, Object> PurchaseMajorPlanDetails(HttpSession session,Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Integer count = mainSupplierOfferBiz.selectSupplierOfferCount();
		List<MainPurchaseMajorPlanDetails> list = (List<MainPurchaseMajorPlanDetails>) session.getAttribute("MajorPlanDetails");
		map.put("code", 0); 
		map.put("count", 0); 
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/setInsertMajorPlanDetails.do")
	@ResponseBody
	public Integer setInsertMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails) {
		System.out.println("hello");
		int row = mainPurchaseMajorPlanDetailsBiz.setInsertMajorPlanDetails(mainPurchaseMajorPlanDetails);
		return row;
	}
	
	@RequestMapping("/updateMajorPlanDetails.do")
	@ResponseBody
	public Integer updateMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails) {
		System.out.println("hello");
		int row = mainPurchaseMajorPlanDetailsBiz.updateMajorPlanDetails(mainPurchaseMajorPlanDetails);
		return row;
	}
}
