package com.drug.infoManagement.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainProduct;
import com.drug.infoManagement.mapper.ProductAndRecipeMapper;
import com.drug.infoManagement.service.ProductAndRecipeService;
@Service
public class productAndRecipeServiceImpl implements ProductAndRecipeService{

	@Autowired
	private ProductAndRecipeMapper productAndRecipeMapper;
	
	@Override
	public void addProduct(MainProduct mainProduct,HttpSession session) {
		String string = UUID.randomUUID().toString();
		MainHeadquarters headquarter=(MainHeadquarters) session.getAttribute("headquarter");
		mainProduct.setProBatchNumber(string);
		mainProduct.setHqtId(headquarter.getHqtId());
		productAndRecipeMapper.addProduct(mainProduct);
	}

	@Override
	public List<MainProduct> queryProduct() {
		return productAndRecipeMapper.queryProduct();
	}

	@Override
	public void updateProStateById(Integer proId) {
		productAndRecipeMapper.updateProStateById(proId);
	}

	@Override
	public void updateRecipeStateById(Integer recipeId) {
		productAndRecipeMapper.updateRecipeStateById(recipeId);
	}

}
