package com.drug.production.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.AddPlan;
import com.drug.entity.MaterialOrder;
import com.drug.entity.MaterialOrderDetails;
import com.drug.entity.ProductionOrder;
import com.drug.production.service.ProductionOrderService;
import com.drug.util.ToolClass;

@RestController
@Controller
public class ProductionOrderController {

	@Autowired
	private ProductionOrderService productionOrderService;
	
	@Autowired
	private MaterialOrderDetails materialOrderDetails;
	
	@Autowired
	private AddPlan addPlan;
	
	/**
	 * 	功能描述:查询生产订单界面
	 * @return
	 */
	@RequestMapping("selectProductionOrderView")
	public Map<String,Object> selectProductionOrderView() {
		List <ProductionOrder> list=productionOrderService.selectProductionOrderView();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 	功能描述:查询生产订单详情
	 * @return
	 */
	@RequestMapping("selectproductionOrderDetails")
	public Map<String,Object> selectproductionOrderDetails(Integer poId) {
		List<AddPlan> list=productionOrderService.selectproductionOrderDetails(poId);
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 	功能描述:删除生产订单
	 * @param poId
	 */
	@RequestMapping("deleteProductionOrder")
	public void deleteProductionOrder(Integer poId) {
		productionOrderService.deleteProductionOrder(poId);
	}
	
	/**
	 * 	功能描述:审核生产订单
	 * @param poId
	 */
	@RequestMapping("updatePoStatus")
	public void updatePoStatus(ProductionOrder productionOrder,Integer poId) {
		productionOrder.setPoId(poId);
		System.err.println(productionOrder.getPoId());
		System.err.println(productionOrder.getPoProposerName());
		productionOrderService.updatePoStatus(productionOrder);
	}
	
	/**
	 * 功能描述:申请领料
	 * @param poId
	 */
	@RequestMapping("addMaterialOrder")
	public void addMaterialOrder(MaterialOrder materialOrder,Integer poId) {
		materialOrder.setPoId(poId);
		//新增领料表
		int moId=productionOrderService.addMaterialOrder(materialOrder);
		//查询成品所需要的配方原料数据
		List<MaterialOrderDetails> list=productionOrderService.selectRecipeRaw(poId);
		materialOrderDetails.setMoId(moId);
		for(MaterialOrderDetails m:list) {
			materialOrderDetails.setRawMaterialId(m.getRawMaterialId());
			materialOrderDetails.setWeight(m.getWeight());
			//添加领料表详情数据  
			productionOrderService.addMaterialOrderDetails(materialOrderDetails);
		}
		//修改生产订单领料状态poMaterialState
		productionOrderService.updatePoMaterialState(poId);
	}
	
	/**
	 * 功能描述:开始生产
	 * @param poId
	 */
	@RequestMapping("updatePoState")
	public void updatePoState(Integer poId) {
		//修改生产订单的生产状态
		productionOrderService.updatePoState(poId);
	}
	
	/**
	 * 功能描述:结束生产查询界面
	 * @param poId
	 * @return
	 */
	@RequestMapping("selectOvrePo")
	public Map<String,Object> selectOvrePo(Integer poId) {
		List <AddPlan> list=productionOrderService.selectOvrePo(poId);
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:修改生产订单详情已完成数
	 * @param podId
	 * @param proId
	 * @param podsPracticalQuantity
	 */
	@RequestMapping("updateAccomplishNum")
	public void updateAccomplishNum(Integer podId,Integer proId,Integer podsPracticalQuantity) {
		addPlan.setPodId(podId);
		addPlan.setProId(proId);
		addPlan.setPodsPracticalQuantity(podsPracticalQuantity);
		productionOrderService.updateAccomplishNum(addPlan);
		//新增成品质检管理详情
		if(podsPracticalQuantity!=0) {
			//查询生产成品管理详情(质检)表中是否存在该成品
			List<AddPlan> list =productionOrderService.selectPqDetails();
			if(list.size()<1) {
				//新增一条生产订单详情(生产订单id外键为1)
				productionOrderService.addProductionQualityDetails(addPlan);
			}else {
				boolean found = false;
				for(AddPlan a:list) {
					System.err.println(a.getProId());
					System.err.println("proId="+proId);
					if(a.getProId()==proId) {
						addPlan.setPqdId(a.getPqdId());
						found=true;
						break;
					}
				}
				if(found) {
					//成品存在,修改生产成品管理详情的成品数量
					productionOrderService.updatePqDetails(addPlan);
				}else {
					productionOrderService.addProductionQualityDetails(addPlan);
				}
			}
			
		}
		
	}
	
	/**
	 * 功能描述:取消结束生产,回复数据
	 * @param poId
	 */
	@RequestMapping("deleteCancelOver")
	public void deleteCancelOver(Integer poId) {
		//删除新增成品质检管理详情
		productionOrderService.deleteCancelOver();
		//恢复修改的生产订单详情已完成数
		productionOrderService.updateCancelOver(poId);
	}
	
	/**
	 * 功能描述:确认结束生产订单
	 * @param materialOrder
	 * @param poId
	 */
	@RequestMapping("addProductionQuality")
	public void addProductionQuality(MaterialOrder materialOrder,Integer poId,Integer dplanId) {
		materialOrder.setPoId(poId);
		//新增生产成品管理(质检)
		productionOrderService.addProductionQuality(materialOrder);
		int pqId=materialOrder.getPqId();
		//修改成品质检管理详情的外键id
		productionOrderService.updatePqPqId(pqId);
		//查询所有生产订单详情实际完成量
		AddPlan addPlan=productionOrderService.selectPoPracticalQuantity(poId);
		addPlan.setPoId(poId);
		//修改生产订单实际完成量
		productionOrderService.updatePoPracticalQuantity(addPlan);
		//修改月计划表实际完成数
		addPlan.setDplanId(dplanId);
		productionOrderService.updateMrealityNumber(addPlan);
		
		//连接查询剩余完成数
		List<AddPlan> list=productionOrderService.selectMplanDetailsRealityNumber(poId);
		for(AddPlan a :list) {
			int result=a.getPodsQuantity()-a.getPodsPracticalQuantity();
			if(result!=0) {
				System.err.println(result);
				System.err.println(a.getProId());
				this.addPlan.setProId(a.getProId());
				this.addPlan.setNumber(result);
				//修改月计划详情剩余完成数
				productionOrderService.updateMplanDetailsAddSurplus(this.addPlan);
				break;
			}
		}
		//修改结束生产状态
		productionOrderService.updateProductionOrder(poId);
		
	}
}
