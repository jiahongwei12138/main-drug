package com.drug.purchase.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.purchase.biz.MainPurchaseDetailsBiz;
import com.drug.entity.MainPurchaseDetails;
import com.drug.purchase.mapper.MainPurchaseDetailsMapper;

@Service
public class MainPurchaseDetailsBizImpl implements MainPurchaseDetailsBiz{
	@Autowired
	private MainPurchaseDetailsMapper mainPurchaseDetailsMapper;

	@Override
	public List<MainPurchaseDetails> getPurchaseDetails(Map map) {
		return mainPurchaseDetailsMapper.getPurchaseDetails(map);
	}

	@Override
	public Integer insertPurchaseDetails(MainPurchaseDetails mainPurchaseDetails) {
		return mainPurchaseDetailsMapper.insertPurchaseDetails(mainPurchaseDetails);
	}

	@Override
	public Integer updatePurchaseDetails(MainPurchaseDetails mainPurchaseDetails) {
		return mainPurchaseDetailsMapper.updatePurchaseDetails(mainPurchaseDetails);
	}

	@Override
	public Integer updatePurchaseDetailsOrderState(MainPurchaseDetails mainPurchaseDetails) {
		return mainPurchaseDetailsMapper.updatePurchaseDetailsOrderState(mainPurchaseDetails);
	}

	
	
	
	
}
