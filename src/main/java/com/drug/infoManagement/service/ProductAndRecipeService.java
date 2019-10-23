package com.drug.infoManagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.drug.entity.MainProduct;

public interface ProductAndRecipeService {

	void addProduct(MainProduct mainProduct,HttpSession session);

	List<MainProduct> queryProduct();

	void updateProStateById(Integer proId);

	void updateRecipeStateById(Integer recipeId);

}
