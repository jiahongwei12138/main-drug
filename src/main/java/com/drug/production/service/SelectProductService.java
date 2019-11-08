package com.drug.production.service;

import java.io.IOException;
import java.util.List;


import org.springframework.stereotype.Component;

import com.drug.entity.AddPlan;
import com.drug.entity.AddPlans;
import com.drug.entity.MProductionPlan;
import com.drug.entity.MainEmployee;
import com.drug.entity.MainProduct;

@Component
public interface SelectProductService {
	/**
	 * 	功能描述:查询药品
	 * @return
	 */
	public List<MainProduct> selectProduct();
	
	/**
	 * 	功能描述:添加月计划详情表
	 * @param proId
	 * @param proName
	 * @param number
	 * @return
	 */
	public int addMPlan(String proId, String proName, String number) throws IOException;
	
	/**
	 * 	功能描述:查询月计划详情(界面)
	 * @return
	 */
	public List<AddPlan> selectMplanDetails();
	
	/**
	 * 	功能描述:添加月计划表
	 * @param addPlans 
	 * @return
	 */
	public int addMplans(AddPlans addPlans);

	/**
	 * 	功能描述:查询员工信息
	 * @return
	 */
	public List<MainEmployee> selectEmployee();

	/**
	 * 	功能描述:修改月计划详情表的(外键)月计划表主键
	 * @param mPlanId
	 * @return
	 */
	public int updateMplanDetails(int mPlanId);
	
	/**
	 * 功能描述:修改取消后恢复原来的数据
	 *
	 */
	public void delectRestoreMPlan();

	/**
	 * 功能描述:修改月计划中的删除(修改月计划详情表中的外键id为2)
	 * @param mpdId
	 */
	public void deleteEditProduct(Integer mpdId);
	
	/**
	 * 功能描述:恢复修改前删除的数据
	 * @param mplanId
	 */
	public void updateEditProduct(Integer mplanId);
	
	/**
	 * 功能描述:确认后修改(月计划修改中新增的数据)
	 * @param mplanId
	 */
	public void updateEditAffirm(Integer mplanId);
	
	/**
	 * 功能描述:确认后修改(月计划修改中删除的数据)
	 *
	 */
	public void updateDelAffirm();
	
	/**
	 * 功能描述:查询修改后的月计划成品总数量
	 * @param mplanId
	 * @return 
	 */
	public AddPlan selectEditAffirmNum(Integer mplanId);
	
	/**
	 * 功能描述:修改日计划单中的计划总数
	 * @param addPlan
	 */
	public void updateMplanNumber(AddPlan addPlan);
	
	
	
	
	
	
	/**
	 * 	功能描述:查询月计划表中成品的总数
	 * @return
	 */
	public int selectQuantity();

	/**
	 * 	功能描述:点击第一个取消删除刚刚添加的数据
	 * @return
	 */
	public int deleteCancel();

	/**
	 * 	功能描述:根据id查看月计划详情
	 *
	 */
	public List<AddPlan> queryMplanDetails(Integer mplanId);

	/**
	 * 	功能描述:删除月计划表(修改显示状态)
	 * @return
	 */
	public int deleteMplan(Integer mplanId);

	/**
	 * 	功能描述:删除月计划详情订单的单个成品
	 * @return
	 */
	public int deleteProduct(Integer mpdId);

	/**
	 * 	功能描述:生产月计划审核
	 * @return
	 */
	public int updateAudit(MProductionPlan mProductionPlan);


	/**
	 * 功能描述:查询制定日计划界面参数
	 *
	 */
	public List<AddPlan> selectDplanDetails(Integer mplanId);

	/**
	 * 功能描述:修改月计划详情表里面为日计划预留的计划生产数
	 * @param addPlan
	 */
	public void updatedQuantity(AddPlan addPlan);

	/**
	 * 功能描述:新增日计划详情(日计划表id暂时设为1,确定后再修改)
	 * @param addPlan
	 */
	public void addDplanDetails(AddPlan addPlan);

	/**
	 * 功能描述:新增之前查询一次如果商品之前添加过则只修改数量
	 * @return
	 */
	public List<AddPlan> selectdPlanDetailsProId();

	/**
	 * 功能描述:修改日生产详情表计划数量
	 * @param addPlan
	 */
	public void updatedPlanQuantity(AddPlan addPlan);

	/**
	 * 功能描述:插入日计划表
	 * @param addPlans
	 */
	public int addDplan(AddPlans addPlans);

	/**
	 * 功能描述:插入日计划详情后返回id再修改日计划详情的外键
	 * @param dPlanId
	 */
	public void updateDetDPlanId(int dPlanId);

	/**
	 * 功能描述:月计划详情表预留的日计划生产数量清零
	 *
	 */
	public void updateDquantityReset();

	/**
	 * 功能描述:当月日计划完成总数
	 * @param addPlan
	 * @return
	 */
	public List<AddPlan> selectAllDplanQuantity(AddPlan addPlan);

	/**
	 * 功能描述:取消制定日计划后删除表中的新增
	 *
	 */
	public void deleteCancelMplanDetails();

	/**
	 * 功能描述:查询月计划详情表中的剩余数量
	 * @param mplanId 
	 * @return
	 */
	public List<AddPlan> selectmDetailsSurplus(Integer mplanId);

	/**
	 * 功能描述:修改月计划详情表中的剩余数量
	 * @param addPlan
	 */
	public void updatemDetailsSurplus(AddPlan addPlan);


}
