package com.drug.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.purchase.biz.MainPurchaseMajorPlanSonBiz;
import com.drug.entity.MainPurchaseMajorPlanSon;
import com.drug.entity.MainSupplier;

@Controller
public class MainPurchaseMajorPlanSonController {

	@Autowired
	private MainPurchaseMajorPlanSonBiz mainPurchaseMajorPlanSonBiz;

	@RequestMapping("/getMajorPlanInfo.do")
	@ResponseBody
	public Map<String,Object> getMajorPlanInfo(Integer page,Integer limit){
		System.err.println("hello"+"\t"+page+"\t"+limit);
		Map<String,Object> map = new HashMap<String,Object>();
		//Integer count = mainPurchaseMajorPlanSonBiz.getMajorPlanCount();
		List<MainPurchaseMajorPlanSon> list = mainPurchaseMajorPlanSonBiz.getMainPurchaseMajorPlanInfo();
		map.put("code", 0);
		map.put("count", 0);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("insertMajorPlan.do")
	@ResponseBody
	public Integer insertMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon) {
		int row = mainPurchaseMajorPlanSonBiz.insertMajorPlan(mainPurchaseMajorPlanSon);
		return row;
	}
	
	@RequestMapping("updateMajorPlan.do")
	@ResponseBody
	public Integer updateMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon) {
		int row = mainPurchaseMajorPlanSonBiz.updateMajorPlan(mainPurchaseMajorPlanSon);
		return row;
	}

}
