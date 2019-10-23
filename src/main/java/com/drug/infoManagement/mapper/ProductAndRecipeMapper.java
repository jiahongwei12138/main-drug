package com.drug.infoManagement.mapper;

import java.util.List;

import com.drug.entity.MainProduct;
/**
 * 类描述：药品及配方管理
 * @author jhw
 * @dateTime 2019年10月23日下午9:17:12
 * @version 1.0
 */
public interface ProductAndRecipeMapper {
	/**
	   *方法功能：添加药品
	 * @param mainProduct 药品对象
	 * @param session 会话对象
	 */
	void addProduct(MainProduct mainProduct);
	/**
	   *方法功能：查询药品
	 * @return List<MainProduct> 药品集合
	 */
	List<MainProduct> queryProduct();
	/**
	   *方法功能：修改药品审核状态
	 * @param proId 药品id
	 */
	void updateProStateById(Integer proId);
	/**
	   *方法功能：修改配方审核状态
	 * @param recipeId 配方id
	 */
	void updateRecipeStateById(Integer recipeId);

}
