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
	public void addProduct(MainProduct mainProduct,HttpSession session) {
		//生成随机数
		String string = UUID.randomUUID().toString();
		//获取会话域中的总店信息
		MainHeadquarters headquarter=(MainHeadquarters) session.getAttribute("headquarter");
		mainProduct.setProBatchNumber(string);
		mainProduct.setHqtId(headquarter.getHqtId());
		productAndRecipeMapper.addProduct(mainProduct);
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

}
