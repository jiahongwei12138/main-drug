package com.drug.hhy.mapper;

import java.util.List;
import java.util.Map;

import com.drug.entity.MainPayment;

public interface PaymentMapper {
	public List<MainPayment>  AllMainPayment();
	
	public int updPurchasePlan(int planId);
	
	public int insertMainPaymentInf(Map<String, Object> map);
}
