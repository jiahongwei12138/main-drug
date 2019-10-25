package com.drug.infoManagement.mapper;

import java.util.List;

import com.drug.entity.BranchStorefactsheet;

/**
 * 类描述：分店信息管理
 * @author jhw
 * @dateTime 2019年10月24日上午10:14:33
 * @version 1.0
 */
public interface BranchStoreInfoMapper {

	/**
	 * 方法功能：添加分店
	 * @param branchStore 分店对象
	 */
	void addBranchStorefactsheet(BranchStorefactsheet branchStore);
	/**
	 * 方法功能：查询分店
	 * @return List<BranchStorefactsheet> 分店集合
	 */
	List<BranchStorefactsheet> queryBranchStorefactsheet();

}
