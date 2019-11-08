package com.drug.production.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.drug.entity.AddPlan;
import com.drug.entity.DayProductionPlan;
import com.drug.entity.ProductionOrder;

@Component
public interface DayPalnService {

	/**
	 * 	功能描述:日计划界面展示
	 * @return
	 */
	public List<DayProductionPlan> selectDayPalnView();

	/**
	 * 	功能描述:查看日计划详情
	 * @param dplanId
	 * @return
	 */
	public List<AddPlan> selectDplanDetails(Integer dplanId);

	/**
	 * 	功能描述:删除日计划
	 * @param dplanId
	 */
	public void deleteDplan(Integer dplanId);

	/**
	 * 	功能描述:修改日计划界面(查询)
	 * @param dplanId
	 * @return
	 */
	public List<AddPlan> selectUpdateView(Integer dplanId);

	/**
	 * 	功能描述:查询月计划完成总数量
	 * @return
	 */
	public AddPlan selectMplanNumber(Integer mplanId);

	/**
	 * 	功能描述:修改日计划详情的预留修改数量
	 * @param addPlan
	 */
	public void updatedDplanDetailsNum(AddPlan addPlan);

	/**
	 * 	功能描述:确认修改后把日计划详情表的计划生产数量换成预留的修改后的数量
	 * @param addPlan
	 */
	public void updateAffirmDplanDetails(AddPlan addPlan);

	/**
	 * 	功能描述:修改数量后,把预留的字段清零
	 * @param dplanId
	 * @return 
	 */
	public int updateDplanDetailsRes(Integer dplanId);

	/**
	 * 	功能描述:日计划审核
	 * @param dPlan
	 */
	public void updateDplanAudit(DayProductionPlan dPlan);

	/**
	 * 	功能描述:制定生产订单的查询界面
	 * @param dplanId
	 * @return
	 */
	public List<AddPlan> selectAddpo(Integer dplanId);

	/**
	 * 	功能描述:查询日计划详情中的成品日计划数量
	 * @param addPlan
	 * @return
	 */
	public AddPlan selectDplanQuantity(AddPlan addPlan);

	/**
	 * 	功能描述:修改日计划详情的预留生产数量
	 * @param addPlan
	 */
	public void updatePodsQuantity(AddPlan addPlan);

	/**
	 * 	功能描述:添加生产订单详情
	 * @param addPlan
	 */
	public void addProductionOrderDetails(AddPlan addPlan);

	/**
	 * 	功能描述:查询生产订单详细是否存在该成品
	 * @return
	 */
	public List<AddPlan> selectPoDetails();

	/**
	 * 	功能描述:修改存在的成品的数量
	 * @param addPlan
	 */
	public void updatePoPodsQuantity(AddPlan addPlan);

	/**
	 * 	功能描述:查询日计划所有成品生产总量
	 * @param dplanId
	 * @return
	 */
	public AddPlan selectQuantity(Integer dplanId);

	/**
	 * 	功能描述:添加生产订单
	 * @param dPlan
	 * @return
	 */
	public ProductionOrder addProductionOrder(ProductionOrder productionOrder);

	/**
	 * 	功能描述:修改生产订单详情的生产点单id(外键)
	 * @param poId
	 */
	public void updatePoId(Integer poId);

	/**
	 * 	功能描述:日计划表预留的生产数量字段清零
	 *
	 */
	public void updateResetPodsQuantity();

	/**
	 * 	功能描述:删除新增的生产订单详情(生产订单id为1的)
	 *
	 */
	public void deleteCancelPo();

	/**
	 * 功能描述:修改月计划详情的剩余完成数
	 * @param addPlan2
	 */
	public void updateMdetailsSurplusD(AddPlan addPlan2);

	/**
	 * 功能描述:查询月计划详情的剩余完成数
	 * @param mplanId
	 * @return
	 */
	public List<AddPlan> selectMplanDetailsProNum(Integer mplanId);

	/**
	 * 功能描述:查询日计划详情的剩余完成数
	 * @param dpdId
	 * @return
	 */
	public List<AddPlan> selectPodsSurplus(Integer dplanId);

	/**
	 * 功能描述:修改日计划详情的剩余生产数
	 * @param addPlan
	 */
	public void updatePodsSurplus(AddPlan addPlan);


}
