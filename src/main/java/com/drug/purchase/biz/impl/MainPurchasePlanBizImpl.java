package com.drug.purchase.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.purchase.biz.MainPurchasePlanBiz;
import com.drug.entity.MainPurchasePlan;
import com.drug.purchase.mapper.MainPurchasePlanMapper;
@Service
public class MainPurchasePlanBizImpl implements MainPurchasePlanBiz{
	@Autowired
	private MainPurchasePlanMapper mainPurchasePlanMapper;
	
	@Override
	public List<MainPurchasePlan> getPurchasePlanOrder(String planState) {
		return mainPurchasePlanMapper.getPurchasePlanOrder(planState);
	}

	@Override
	public Integer insertPurchasePlan(MainPurchasePlan mainPurchasePlan) {
		return mainPurchasePlanMapper.insertPurchasePlan(mainPurchasePlan);
	}

	@Override
	public Integer updatePurchasePlan(MainPurchasePlan mainPurchasePlan) {
		return mainPurchasePlanMapper.updatePurchasePlan(mainPurchasePlan);
	}

	@Override
	public Integer updatePurchasePlanState(MainPurchasePlan mainPurchasePlan) {
		return mainPurchasePlanMapper.updatePurchasePlanState(mainPurchasePlan);
	}

	@Override
	public Integer updatePurchasePlanStateOrder(MainPurchasePlan mainPurchasePlan) {
		return mainPurchasePlanMapper.updatePurchasePlanStateOrder(mainPurchasePlan);
	}

	@Override
	public List<MainPurchasePlan> getPurchasePlan() {
		return mainPurchasePlanMapper.getPurchasePlan();
	}

	@Override
	public Integer updatePurchasePlanSupplier(MainPurchasePlan mainPurchasePlan) {
		return mainPurchasePlanMapper.updatePurchasePlanSupplier(mainPurchasePlan);
	}

}
