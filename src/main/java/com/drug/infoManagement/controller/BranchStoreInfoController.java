package com.drug.infoManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.entity.BranchStorefactsheet;
import com.drug.infoManagement.service.BranchStoreInfoService;
import com.drug.util.ToolClass;
/**
 * 类描述：分店信息管理
 * @author jhw
 * @dateTime 2019年10月24日上午9:55:03
 * @version 1.0
 */
@Controller
public class BranchStoreInfoController {

	@Autowired
	private BranchStoreInfoService branchStoreInfoService;
	/**
	 *方法功能：添加分店
	 * @param branchStore 分店对象
	 * @param city 城市
	 * @param diqu 地区
	 * @return boolean 添加结果  true：添加成功   false：添加失败
	 */
	@RequestMapping("/addBranchStorefactsheet")
	@ResponseBody
	public boolean addBranchStorefactsheet(BranchStorefactsheet branchStore,String city,String diqu) {
		try {
			String adderss=diqu+city+branchStore.getBsfAddress();
			branchStore.setBsfAddress(adderss);
			branchStoreInfoService.addBranchStorefactsheet(branchStore);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 方法功能：查询分店信息
	 * @return Map<String,Object>
	 */
	@RequestMapping("/queryBranchStorefactsheet")
	@ResponseBody
	public Map<String, Object> queryBranchStorefactsheet(String pactState) {
		List<BranchStorefactsheet> branchStores=branchStoreInfoService.queryBranchStorefactsheet(pactState);
		Map<String, Object> map = ToolClass.responseByData(branchStores, branchStores.size());
		return map;
	}
	
}
