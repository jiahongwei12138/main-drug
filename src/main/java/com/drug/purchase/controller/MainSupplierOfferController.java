package com.drug.purchase.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.purchase.biz.MainSupplierOfferBiz;
import com.drug.entity.MainSupplierOffer;

@Controller
public class MainSupplierOfferController {
	@Autowired
	private MainSupplierOfferBiz mainSupplierOfferBiz;
	
	@RequestMapping("/setSupplierSession.do")
	@ResponseBody
	public HttpSession setSupplierSession(HttpSession session,Integer supplierId) {
		List<MainSupplierOffer> list = mainSupplierOfferBiz.getSupplierOfferInfo(supplierId);
		session.setAttribute("supOffer", list);
		return session;
	}
	
	@RequestMapping("/getSupplierOfferAllInfo.do")
	@ResponseBody
	public Map<String, Object> getSupplierOfferAllInfo(HttpSession session,Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = mainSupplierOfferBiz.selectSupplierOfferCount();
		List<MainSupplierOffer> list = (List<MainSupplierOffer>) session.getAttribute("supOffer");
		map.put("code", 0); 
		map.put("count", count); 
		map.put("data", list);
		return map;
	}

	@RequestMapping("addSupplierOfferInfo.do")
	@ResponseBody
	public Integer addSupplierOfferInfo(MainSupplierOffer mainSupplierOffer) {
		System.out.println(mainSupplierOffer.getOfferName());
		System.out.println(mainSupplierOffer.getOfferPlaceOfOrigin());
		System.out.println(mainSupplierOffer.getOfferPrice());
		System.out.println(mainSupplierOffer.getOfferRemark());
		System.out.println(mainSupplierOffer.getSupplierId());
		int row = mainSupplierOfferBiz.addSupplierOfferInfo(mainSupplierOffer);
		return row;
	}
	
	@RequestMapping("updateSupplierOffer.do")
	@ResponseBody
	public Integer updateSupplierOffer(MainSupplierOffer mainSupplierOffer) {
		int row = mainSupplierOfferBiz.updateSupplierOffer(mainSupplierOffer);
		return row;
	}
	
	@RequestMapping("deleteSupplierOffer.do")
	@ResponseBody
	public Integer deleteSupplierOffer(MainSupplierOffer mainSupplierOffer) {
		int row = mainSupplierOfferBiz.deleteSupplierOffer(mainSupplierOffer);
		return row;
	}
	
}
