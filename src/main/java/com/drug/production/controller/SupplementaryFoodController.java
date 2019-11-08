package com.drug.production.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.drug.production.service.SupplementaryFoodService;

@RestController
public class SupplementaryFoodController {
	
	@Autowired
	private SupplementaryFoodService supplementaryFoodService;
}
