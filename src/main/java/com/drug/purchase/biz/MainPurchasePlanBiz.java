package com.drug.purchase.biz;

import java.util.List;

import com.drug.entity.MainPurchasePlan;

public interface MainPurchasePlanBiz {
	
	public List<MainPurchasePlan> getPurchasePlanOrder(String planState);
	
	public List<MainPurchasePlan> getPurchasePlan();
	
	public Integer updatePurchasePlanStateOrder(MainPurchasePlan mainPurchasePlan);

	public Integer insertPurchasePlan(MainPurchasePlan mainPurchasePlan);
	
	public Integer updatePurchasePlan(MainPurchasePlan mainPurchasePlan);
	
	public Integer updatePurchasePlanState(MainPurchasePlan mainPurchasePlan);
	
	public Integer updatePurchasePlanSupplier(MainPurchasePlan mainPurchasePlan);
	
}
