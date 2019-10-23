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

@Controller
public class ProductAndRecipeController {

	@Autowired
	private ProductAndRecipeService productAndRecipeService;
	
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
	@RequestMapping("/queryProduct")
	@ResponseBody
	public Map<String, Object> queryProduct() {
		List<MainProduct> mainProducts=productAndRecipeService.queryProduct();
		Map<String, Object> map = ToolClass.responseByData(mainProducts, mainProducts.size());
		return map;
	}
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
