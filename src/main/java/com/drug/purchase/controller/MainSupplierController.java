package com.drug.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.purchase.biz.MainSupplierBiz;
import com.drug.entity.MainSupplier;

@Controller
public class MainSupplierController {
	@Autowired
	private MainSupplierBiz mainSupplierBiz;
	
	/**
	 * 
	 * @Title: getSupplierAllInfo 
	 * @Description: 查询所有供应商 
	 * @param page
	 * @param limit
	 * @return    设定文件 
	 * Map<String,Object>    返回类型 
	 * @throws
	 */
	@RequestMapping("/getSupplierAllInfo.do")
	@ResponseBody
	public Map<String,Object> getSupplierAllInfo(Integer page,Integer limit){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = mainSupplierBiz.selectCount();
		List<MainSupplier> list = mainSupplierBiz.getSupplierAllInfo(page, limit);
		map.put("code", 0);
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 
	 * @Title: addSupplierNewInfo 
	 * @Description: 新增供应商
	 * @param mainSupplier
	 * @return    设定文件 
	 * String    返回类型 
	 * @throws
	 */
	@RequestMapping("addSupplierNewInfo.do")
	@ResponseBody
	public Integer addSupplierNewInfo(MainSupplier mainSupplier) {
		int row = mainSupplierBiz.addSupplierNewInfo(mainSupplier);
		return row;
	}
	
	@RequestMapping("deleteSupplier.do")
	@ResponseBody
	public void deleteSupplier(Integer supplierId) {
		mainSupplierBiz.deleteSupplier(supplierId);
	}
	
	@RequestMapping("updateSupplierInfo.do")
	@ResponseBody
	public Integer updateSupplierInfo(MainSupplier mainSupplier) {
		System.out.println(mainSupplier.getSupplierId());
		int row = mainSupplierBiz.updateSupplierInfo(mainSupplier);
		return row;
	}
	
}
