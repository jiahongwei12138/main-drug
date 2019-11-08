package com.drug.production.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MProductionPlan;
import com.drug.production.service.MonthPlanService;
import com.drug.util.ToolClass;

@Controller
public class MonthPlanController {
	
	@Autowired
	private MonthPlanService monthPlanService;
	
	@RequestMapping("selectMonthPlan")
	public @ResponseBody Map<String,Object>  selectMonthPlan() {
		List<MProductionPlan>  list=monthPlanService.selectMProductionPlan();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
}
