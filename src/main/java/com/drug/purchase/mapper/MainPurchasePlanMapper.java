package com.drug.purchase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainPurchasePlan;
@Repository
public interface MainPurchasePlanMapper {
	
	public List<MainPurchasePlan> getPurchasePlanOrder(String planState);
	
	public List<MainPurchasePlan> getPurchasePlan();
	
	public Integer updatePurchasePlanStateOrder(MainPurchasePlan mainPurchasePlan);
	
	public Integer insertPurchasePlan(MainPurchasePlan mainPurchasePlan);
	
	public Integer updatePurchasePlan(MainPurchasePlan mainPurchasePlan);
	
	public Integer updatePurchasePlanState(MainPurchasePlan mainPurchasePlan);
	
	public Integer updatePurchasePlanSupplier(MainPurchasePlan mainPurchasePlan);
	
}
