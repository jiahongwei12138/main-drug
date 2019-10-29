package com.drug.infoManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainProduct;
import com.drug.infoManagement.mapper.BranchClientMapper;
import com.drug.infoManagement.service.BranchClientService;
@Service
public class BranchClientServiceImpl implements BranchClientService{

	@Autowired
	private BranchClientMapper branchClientMapper;
	
	@Override
	public List<MainProduct> getProduct() {
		return branchClientMapper.getProduct();
	}

}
