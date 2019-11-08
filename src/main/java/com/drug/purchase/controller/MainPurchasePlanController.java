package com.drug.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.purchase.biz.MainPurchasePlanBiz;
import com.drug.entity.MainPurchasePlan;

@Controller
public class MainPurchasePlanController {
	@Autowired
	private MainPurchasePlanBiz mainPurchasePlanBiz;
	
	@RequestMapping("/getPurchasePlanOrder.do")
	@ResponseBody
	public Map<String,Object> getPurchasePlanOrder(Integer page,Integer limit){
		Map<String,Object> map = new HashMap<String,Object>();
		//int count = mainSupplierBiz.selectCount();
		String planState="通过";
		List<MainPurchasePlan> list = mainPurchasePlanBiz.getPurchasePlanOrder(planState);
		//List<MainSupplier> list = mainSupplierBiz.getSupplierAllInfo(page, limit);
		map.put("code", 0);
		map.put("count", 0);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/getPurchasePlan.do")
	@ResponseBody
	public Map<String,Object> getPurchasePlan(Integer page,Integer limit){
		Map<String,Object> map = new HashMap<String,Object>();
		//int count = mainSupplierBiz.selectCount();
		List<MainPurchasePlan> list = mainPurchasePlanBiz.getPurchasePlan();
		//List<MainSupplier> list = mainSupplierBiz.getSupplierAllInfo(page, limit);
		map.put("code", 0);
		map.put("count", 0);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/insertPurchasePlan.do")
	@ResponseBody
	public Integer insertPurchasePlan(MainPurchasePlan mainPurchasePlan){
		int row = mainPurchasePlanBiz.insertPurchasePlan(mainPurchasePlan);
		return row;
	}
	
	@RequestMapping("/updatePurchasePlan.do")
	@ResponseBody
	public Integer updatePurchasePlan(MainPurchasePlan mainPurchasePlan){
		int row = mainPurchasePlanBiz.updatePurchasePlan(mainPurchasePlan);
		return row;
	}
	
	@RequestMapping("/updatePurchasePlanState.do")
	@ResponseBody
	public Integer updatePurchasePlanState(MainPurchasePlan mainPurchasePlan){
		int row = mainPurchasePlanBiz.updatePurchasePlanState(mainPurchasePlan);
		return row;
	}
	
	@RequestMapping("/updatePurchasePlanStateOrder.do")
	@ResponseBody
	public Integer updatePurchasePlanStateOrder(MainPurchasePlan mainPurchasePlan){
		int row = mainPurchasePlanBiz.updatePurchasePlanStateOrder(mainPurchasePlan);
		return row;
	}
	
	@RequestMapping("/updatePurchasePlanSupplier.do")
	@ResponseBody
	public Integer updatePurchasePlanSupplier(MainPurchasePlan mainPurchasePlan){
		int row = mainPurchasePlanBiz.updatePurchasePlanSupplier(mainPurchasePlan);
		return row;
	}
	
}
