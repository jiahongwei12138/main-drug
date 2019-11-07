package com.drug.purchase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainPurchaseMajorPlanSon;

@Repository
public interface MainPurchaseMajorPlanSonMapper {
	
	public List<MainPurchaseMajorPlanSon> getMainPurchaseMajorPlanInfo();
	
	public Integer insertMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon);
	
	public Integer updateMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon);
}
