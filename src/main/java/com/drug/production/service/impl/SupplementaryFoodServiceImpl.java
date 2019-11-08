package com.drug.production.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.production.mapper.SupplementaryFoodMapper;
import com.drug.production.service.SupplementaryFoodService;

@Service
public class SupplementaryFoodServiceImpl implements SupplementaryFoodService{
	
	@Autowired
	private SupplementaryFoodMapper supplementaryFoodMapper;
	
}
