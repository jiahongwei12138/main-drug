package com.drug.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.ProductManagement;
import com.drug.production.mapper.ProductManagementMapper;
import com.drug.production.service.ProductManagementService;

@Service
public class ProductManagementServiceImpl implements ProductManagementService{
	@Autowired
	private ProductManagementMapper productManagementMapper; 
	@Override
	public List<ProductManagement> selectMainProductAll() {
		List<ProductManagement> list=productManagementMapper.selectMainProductAll();
		return list;
	}
	@Override
	public void deleteMainProductById(Integer proId) {
		productManagementMapper.deleteMainProductById(proId);
		
	}
	@Override
	public void checkMainProduct(Integer proId) {
		productManagementMapper.checkMainProduct(proId);
	}
	
}
