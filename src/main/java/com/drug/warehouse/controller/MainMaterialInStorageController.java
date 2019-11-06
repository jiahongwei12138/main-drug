package com.drug.warehouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.MainPurchaseDetails;
import com.drug.entity.MainPurchasePlan;
import com.drug.util.ToolClass;
import com.drug.warehouse.service.MainMaterialInStorageService;

/**
 * 控制层(原料入库)
 * @author Administrator
 *
 */
@Controller
public class MainMaterialInStorageController {

	@Autowired
	public MainMaterialInStorageService inStorageService;
	
	/**
	 * 根据入库状态,财务审核,质检状态查询数据
	 * @return
	 */
	@RequestMapping("/AllMainPurchasePlan")
	@ResponseBody
	public Map<String, Object> AllMainPurchasePlan(String inStoregState){
		if(inStoregState == null || "".equals(inStoregState)) {
			inStoregState = "未入库";
		};
		String checkState = "已审核";
		String rawMaterialTheQualityStatus = "已质检";
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("inStoregState",inStoregState);
		map1.put("checkState",checkState);
		map1.put("rawMaterialTheQualityStatus", rawMaterialTheQualityStatus);
		List<MainPurchasePlan> list = inStorageService.AllMainPurchasePlan(map1);
		int count = inStorageService.countMainPurchasePlan(map1);
		Map<String, Object> map = ToolClass.responseByData(list,count);
		return map;
	}
	
	/**
	 * 根据采购订单id删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/delMainPurchasePlan")
	@ResponseBody
	public int delMainPurchasePlan(int id) {
		int success = inStorageService.delMainPurchasePlan(id);
		return success;
	}
	
	/**
	 * 根据采购订单id查看详情
	 * @param planId
	 * @return
	 */
	@RequestMapping("/getMainPurchaseDetails")
	@ResponseBody
	public Map<String, Object> getMainPurchaseDetails(int planId) {
		List<MainPurchaseDetails> list = inStorageService.getMainPurchaseDetails(planId);
		int count = inStorageService.countMainPurchaseDetails(planId);
		Map<String, Object> map = ToolClass.responseByData(list,count);
		return map;
	}
	
	/**
	 * 根据质检状态搜索数据
	 * @param detailsqualitystatus
	 * @return
	 */
	@RequestMapping("/getDetailsqualitystatus")
	@ResponseBody
	public Map<String, Object> getDetailsqualitystatus(int planId, String detailsqualitystatus){
		List<MainPurchaseDetails> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("detailsqualitystatus", detailsqualitystatus);
		map1.put("planId", planId);
		if(detailsqualitystatus == null || "".equals(detailsqualitystatus)) {
			list = inStorageService.getMainPurchaseDetails(planId);
		}else {
			list = inStorageService.getDetailsqualitystatus(map1);
		}
		int count = inStorageService.countDetailsqualitystatus(map1);
		Map<String, Object> map = ToolClass.responseByData(list,count);
		return map;
	} 
	
	/**
	 * 根据原料名称查询数据
	 * @param detailsName
	 * @return
	 */
	@RequestMapping("/getDetailsName")
	@ResponseBody
	public  Map<String, Object> getDetailsName(String detailsName){
		List<MainPurchaseDetails> list = inStorageService.getDetailsName(detailsName);
		Map<String, Object> map = ToolClass.responseByData(list,1);
		return map;
	}
	
}
