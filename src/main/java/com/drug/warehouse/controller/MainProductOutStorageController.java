package com.drug.warehouse.controller;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.MainProductOutStorage;
import com.drug.entity.MainSaleOrderdetail;
import com.drug.util.ToolClass;
import com.drug.warehouse.service.MainProductOutStorageService;
import com.drug.warehouse.service.MainProductStorageService;

/**
 * 分页条件（入库状态，入库类型）查询成品表信息
 * 
 * 审核
 * 
 * 查看详情
 * 
 * @author bobo
 *
 */
@RestController
public class MainProductOutStorageController {
	@Autowired
	private MainProductOutStorageService mainProductOutStorageService;
	@Autowired
	private MainProductStorageService  mainProductStorageService;
	/**
	 * 条件 分页查询成品入库信息
	 * 
	 * @param OutStoreType
	 * @param OutStoreState
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("getMainProductOutStorageInf.do")
	public Map<String, Object> getMainProductOutStorageInf(int OutStoreType, int OutStoreState, int page, int limit) {
		System.err.println(OutStoreType + " == " + OutStoreState + " == " + page + " == " + limit);
		String OutStoreStates = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("OutStoreType", OutStoreType);
		map.put("page", (page - 1) * limit);
		map.put("limit", limit);
		List<MainProductOutStorage> list = null;
		int count = 0;
		if (OutStoreType == 1) {// 如果是销售出库
			// 查询成品出库表
			if(OutStoreState == 1) {
				OutStoreStates = "已出库";
				map.put("posState", OutStoreStates);
				System.err.println(map.get("posState") + " == " + map.get("OutStoreType") );
				list = mainProductOutStorageService.getOutStorageInfReady(map);
				count = mainProductOutStorageService.getCountOSIR(map);
			}else {
				OutStoreStates = "未出库";
				map.put("posState", OutStoreStates);
				System.err.println(map.get("posState") + " == " + map.get("OutStoreType") );
				list = mainProductOutStorageService.getOutStorageInf(map);
				count = mainProductOutStorageService.getCountOSI(map);
			}
			for (MainProductOutStorage s : list) {
				s.setPoSTypeName("销售出库");
			}
		} else {

		}

		Map<String, Object> rMap = ToolClass.responseByData(list, count);
		return rMap;
	}

	/**
	 * 查看详情 获取两个参数 入库类型
	 * 
	 * @param orderId 入库类型
	 * @return
	 */

	@RequestMapping("getMainSaleorderdetail") 
	public Map<String, Object> getProductionOrderDetailsInf(int orderId){ 
	List<MainSaleOrderdetail> list = mainProductOutStorageService.getMainSaleOrderdetailInf(orderId);
		Map<String, Object> rMap = ToolClass.responseByData(list, list.size());
		return rMap;
	}

	/**
	 * 传入 仓库Id  销售订单Id 出库表Id
	 * 拿到详情信息 
		在出库仓库中根据销售商品Id修改成品仓库数量
		修改出库表  出库时间  出库状态  审核状态  审核人姓名
			
	 * @param posId  出库表Id
	 * @param orderId  销售订单Id
	 * @param whID  仓库Id
	 * @return
	 */
	@RequestMapping("OutProStorageCheck")
	public Map<String, Object> OutProStorageCheck(int posId, int orderId, int whID,HttpServletRequest request) {
		//根据销售订单拿到详情信息 
		List<MainSaleOrderdetail> list = mainProductOutStorageService.getMainSaleOrderdetailInf(orderId);
		 Map<String, Object> map = new HashMap<>();
		//根据销售商品数量修改成品仓库数量
		for(MainSaleOrderdetail s : list) {
			System.err.println(s);
			map.put("proNum", s.getProNum());
			map.put("whID",	 whID);
			map.put("proId", s.getProId());
			mainProductStorageService.updMainProstoreProNum(map);
		}
		//根据出库Id修改出库表  出库时间  出库状态  审核状态  审核人姓名
		//获取登录的session用户信息   得到用户Id
		request.getSession().getAttribute("");
		int empId = 1;
		//根据员工Id 出库表ID 修改状态
		 Map<String, Object> map1 = new HashMap<>();
		 map1.put("posId", posId);
		 map1.put("empId", empId);
		mainProductOutStorageService.updOutStoreInf(map1);
		//修改销售表出库状态
		mainProductOutStorageService.updMainSaleorderOutStoreState(orderId);
		Map<String, Object> rMap = ToolClass.responseByData(list, list.size());
		return rMap;
	}
}
