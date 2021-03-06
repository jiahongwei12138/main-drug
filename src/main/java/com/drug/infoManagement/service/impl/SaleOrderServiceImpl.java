package com.drug.infoManagement.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainSaleOrder;
import com.drug.entity.MainSaleOrderdetail;
import com.drug.infoManagement.mapper.SaleOrderMapper;
import com.drug.infoManagement.service.SaleOrderService;
import com.drug.util.HttpClientUtil;
/**
 * 类描述：总店销售管理
 * @author jhw
 * @dateTime 2019年10月29日下午3:30:28
 * @version 1.0
 */
@Service
public class SaleOrderServiceImpl implements SaleOrderService {

	@Autowired
	private SaleOrderMapper saleOrderMapper;
	/**
	 * 方法功能：查询销售订单
	 * @return List<MainSaleOrderdetail> 销售订单集合
	 */
	@Override
	public List<MainSaleOrder> querySaleOrder(String payTime,String branchStoreName,String checkState) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("payTime", payTime);
		map.put("branchStoreName", branchStoreName);
		map.put("checkState", checkState);
		return saleOrderMapper.querySaleOrder(map);
	}
	/**
	 * 方法功能：查询销售订单详情
	 * @return List<MainSaleOrderdetail> 销售订单详情集合
	 */
	@Override
	public List<MainSaleOrderdetail> querySaleOrderDetail(Integer orderId) {
		return saleOrderMapper.querySaleOrderDetail(orderId);
	}
	/**
	 * 方法功能：删除订单
	 * @param orderId 订单id
	 */
	@Override
	public void deleteSaleOrder(Integer orderId) {
		saleOrderMapper.deleteSaleOrderDetailById(orderId);
		saleOrderMapper.deleteSaleOrder(orderId);
	}
	/**
	 * 方法功能：审核订单
	 * @param orderId 订单id
	 */
	@Override
	public void checkOrder(Integer orderId,String bpoId) {
		try {
			//修改订单审核状态
			saleOrderMapper.checkOrder(orderId);
			//回应分店采购订单申请
			Properties prop=new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("system.properties");
			prop.load(in);
			String url = prop.getProperty("branchStoreCheckStateUrl");
			HttpClientUtil.PostOneParam(url, bpoId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 方法功能：查询销售报表
	 * @return Map<String,Object> 
	 */
	@Override
	public Map<String, Object> querySaleReport() {
		Map<String, Object> map=new HashMap<String, Object>();
		List<String> monthList=saleOrderMapper.querySaleReportGroupByMonth();
		List<Integer> orderNumList=saleOrderMapper.querySaleReportOrderNumberByMonth();
		map.put("monthList", monthList);
		map.put("orderNumList", orderNumList);
		return map;
	}

}
