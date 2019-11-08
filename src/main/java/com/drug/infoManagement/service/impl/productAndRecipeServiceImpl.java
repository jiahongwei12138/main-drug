package com.drug.infoManagement.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainHeadquarters;
import com.drug.entity.MainProduct;
import com.drug.entity.MainRawMaterial;
import com.drug.entity.MainRecipe;
import com.drug.entity.MainRecipedetail;
import com.drug.infoManagement.mapper.ProductAndRecipeMapper;
import com.drug.infoManagement.service.ProductAndRecipeService;
/**
 * 类描述：药品及配方管理
 * @author jhw
 * @dateTime 2019年10月23日下午9:15:56
 * @version 1.0
 */
@Service
public class productAndRecipeServiceImpl implements ProductAndRecipeService{

	@Autowired
	private ProductAndRecipeMapper productAndRecipeMapper;
	/**
	   *方法功能：添加药品
	 * @param mainProduct 药品对象
	 * @param session 会话对象
	 */
	@Override
	public int addProduct(MainProduct mainProduct,HttpSession session) {
		//生成随机数
		String string = UUID.randomUUID().toString();
		//获取会话域中的总店信息
		MainHeadquarters headquarter=(MainHeadquarters) session.getAttribute("headquarter");
		mainProduct.setProBatchNumber(string);
		mainProduct.setHqtId(headquarter.getHqtId());
		 int n = productAndRecipeMapper.addProduct(mainProduct);
		 System.err.println(mainProduct.getProId()+"  " + n);
		 return mainProduct.getProId();
	}
	/**
	   *方法功能：查询药品
	 * @return List<MainProduct> 药品集合
	 */
	@Override
	public List<MainProduct> queryProduct() {
		return productAndRecipeMapper.queryProduct();
	}
	/**
	   *方法功能：修改药品审核状态
	 * @param proId 药品id
	 */
	@Override
	public void updateProStateById(Integer proId) {
		productAndRecipeMapper.updateProStateById(proId);
	}
	/**
	   *方法功能：修改配方审核状态
	 * @param recipeId 配方id
	 */
	@Override
	public void updateRecipeStateById(Integer recipeId) {
		productAndRecipeMapper.updateRecipeStateById(recipeId);
	}
	/**
	 * 方法功能：查询原 材料
	 * @return List<MainRawMaterial> 原材料集合
	 */
	@Override
	public List<MainRawMaterial> queryRawMaterial() {
		return productAndRecipeMapper.queryRawMaterial();
	}
	/**
	 * 方法功能：添加配方详情
	 * @param mainRecipedetail 配方详情对象
	 */
	@Override
	public void addRecipedetail(MainRecipedetail mainRecipedetail) {
		productAndRecipeMapper.addRecipedetail(mainRecipedetail);
	}
	/**
	 * 方法功能：查询配方详情中配方id为0
	 * @return List<MainRecipedetail> 配方详情集合
	 * @param recipeId配方id
	 */
	@Override
	public List<MainRecipedetail> queryRecipedetail(Integer recipeId) {
		return productAndRecipeMapper.queryRecipedetail(recipeId);
	}
	/**
	 * 方法功能：查询员工id和姓名
	 * @return List<MainEmployee> 员工集合
	 */
	@Override
	public List<MainEmployee> queryEmpIdAndName() {
		return productAndRecipeMapper.queryEmpIdAndName();
	}
	/**
	 * 方法功能：添加配方
	*/
	@Override
	public void addRecipe(MainRecipe recipe) {
		productAndRecipeMapper.addRecipe(recipe);
		productAndRecipeMapper.updateRecipeDetailRecipeId(recipe.getRecipeId());
	}
	/**
	 * 方法功能：删除配方详情
	 * @param reDetailId 配方详情id
	 */
	@Override
	public void deletRecipeById(Integer reDetailId) {
		productAndRecipeMapper.deletRecipeById(reDetailId);
	}

}
