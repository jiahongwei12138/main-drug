package com.drug.purchase.biz;

import java.util.List;

import com.drug.entity.MainPurchaseMajorPlanSon;

public interface MainPurchaseMajorPlanSonBiz {
	
	public List<MainPurchaseMajorPlanSon> getMainPurchaseMajorPlanInfo();
	
	public Integer insertMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon);
	
	public Integer updateMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon);
}
