package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainProduct;
import com.drug.entity.MainRawMaterial;
import com.drug.entity.MainRecipe;
import com.drug.entity.MainRecipedetail;
import com.drug.infoManagement.service.ProductAndRecipeService;
import com.drug.util.ToolClass;
import com.drug.warehouse.mapper.MainProductStorageMapper;
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
	@Autowired
	private MainProductStorageMapper mainProductStorageMapper;
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
			int proId = productAndRecipeService.addProduct(mainProduct,session);
			System.err.println("成品Id"+proId);
			mainProductStorageMapper.insInfToProStore1(proId);
			mainProductStorageMapper.insInfToProStore2(proId);
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
	/**
	 * 方法功能：查询原 材料
	 * @return List<MainRawMaterial> 原材料集合
	 */
	@RequestMapping("/queryRawMaterial")
	@ResponseBody
	public List<MainRawMaterial> queryRawMaterial() {
		List<MainRawMaterial> rawMaterials=productAndRecipeService.queryRawMaterial();
		return rawMaterials;
	}
	/**
	 * 方法功能：添加配方详情
	 * @param mainRecipedetail 配方详情对象
	 * @return boolean 添加结果  true：添加成功  false:添加失败
	 */
	@RequestMapping("/addRecipedetail")
	@ResponseBody
	public boolean addRecipedetail(MainRecipedetail mainRecipedetail) {
		try {
			if (mainRecipedetail.getRecipeId()==null) {
				mainRecipedetail.setRecipeId(0);
			}
			productAndRecipeService.addRecipedetail(mainRecipedetail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 方法功能：查询配方详情中配方id为0
	 * @return Map<String, Object> 配方详情集合
	 * @param recipeId配方id
	 */
	@RequestMapping("/queryRecipedetail")
	@ResponseBody
	public Map<String, Object> queryRecipedetail(Integer recipeId) {
		if (recipeId==null) {
			recipeId=0;
		}
		List<MainRecipedetail> recipedetails=productAndRecipeService.queryRecipedetail(recipeId);
		Map<String, Object> map = ToolClass.responseByData(recipedetails, recipedetails.size());
		return map;
	}
	/**
	 * 方法功能：查询员工id和姓名
	 * @return List<MainEmployee> 员工集合
	 */
	@RequestMapping("/queryEmpIdAndName")
	@ResponseBody
	public List<MainEmployee> queryEmp() {
		List<MainEmployee> employees=productAndRecipeService.queryEmpIdAndName();
		return employees;
	}
	/**
	 * 方法功能：添加配方
	 * @return List<MainEmployee> 员工集合
	 */
	@RequestMapping("/addRecipe")
	@ResponseBody
	public boolean addRecipe(MainRecipe recipe) {
		try {
			productAndRecipeService.addRecipe(recipe);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 方法功能：删除配方详情
	 * @param reDetailId 配方详情id
	 * @return boolean 删除结果  true：删除成功  false:删除失败
	 */
	@RequestMapping("/deletRecipeById")
	@ResponseBody
	public boolean deletRecipeById(Integer reDetailId) {
		try {
			productAndRecipeService.deletRecipeById(reDetailId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
