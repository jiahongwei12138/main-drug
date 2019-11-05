package com.drug.infoManagement.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MainBranchbacksale;
import com.drug.entity.MainBranchbacksaledetail;
import com.drug.infoManagement.mapper.BranchBackSaleMapper;
import com.drug.infoManagement.service.BranchBackSaleService;
import com.drug.util.HttpClientUtil;
/**
 * 类描述：分店退货订单
 * @author jhw
 * @dateTime 2019年10月30日上午9:47:06
 * @version 1.0
 */
@Service
public class BranchBackSaleServiceImpl implements BranchBackSaleService {

	@Autowired
	private BranchBackSaleMapper branchBackSaleMapper;
	/**
	 * 方法功能：查询退货单
	 * @param branchbacksale 退货单对象
	 * @return List<MainBranchbacksale> 退货单集合
	 */
	@Override
	public List<MainBranchbacksale> queryBranchBackSaleOrder(MainBranchbacksale branchbacksale) {
		return branchBackSaleMapper.queryBranchBackSaleOrder(branchbacksale);
	}
	/**
	 * 方法功能：审核退货单
	 * @param backSaleId 退货单id
	 */
	@Override
	public void checkbackOrder(Integer backSaleId,Integer bprId) {
		try {
			branchBackSaleMapper.checkbackOrder(backSaleId);
			//回应分店采购订单申请
			Properties prop=new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("system.properties");
			prop.load(in);
			String url = prop.getProperty("branchStoreBackCheckStateUrl");
			HttpClientUtil.PostOneParamInt(url, bprId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 方法功能：质检退货单
	 * @param backSaleId 退货单id
	 */
	@Override
	public void checkOrderInStoreCheckState(Integer backSaleId) {
		branchBackSaleMapper.checkOrderInStoreCheckState(backSaleId);
	}
	/**
	 * 方法功能：删除退货单
	 * @param backSaleId 退货单id
	 */
	@Override
	public void deleteBackSaleOrder(Integer backSaleId) {
		branchBackSaleMapper.deleteBackSaleOrderDetial(backSaleId);
		branchBackSaleMapper.deleteBackSaleOrder(backSaleId);
	}
	/**
	 * 方法功能：查询退货订单详情
	 * @param backSaleId 退货单id
	 * @return List<MainBranchbacksaledetail> 退货单详情集合
	 */
	@Override
	public List<MainBranchbacksaledetail> queryBackSaleOrderDetail(Integer backSaleId) {
		return branchBackSaleMapper.queryBackSaleOrderDetail(backSaleId);
	}

}
