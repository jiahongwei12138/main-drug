package com.drug.infoManagement.mapper;

import java.util.List;

import com.drug.entity.MainBranchbacksale;
import com.drug.entity.MainBranchbacksaledetail;
/**
 * 类描述：分店退货订单
 * @author jhw
 * @dateTime 2019年10月30日上午9:47:06
 * @version 1.0
 */
public interface BranchBackSaleMapper {
	/**
	 * 方法功能：查询退货单
	 * @param branchbacksale 退货单对象
	 * @return List<MainBranchbacksale> 退货单集合
	 */
	List<MainBranchbacksale> queryBranchBackSaleOrder(MainBranchbacksale branchbacksale);
	/**
	 * 方法功能：审核退货单
	 * @param backSaleId 退货单id
	 */
	void checkbackOrder(Integer backSaleId);
	/**
	 * 方法功能：质检退货单
	 * @param backSaleId 退货单id
	 */
	void checkOrderInStoreCheckState(Integer backSaleId);
	/**
	 * 方法功能：删除退货单
	 * @param backSaleId 退货单id
	 */
	void deleteBackSaleOrder(Integer backSaleId);
	/**
	 * 方法功能：查询退货订单详情
	 * @param backSaleId 退货单id
	 * @return List<MainBranchbacksaledetail> 退货单详情集合
	 */
	List<MainBranchbacksaledetail> queryBackSaleOrderDetail(Integer backSaleId);
	/**
	 * 方法功能：删除退货单详情
	 * @param backSaleId 退货单id
	 */
	void deleteBackSaleOrderDetial(Integer backSaleId);

}
