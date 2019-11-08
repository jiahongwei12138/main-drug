package com.drug.warehouse.controller;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.MainEmployee;
import com.drug.entity.MainProductInStorage;
import com.drug.entity.MainProductStorage;
import com.drug.entity.ProductionOrderDetails;
import com.drug.util.ToolClass;
import com.drug.warehouse.service.MainProductInStorageService;
/**
 * 分页条件（入库状态，入库类型）查询成品表信息
 * 
 * 审核
 * 
 * 查看详情
 * @author bobo
 *
 */
@RestController
public class MainProductInStorageController {
	@Autowired
	private MainProductInStorageService mainProductInStorageService;
	/**
	 * 条件 分页查询成品入库信息
	 * @param piSState
	 * @param piSType
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("getMainProductInStorageInf.do")
	public Map<String, Object> getMainProductInStorageInf(int piSState,int piSType,int page ,int limit){
		System.err.println(piSState+" == "+piSType+" == "+page+" == "+limit);
		String piSStates = "";
		if(piSState==1) {
			piSStates = "已入库";
		}else {
			piSStates = "未入库";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("piSState", piSStates);
		map.put("piSType", piSType);
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<MainProductInStorage>  list = null;
		int count = 0;
		if(piSState==1) {
			list = mainProductInStorageService.getInStorageInf(map);
			count =mainProductInStorageService.getCountISI(map);
		 }else{
			 list =  mainProductInStorageService.getNotChecked();
			 for(MainProductInStorage m : list) {
				 if( m.getWhID()==1) {
						m.setSname("成品1仓");
				 }
			 }
			 count = list.size();
		 }
		
		
		 for(MainProductInStorage s : list ) {
			 if(s.getPiSType()==1) {
				 s.setPiSTypeName("生产质检入库");
			 }else {
				 s.setPiSTypeName("退货质检入库");
			 }
		 }
		
		Map<String, Object> rMap = ToolClass.responseByData(list, count);
		return rMap;
	}
	
	/**
	 * 查看详情
	 * 获取两个参数  入库类型    
	 * @param piSTypeName  入库类型   
	 * @param poOBoId 生产成品质检主键
	 * @return
	 */
	@RequestMapping("getProductionOrderDetailsInf")
	public Map<String, Object> getProductionOrderDetailsInf(int piSTypeName,int poOBoId){
		System.err.println(piSTypeName);
		List<ProductionOrderDetails> list = null;
		//判断入库类型
		String piSTypeNames = "";
		if(piSTypeName==1) {
			piSTypeNames = "生产质检入库";
		}
		if(piSTypeNames.equals("生产质检入库")) {
			//通过ID查看详情
			list = mainProductInStorageService.getProductionOrderDetailsInf(poOBoId);
		}else {//退货质检入库
			
		}
		Map<String, Object> rMap = ToolClass.responseByData(list, 0);
		return rMap;
	}
	
	
	/**
	 * 审核方法
	 * 获取页面传入的 入库类型，订单ID，
	 * 根据入库类型 订单Id 查询到已审核的详情信息
	 * 并从中取出通过数量 成品Id
	 * 进行成品仓库的添加
	 * 修改入库信息
	 * 修改生产成品管理(质检)入库状态
	 * @return
	 * @param piSType 入库类型
	 * @param poOBoId 订单Id
	 */
	@RequestMapping("InProStorageCheck")
	public int InProStorageCheck(int piSType,int poOBoId,int whID,int piSId,HttpSession session) {
		String piSTypeName = "";
		if(piSType==1) {
			piSTypeName = "生产质检入库";
		}else {
			piSTypeName = "退货质检入库";
		}
		List<ProductionOrderDetails> list = null;
		if(piSTypeName.equals("生产质检入库")) {
			//根据入库类型 订单Id 查询到已审核的详情信息
			list = mainProductInStorageService.getProductionOrderDetailsInf(poOBoId);
			//进行成品仓库的添加
			for(ProductionOrderDetails pd :list) {
				mainProductInStorageService.updProStorageInf(new MainProductStorage(pd.getProId(),pd.getProPassQuantity(),whID));
			}
			//添加成功后修改入库表中入库状态，审核状态，入库时间，审核人姓名
			
			//从session中获取用户Id  暂时没有   默认1
			MainEmployee employee=(MainEmployee) session.getAttribute("employee");
			int empId = employee.getEmpId();
			Map<String,Object> map = new HashMap<>();
			map.put("checkStaffId",empId);
			map.put("piSId", piSId);
			
			mainProductInStorageService.updProInStoInf(map);
			
			//修改生产成品管理(质检)入库状态
			mainProductInStorageService.updInfInProductionQuality(poOBoId);
		}else {//退货质检入库
			
		}
		return 1;
	}
	
}
