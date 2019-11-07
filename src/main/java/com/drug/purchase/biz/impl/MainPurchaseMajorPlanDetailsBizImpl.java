package com.drug.purchase.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.purchase.biz.MainPurchaseMajorPlanDetailsBiz;
import com.drug.entity.MainPurchaseMajorPlanDetails;
import com.drug.purchase.mapper.MainPurchaseMajorPlanDetailsMapper;

@Service
public class MainPurchaseMajorPlanDetailsBizImpl implements MainPurchaseMajorPlanDetailsBiz{
	@Autowired
	private MainPurchaseMajorPlanDetailsMapper mainPurchaseMajorPlanDetailsMapper;
	
	@Override
	public List<MainPurchaseMajorPlanDetails> getMajorPlanDetails(Integer majorPlanId) {
		return mainPurchaseMajorPlanDetailsMapper.getMajorPlanDetails(majorPlanId);
	}

	@Override
	public Integer setInsertMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails) {
		return mainPurchaseMajorPlanDetailsMapper.setInsertMajorPlanDetails(mainPurchaseMajorPlanDetails);
	}

	@Override
	public Integer updateMajorPlanDetails(MainPurchaseMajorPlanDetails mainPurchaseMajorPlanDetails) {
		return mainPurchaseMajorPlanDetailsMapper.updateMajorPlanDetails(mainPurchaseMajorPlanDetails);
	}
	
}
