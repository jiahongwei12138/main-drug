package com.drug.production.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.MProductionPlan;

@Repository
public interface MonthPlanMapper {
	public List<MProductionPlan> selectMProductionPlan();
}
