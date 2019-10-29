package com.drug.infoManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainProduct;
import com.drug.infoManagement.service.BranchClientService;

@Controller
public class BranchClientController {

	@Autowired
	private BranchClientService branchClientService;
	
	@RequestMapping("/getProduct")
	@ResponseBody
	public Object getProduct() {
		List<MainProduct> products=branchClientService.getProduct();
		return products;
	}
}
