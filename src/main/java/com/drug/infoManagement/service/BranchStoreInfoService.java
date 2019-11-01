package com.drug.infoManagement.service;

import java.util.List;

import com.drug.entity.BranchStorefactsheet;

/**
 * 类描述：分店信息管理
 * @author jhw
 * @dateTime 2019年10月24日上午10:11:38
 * @version 1.0
 */
public interface BranchStoreInfoService {
	/**
	 *方法功能：添加分店
	 * @param branchStore 分店对象
	 */
	public void addBranchStorefactsheet(BranchStorefactsheet branchStore);
	/**
	 * 方法功能：查询分店
	 * @return List<BranchStorefactsheet> 分店集合
	 */
	public List<BranchStorefactsheet> queryBranchStorefactsheet(String pactState);

}
