package com.drug.purchase.biz;

import java.util.List;

import com.drug.entity.MainPurchaseMajorPlanDetails;

public interface MainPurchaseMajorPlanDetailsBiz {
	
	public List<MainPurchaseMajorPlanDetails> getMajorPlanDetails(Integer majorPlanId);
	
	public Integer setInsertMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails);
	
	public Integer updateMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails);

}
