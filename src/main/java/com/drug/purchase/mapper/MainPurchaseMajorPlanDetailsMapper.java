package com.drug.purchase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainPurchaseMajorPlanDetails;

@Repository
public interface MainPurchaseMajorPlanDetailsMapper {
	
	public List<MainPurchaseMajorPlanDetails> getMajorPlanDetails(Integer majorPlanId);
	
	public Integer setInsertMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails);
	
	public Integer updateMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails);
	
}
