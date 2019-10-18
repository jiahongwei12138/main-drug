package com.drug.production.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.drug.entity.MProductionPlan;

@Component
public interface MonthPlanService {
	public List<MProductionPlan> selectMProductionPlan();
}
