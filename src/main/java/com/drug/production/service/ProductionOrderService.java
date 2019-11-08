package com.drug.production.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.drug.entity.AddPlan;
import com.drug.entity.MaterialOrder;
import com.drug.entity.MaterialOrderDetails;
import com.drug.entity.ProductionOrder;
import com.drug.entity.ReturnOf;

@Component
public interface ProductionOrderService {

	/**
	 * 	功能描述:查询生产订单界面
	 * @return
	 */
	public List<ProductionOrder> selectProductionOrderView();

	/**
	 * 	功能描述:查询生产订单详情
	 * @param poId
	 * @return
	 */
	public List<AddPlan> selectproductionOrderDetails(Integer poId);

	/**
	 * 	功能描述:删除生产订单
	 * @param poId
	 */
	public void deleteProductionOrder(Integer poId);

	/**
	 * 	功能描述:审核生产订单
	 * @param productionOrder
	 */
	public void updatePoStatus(ProductionOrder productionOrder);

	/**
	 * 功能描述:新增领料表
	 * @param materialOrder
	 */
	public int addMaterialOrder(MaterialOrder materialOrder);

	/**
	 * 功能描述:查询成品所需要的配方原料数据
	 * @param poId
	 * @return
	 */
	public List<MaterialOrderDetails> selectRecipeRaw(Integer poId);

	/**
	 * 功能描述:添加领料表详情数据
	 * @param moDetails
	 */
	public void addMaterialOrderDetails(MaterialOrderDetails moDetails);

	/**
	 * 功能描述:修改生产订单领料状态poMaterialState
	 *
	 */
	public void updatePoMaterialState(Integer poId);

	/**
	 * 功能描述:修改生产订单的生产状态
	 * @param poId
	 */
	public void updatePoState(Integer poId);

	/**
	 * 功能描述:
	 * @return
	 */
	public List<AddPlan> selectOvrePo(Integer poId);

	/**
	 * 功能描述:修改生产订单详情已完成数
	 * @param addPlan
	 */
	public void updateAccomplishNum(AddPlan addPlan);

	/**
	 * 功能描述:新增成品质检管理详情
	 * @param addPlan
	 */
	public void addProductionQualityDetails(AddPlan addPlan);

	/**
	 * 功能描述:删除新增成品质检管理详情
	 *
	 */
	public void deleteCancelOver();

	/**
	 * 功能描述:恢复修改的生产订单详情已完成数
	 * @param poId
	 */
	public void updateCancelOver(Integer poId);

	/**
	 * 功能描述:查询生产成品管理详情(质检)表中是否存在该成品
	 * @return
	 */
	public List<AddPlan> selectPqDetails();

	/**
	 * 功能描述:成品存在,修改生产成品管理详情的成品数量
	 * @param addPlan
	 */
	public void updatePqDetails(AddPlan addPlan);

	/**
	 * 功能描述:新增生产成品管理(质检)
	 * @param materialOrder
	 */
	public void addProductionQuality(MaterialOrder materialOrder);

	/**
	 * 功能描述:修改成品质检管理详情的外键id
	 * @param pqId
	 */
	public void updatePqPqId(int pqId);

	/**
	 * 功能描述:查询所有生产订单详情实际完成量
	 * @param poId
	 * @return
	 */
	public AddPlan selectPoPracticalQuantity(Integer poId);

	/**
	 * 功能描述:修改生产订单实际完成量
	 * @param addPlan
	 */
	public void updatePoPracticalQuantity(AddPlan addPlan);

	/**
	 * 功能描述:修改月计划表实际完成数
	 * @param addPlan
	 */
	public void updateMrealityNumber(AddPlan addPlan);

	/**
	 * 	功能描述:连接查询剩余完成数
	 * @param poId 
	 */
	public List<AddPlan> selectMplanDetailsRealityNumber(Integer poId);

	/**
	 * 功能描述:修改月计划详情剩余完成数
	 * @param addPlan
	 */
	public void updateMplanDetailsAddSurplus(AddPlan addPlan);

	/**
	 * 功能描述:修改结束生产状态
	 * @param poId
	 */
	public void updateProductionOrder(Integer poId);

	/**
	 * 功能描述:新增退料表
	 * @param returnOf
	 */
	public void addreturnOf(ReturnOf returnOf);


}
