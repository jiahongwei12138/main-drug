package com.drug.hhy.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainPayment;
import com.drug.hhy.Service.PaymentService;
import com.drug.hhy.mapper.PaymentMapper;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentMapper paymentMapper;

	@Override
	public List<MainPayment> AllMainPayment() {
		return paymentMapper.AllMainPayment();
	}

	@Override
	public int updPurchasePlan(int planId) {
		return paymentMapper.updPurchasePlan(planId);
	}

	@Override
	public int insertMainPaymentInf(Map<String, Object> map) {
		return paymentMapper.insertMainPaymentInf(map);
	}

}
