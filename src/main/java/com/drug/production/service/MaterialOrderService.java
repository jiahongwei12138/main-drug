package com.drug.production.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.drug.entity.MaterialOrder;

@Component
public interface MaterialOrderService {

	/**
	 * 功能描述:生产领料界面数据查询
	 * @return
	 */
	public List<MaterialOrder> selectMaterialOrderView();

	/**
	 * 功能描述:查询生产领料详情
	 * @param moId
	 * @return
	 */
	public List<MaterialOrder> selectMorDetails(Integer moId);

	/**
	 * 功能描述:删除领料表
	 * @param moId
	 */
	public void deleteMaterialOrder(Integer moId);

	/**
	 * 功能描述:审核领料表
	 * @param MaterialOrder materialOrder
	 */
	public void updateMaterialOrderStatus(MaterialOrder materialOrder);
	
	/**
	 * 功能描述:签收原料
	 * @param moId
	 */
	public void updateMoSignfor(Integer moId);

	/**
	 * 功能描述:签收领料后修改生产订单的领料状态
	 * @param poId
	 */
	public void updatePickingPoMaterialState(Integer poId);
	
}
