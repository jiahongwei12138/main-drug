package com.drug.production.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.ProductManagement;

@Repository
public interface ProductManagementMapper {

	public List<ProductManagement> selectMainProductAll();
	
	public void deleteMainProductById(Integer proId);
	
	public void checkMainProduct(Integer proId);
}
