package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainProduct;
import com.drug.infoManagement.service.ProductAndRecipeService;
import com.drug.util.ToolClass;
/**
 * 类描述：药品及配方管理
 * @author jhw
 * @dateTime 2019年10月23日下午9:12:11
 * @version 1.0
 */
@Controller
public class ProductAndRecipeController {

	@Autowired
	private ProductAndRecipeService productAndRecipeService;
	/**
	   *方法功能：添加药品
	 * @param mainProduct 药品对象
	 * @param session 会话对象
	 * @return boolean 添加结果  true：添加成功  false：添加失败
	 */
	@RequestMapping("/addProduct")
	@ResponseBody
	public boolean addProduct(MainProduct mainProduct,HttpSession session) {
		try {
			productAndRecipeService.addProduct(mainProduct,session);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	   *方法功能：查询药品
	 * @return Map<String,Object> 药品集合
	 */
	@RequestMapping("/queryProduct")
	@ResponseBody
	public Map<String, Object> queryProduct() {
		List<MainProduct> mainProducts=productAndRecipeService.queryProduct();
		Map<String, Object> map = ToolClass.responseByData(mainProducts, mainProducts.size());
		return map;
	}
	/**
	   *方法功能：修改药品审核状态
	 * @param proId 药品id
	 * @return boolean 修改结果  true：修改成功  false:修改失败
	 */
	@RequestMapping("/updateProStateById")
	@ResponseBody
	public boolean updateProStateById(Integer proId) {
		try {
			productAndRecipeService.updateProStateById(proId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	   *方法功能：修改配方审核状态
	 * @param recipeId 配方id
	 * @return boolean 修改结果  true：修改成功  false:修改失败
	 */
	@RequestMapping("/updateRecipeStateById")
	@ResponseBody
	public boolean updateRecipeStateById(Integer recipeId) {
		try {
			productAndRecipeService.updateRecipeStateById(recipeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
