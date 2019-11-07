package com.drug.production.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.ProductManagement;
import com.drug.production.service.ProductManagementService;
import com.drug.util.ToolClass;

@RestController
public class ProductManagementController {
	@Autowired
	private ProductManagementService productManagementService;
	
	@RequestMapping("selectMainProductAll.do")
	public Map<String, Object> selectMainProductAll(){
		
		List<ProductManagement> list=productManagementService.selectMainProductAll();
		Map<String, Object> map=ToolClass.responseByData(list, 0);
		return map;
	}
	
	@RequestMapping("deleteMainProductById.do")
	public boolean deleteMainProductById(Integer proId) {
			productManagementService.deleteMainProductById(proId);
			return true;
	}
	
	@RequestMapping("checkMainProduct.do")
	public boolean checkMainProduct(Integer proId) {
		productManagementService.checkMainProduct(proId);
		return true;
	}
	
}
