package com.drug.purchase.biz;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainPurchaseDetails;

public interface MainPurchaseDetailsBiz {
	
	public List<MainPurchaseDetails> getPurchaseDetails(Map map);
	
	public Integer insertPurchaseDetails(MainPurchaseDetails mainPurchaseDetails);
	
	public Integer updatePurchaseDetails(MainPurchaseDetails mainPurchaseDetails);
	
	public Integer updatePurchaseDetailsOrderState(MainPurchaseDetails mainPurchaseDetails);
	
}
