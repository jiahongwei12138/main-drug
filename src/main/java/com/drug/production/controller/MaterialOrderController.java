package com.drug.production.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.MaterialOrder;
import com.drug.production.service.MaterialOrderService;
import com.drug.util.ToolClass;

@RestController
public class MaterialOrderController {
	
	@Autowired
	private MaterialOrderService materialOrderService;
	
	/**
	 * 功能描述:生产领料界面数据查询
	 * @return
	 */
	@RequestMapping("selectMaterialOrderView")
	public Map<String,Object> selectMaterialOrderView() {
		List<MaterialOrder> list= materialOrderService.selectMaterialOrderView();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:查询生产领料详情
	 * @param moId
	 * @return
	 */
	@RequestMapping("selectMorDetails")
	public Map<String,Object> selectMorDetails(Integer moId) {
		List<MaterialOrder> list=materialOrderService.selectMorDetails(moId);
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:删除领料表
	 * @param moId
	 */
	@RequestMapping("deleteMaterialOrder")
	public void deleteMaterialOrder(Integer moId) {
		materialOrderService.deleteMaterialOrder(moId);
	}
	
	/**
	 * 功能描述:审核领料表
	 * @param moId
	 */
	@RequestMapping("updateMaterialOrderStatus")
	public void updateMaterialOrderStatus(MaterialOrder materialOrder,Integer moId) {
		materialOrder.setMoId(moId);
		materialOrderService.updateMaterialOrderStatus(materialOrder);
	}
	
	/**
	 * 功能描述:签收原料
	 * @param moId
	 */
	@RequestMapping("updateMoSignfor")
	public void updateMoSignfor(Integer moId,Integer poId) {
		materialOrderService.updateMoSignfor(moId);
		//签收领料后修改生产订单的领料状态
		materialOrderService.updatePickingPoMaterialState(poId);
	}
}
