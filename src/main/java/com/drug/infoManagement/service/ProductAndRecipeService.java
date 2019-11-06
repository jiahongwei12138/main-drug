package com.drug.infoManagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainProduct;
import com.drug.entity.MainRawMaterial;
import com.drug.entity.MainRecipe;
import com.drug.entity.MainRecipedetail;
/**
 * 类描述：药品及配方管理
 * @author jhw
 * @dateTime 2019年10月23日下午9:14:36
 * @version 1.0
 */
public interface ProductAndRecipeService {
	/**
	   *方法功能：添加药品
	 * @param mainProduct 药品对象
	 * @param session 会话对象
	 */
	void addProduct(MainProduct mainProduct,HttpSession session);
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
	/**
	 * 方法功能：查询原 材料
	 * @return List<MainRawMaterial> 原材料集合
	 */
	List<MainRawMaterial> queryRawMaterial();
	/**
	 * 方法功能：添加配方详情
	 * @param mainRecipedetail 配方详情对象
	 */
	void addRecipedetail(MainRecipedetail mainRecipedetail);
	/**
	 * 方法功能：查询配方详情中配方id为0
	 * @return List<MainRecipedetail> 配方详情集合
	 * @param recipeId配方id
	 */
	List<MainRecipedetail> queryRecipedetail(Integer recipeId);
	/**
	 * 方法功能：查询员工id和姓名
	 * @return List<MainEmployee> 员工集合
	 */
	List<MainEmployee> queryEmpIdAndName();
	/**
	 * 方法功能：添加配方
	*/
	void addRecipe(MainRecipe recipe);
	/**
	 * 方法功能：删除配方详情
	 * @param reDetailId 配方详情id
	 */
	void deletRecipeById(Integer reDetailId);

}
