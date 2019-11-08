package com.drug.production.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.AddPlan;
import com.drug.entity.DayProductionPlan;
import com.drug.entity.ProductionOrder;
import com.drug.production.mapper.SelectProductMapper;
import com.drug.production.service.DayPalnService;
import com.drug.util.ToolClass;

@RestController
public class DayPalnController {
	
	@Autowired
	private DayPalnService dayPalnService;
	
	@Autowired
	private AddPlan addPlan;
	
	@Autowired
	private AddPlan addPlan2;
	
	@Autowired
	private AddPlan addPlan3;
	
	@Autowired
	private SelectProductMapper selectProductMapper;
	
	/**
	 *	 功能描述:日计划界面展示
	 * @return
	 */
	@RequestMapping("selectDayPalnView")
	public Map<String, Object> selectDayPalnView() {
		List<DayProductionPlan> list= dayPalnService.selectDayPalnView();
		Map<String, Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 	功能描述:查看日计划详情
	 * @param dplanId
	 * @return
	 */
	@RequestMapping("selectDplanDetails")
	public Map<String, Object> selectDplanDetails(Integer dplanId) {
		List<AddPlan> list=dayPalnService.selectDplanDetails(dplanId);
		Map<String, Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:删除日计划
	 * @param dplanId
	 * @param mplanId
	 */
	@RequestMapping("deleteDplan")
	public void deleteDplan(Integer dplanId,Integer mplanId) {
		dayPalnService.deleteDplan(dplanId);
		//删除日计划后后恢复月计划剩余数量
		List<AddPlan> list=dayPalnService.selectDplanDetails(dplanId);
		for(AddPlan a:list) {
			addPlan.setProId(a.getProId());
			addPlan.setDPlanQuantity(a.getDPlanQuantity());
			
		}
	}
	
	/**
	 * 	功能描述:修改日计划界面(查询)
	 * @return
	 */
	@RequestMapping("selectUpdateView")
	public Map<String, Object> selectUpdateView(Integer dplanId) {
		List<AddPlan> list=dayPalnService.selectUpdateView(dplanId);
		Map<String, Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 	功能描述:修改日计划详情表预留的修改后的数量
	 * @param proId
	 * @param dpdId
	 * @param ed
	 * @param number
	 * @return
	 */
	@RequestMapping("updateDplanDetailsProNum")
	public void updateDplanDetailsProNum(Integer proId,Integer dpdId,Integer ed,Integer mplanId) {
		//查询月计划完成总数量
		AddPlan addPlan=dayPalnService.selectMplanNumber(mplanId);
		addPlan.setDpdId(dpdId);
		addPlan.setNumber(ed);
		//修改日计划详情的预留修改数量
		dayPalnService.updatedDplanDetailsNum(addPlan);
	}
	
	/**
	 * 功能描述:查询月计划详情的剩余完成数与输入的数比较大小
	 *
	 */
	@RequestMapping("selectMplanDetailsProNum")
	public int selectMplanDetailsProNum(Integer mplanId,Integer proId) {
		List<AddPlan> list=dayPalnService.selectMplanDetailsProNum(mplanId);
		for(AddPlan a: list) {
			if(a.getProId()==proId) {
				return a.getMDetailsSurplus();
			}
		}
		return -1;
	}
	
	/**
	 * 	功能描述:确认修改后把日计划详情表的计划生产数量换成预留的修改后的数量
	 * @param mplanId
	 * @param dplanId
	 */
	@RequestMapping("updateAffirmDplanDetails")
	public void updateAffirmDplanDetails(Integer mplanId,Integer dplanId) {
		List<AddPlan> list=dayPalnService.selectUpdateView(dplanId);
		for(AddPlan a : list) {
			addPlan3.setMplanId(mplanId);
			addPlan3.setProId(a.getProId());
			int result=0;
			List<AddPlan> listNum =selectProductMapper.selectAllDplanQuantity(addPlan3);
			for(AddPlan c:listNum) {
				result=c.getNumber();
			}
			System.err.println(result);
			addPlan2.setProId(a.getProId());
			addPlan2.setMplanId(mplanId);
			addPlan2.setNumber(result+a.getNumber()-a.getDPlanQuantity());
			//修改月计划详情的剩余完成数
			dayPalnService.updateMdetailsSurplusD(addPlan2);
			//确认修改后把日计划详情表的计划生产数量换成预留的修改后的数量
			addPlan.setDpdId(a.getDpdId());
			addPlan.setNumber(a.getNumber());
			dayPalnService.updateAffirmDplanDetails(addPlan);
		}
		//修改数量后,把预留的字段清零
		dayPalnService.updateDplanDetailsRes(dplanId);
	}
	
	/**
	 * 	功能描述:修改取消后数据复原
	 * @param dplanId
	 * @return
	 */
	@RequestMapping("updateDplanDetailsCancel")
	public boolean updateDplanDetailsCancel(Integer dplanId) {
		dayPalnService.updateDplanDetailsRes(dplanId);
		return true;
	}
	
	/**
	 * 	功能描述:日计划审核
	 * @param dPlan
	 * @param dplanId
	 */
	@RequestMapping("updateDplanAudit")
	public boolean updateDplanAudit(DayProductionPlan dPlan,Integer dplanId) {
		dPlan.setDPlanId(dplanId);
		dayPalnService.updateDplanAudit(dPlan);
		return true;
	}
	
	/**
	 * 	功能描述:制定生产订单的查询界面
	 * @return
	 */
	@RequestMapping("selectAddpo")
	public Map<String, Object> selectAddpo(Integer dplanId) {
		List<AddPlan> list=dayPalnService.selectAddpo(dplanId);
		Map<String, Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:查询日计划详情的剩余完成数与输入的数比较大小
	 * @return
	 */
	@RequestMapping("selectPodsSurplus")
	public int selectPodsSurplus(Integer dplanId,Integer proId) {
		List<AddPlan> list=dayPalnService.selectPodsSurplus(dplanId);
		for(AddPlan a: list) {
			if(a.getProId()==proId) {
				return a.getPodsSurplus();
			}
		}
		return -1;
	}
	
	/**
	 * 	功能描述:修改日计划详情表的预留生产数量,
	 * @param dpdId
	 * @param proId
	 * @param podsQuantity
	 * @return
	 */
	@RequestMapping("updatePodsQuantity")
	public void updatePodsQuantity(Integer dpdId,Integer proId,Integer podsQuantity) {
		addPlan.setDpdId(dpdId);
		addPlan.setProId(proId);
		addPlan.setPodsQuantity(podsQuantity);
		addPlan.setNumber(podsQuantity);
		//修改日计划详情的预留生产数量
		dayPalnService.updatePodsQuantity(addPlan);
		//查询生产订单详细是否存在该成品
		List<AddPlan> list =dayPalnService.selectPoDetails();
		if(list.size()<1) {
			//新增一条生产订单详情(生产订单id外键为1)
			dayPalnService.addProductionOrderDetails(addPlan);
		}else {
			boolean found = false;
			for(AddPlan a:list) {
				System.err.println(a.getProId());
				System.err.println("proId="+proId);
				if(a.getProId()==proId) {
					addPlan.setPodId(a.getPodId());
					found=true;
					break;
				}
			}
			if(found) {
				//修改存在的成品的数量
				dayPalnService.updatePoPodsQuantity(addPlan);
			}else {
				dayPalnService.addProductionOrderDetails(addPlan);
			}
		}
	}
	
	/**
	 * 	功能描述:添加生产订单
	 * @param dPlan
	 * @param dplanId
	 */
	@RequestMapping("addProductionOrder")
	public void addProductionOrder(ProductionOrder productionOrder,Integer dplanId) {
		//查询日计划详情的剩余完成数
		List<AddPlan> list=dayPalnService.selectPodsSurplus(dplanId);
		for(AddPlan a:list) {
			if(a.getPodsQuantity()!=0) {
				//修改日计划详情的剩余生产数
				addPlan.setDpdId(a.getDpdId());
				addPlan.setNumber(a.getPodsSurplus()-a.getPodsQuantity());
				dayPalnService.updatePodsSurplus(addPlan);
			}
			
		}
		productionOrder.setDplanId(dplanId);
		//查询日计划所有成品生产总量 
		AddPlan addPlan =dayPalnService.selectQuantity(dplanId);
		productionOrder.setPoQuantity(addPlan.getNumber());
		//添加生产订单
		ProductionOrder poId= dayPalnService.addProductionOrder(productionOrder);
		//修改生产订单详情的生产点单id(外键)
		dayPalnService.updatePoId(poId.getPoId());
		//日计划表预留的生产数量字段清零
		dayPalnService.updateResetPodsQuantity();
		System.err.println(poId.getPoId());
	}
	
	/**
	 * 	功能描述:制定生产订单取消
	 * @return
	 */
	@RequestMapping("deleteCancelPo")
	public boolean deleteCancelPo() {
		//删除新增的生产订单详情(生产订单id为1的)
		dayPalnService.deleteCancelPo();
		//日计划表预留的生产数量字段清零
		dayPalnService.updateResetPodsQuantity();
		return true;
	}
}

