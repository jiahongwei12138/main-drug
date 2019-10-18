package com.drug.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MProductionPlan;
import com.drug.production.mapper.MonthPlanMapper;
import com.drug.production.service.MonthPlanService;

@Service
public class MonthPlanServiceImpl implements MonthPlanService{
	
	@Autowired
	private MonthPlanMapper monthPlanMapper;

	@Override
	public List<MProductionPlan> selectMProductionPlan() {
		List<MProductionPlan> list=monthPlanMapper.selectMProductionPlan();
		return list;
	}
	

}
