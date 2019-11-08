package com.drug.production.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.entity.PqDetails;
import com.drug.entity.ProQuality;
import com.drug.production.service.ProQualityMapperService;
import com.drug.util.ToolClass;

@RestController
public class ProQualityMapperController {
	
	@Autowired
	private ProQualityMapperService proQualityMapperService;
	
	/**
	 * 功能描述:查询成品管理界面
	 * @return
	 */
	@RequestMapping("selectProductionQualityView")
	public Map<String,Object> selectProductionQualityView() {
		List<ProQuality> list=proQualityMapperService.selectProductionQualityView();
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
	
	/**
	 * 功能描述:成品质检
	 * @param proQuality
	 * @param pqId
	 */
	@RequestMapping("updateProductionQuality")
	public void updateProductionQuality(ProQuality proQuality,Integer pqId) {
		System.err.println(proQuality.getQualitystatus());
		proQuality.setPqId(pqId);
		proQualityMapperService.updateProductionQuality(proQuality);
	}
	
	/**
	 * 功能描述:成品质检删除
	 * @param pqId
	 */
	@RequestMapping("deleteProductionQuality")
	public void deleteProductionQuality(Integer pqId) {
		proQualityMapperService.deleteProductionQuality(pqId);
	}
	
	/**
	 * 功能描述:查询成品质检详情
	 * @param pqId
	 */
	@RequestMapping("selectProqualitydetails")
	public Map<String,Object> selectProqualitydetails(Integer pqId) {
		List<PqDetails> list=proQualityMapperService.selectProqualitydetails(pqId);
		Map<String,Object> tableData=ToolClass.responseByData(list,list.size());
		return tableData;
	}
}
