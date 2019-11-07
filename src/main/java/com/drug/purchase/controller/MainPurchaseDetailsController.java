package com.drug.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.purchase.biz.MainPurchaseDetailsBiz;
import com.drug.entity.MainPurchaseDetails;

@Controller
public class MainPurchaseDetailsController {
	@Autowired
	private MainPurchaseDetailsBiz mainPurchaseDetailsBiz;
	
	
	@RequestMapping("/setPurchaseDetailsSession.do")
	@ResponseBody
	public HttpSession setPurchaseDetailsSession(HttpSession session,Integer majorPlanId,Integer planId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("majorPlanId", majorPlanId);
		map.put("planId", planId);
		List<MainPurchaseDetails>  list = mainPurchaseDetailsBiz.getPurchaseDetails(map);
		session.setAttribute("purchaseDetails", list);
		return session;
	}
	
	@RequestMapping("/getPurchaseDetails.do")
	@ResponseBody
	public Map<String, Object> getPurchaseDetails(HttpSession session,Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Integer count = mainSupplierOfferBiz.selectSupplierOfferCount();
		List<MainPurchaseDetails> list = (List<MainPurchaseDetails>) session.getAttribute("purchaseDetails");
		map.put("code", 0); 
		map.put("count", 0); 
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/insertPurchaseDetails.do")
	@ResponseBody
	public Integer insertPurchaseDetails(MainPurchaseDetails mainPurchaseDetails) {
		Integer row = mainPurchaseDetailsBiz.insertPurchaseDetails(mainPurchaseDetails);
		return row;
	}
	
	@RequestMapping("/updatePurchaseDetails.do")
	@ResponseBody
	public Integer updatePurchaseDetails(MainPurchaseDetails mainPurchaseDetails) {
		Integer row = mainPurchaseDetailsBiz.updatePurchaseDetails(mainPurchaseDetails);
		return row;
	}
	
	@RequestMapping("/updatePurchaseDetailsOrderState.do")
	@ResponseBody
	public Integer updatePurchaseDetailsOrderState(MainPurchaseDetails mainPurchaseDetails) {
		Integer row = mainPurchaseDetailsBiz.updatePurchaseDetailsOrderState(mainPurchaseDetails);
		return row;
	}
	
}
