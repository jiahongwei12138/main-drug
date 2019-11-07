package com.drug.purchase.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainPurchaseDetails;
@Repository
public interface MainPurchaseDetailsMapper {

	public List<MainPurchaseDetails> getPurchaseDetails(Map map);
	
	public Integer insertPurchaseDetails(MainPurchaseDetails mainPurchaseDetails);
	
	public Integer updatePurchaseDetails(MainPurchaseDetails mainPurchaseDetails);
	
	public Integer updatePurchaseDetailsOrderState(MainPurchaseDetails mainPurchaseDetails);

}
