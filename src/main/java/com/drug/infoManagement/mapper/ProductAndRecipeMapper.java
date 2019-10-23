package com.drug.infoManagement.mapper;

import java.util.List;

import com.drug.entity.MainProduct;

public interface ProductAndRecipeMapper {

	void addProduct(MainProduct mainProduct);

	List<MainProduct> queryProduct();

	void updateProStateById(Integer proId);

	void updateRecipeStateById(Integer recipeId);

}
