package com.drug.infoManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.BranchStorefactsheet;
import com.drug.infoManagement.mapper.BranchStoreInfoMapper;
import com.drug.infoManagement.service.BranchStoreInfoService;

/**
 * 类描述：分店信息管理
 * @author jhw
 * @dateTime 2019年10月24日上午10:12:34
 * @version 1.0
 */
@Service
public class BranchStoreInfoServiceImpl implements BranchStoreInfoService{
	
	@Autowired
	private BranchStoreInfoMapper branchStoreInfoMapper;
	/**
	 *方法功能：添加分店
	 * @param branchStore 分店对象
	 */
	@Override
	public void addBranchStorefactsheet(BranchStorefactsheet branchStore) {
		branchStoreInfoMapper.addBranchStorefactsheet(branchStore);
	}
	/**
	 * 方法功能：查询分店
	 * @return List<BranchStorefactsheet> 分店集合
	 */
	@Override
	public List<BranchStorefactsheet> queryBranchStorefactsheet(String pactState) {
		return branchStoreInfoMapper.queryBranchStorefactsheet(pactState);
	}


}
