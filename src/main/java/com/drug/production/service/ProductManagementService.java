package com.drug.production.service;

import java.util.List;


import com.drug.entity.ProductManagement;


public interface ProductManagementService {

	public List<ProductManagement> selectMainProductAll();
	
	public void deleteMainProductById(Integer proId);

	public void checkMainProduct(Integer proId);
}
