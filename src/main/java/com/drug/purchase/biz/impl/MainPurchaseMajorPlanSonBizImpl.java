package com.drug.purchase.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.purchase.biz.MainPurchaseMajorPlanSonBiz;
import com.drug.entity.MainPurchaseMajorPlanSon;
import com.drug.purchase.mapper.MainPurchaseMajorPlanSonMapper;
@Service
public class MainPurchaseMajorPlanSonBizImpl implements MainPurchaseMajorPlanSonBiz{
	@Autowired
	private MainPurchaseMajorPlanSonMapper mainPurchaseMajorPlanSonMapper;
	
	@Override
	public List<MainPurchaseMajorPlanSon> getMainPurchaseMajorPlanInfo() {
		return mainPurchaseMajorPlanSonMapper.getMainPurchaseMajorPlanInfo();
	}

	@Override
	public Integer insertMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon) {
		return mainPurchaseMajorPlanSonMapper.insertMajorPlan(mainPurchaseMajorPlanSon);
	}

	@Override
	public Integer updateMajorPlan(MainPurchaseMajorPlanSon mainPurchaseMajorPlanSon) {
		return mainPurchaseMajorPlanSonMapper.updateMajorPlan(mainPurchaseMajorPlanSon);
	}

}
