package com.drug.infoManagement.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.BranchPurchaseOrderDetails;
import com.drug.entity.BranchPurchaseReturnDetails;
import com.drug.entity.MainBranchbacksale;
import com.drug.entity.MainProduct;
import com.drug.entity.MainSaleOrder;
import com.drug.infoManagement.mapper.BranchClientMapper;
import com.drug.infoManagement.service.BranchClientService;
/**
 * 类描述：分店销售退货接口
 * @author jhw
 * @dateTime 2019年11月1日下午1:42:06
 * @version 1.0
 */
@Service
public class BranchClientServiceImpl implements BranchClientService{

	@Autowired
	private BranchClientMapper branchClientMapper;
	/**
	 * 方法功能：查询药品
	 * @return Object 药品集合
	 */
	@Override
	public List<MainProduct> getProduct() {
		return branchClientMapper.getProduct();
	}
	/**
	 * 方法功能：新增销售订单和销售详情单
	 * @param bsfId 分店id
	 * @param branchPurchaseOrderDetails 分店采购订单集合
	 */
	@Override
	public void addSaleOrder(Integer bsfId, List<BranchPurchaseOrderDetails> branchPurchaseOrderDetails) {
		if (branchPurchaseOrderDetails!=null &&branchPurchaseOrderDetails.size()>0) {
			//付款金额
			double payrMoney=0;
			//采购订单id
			String bpoId=null;
			for (BranchPurchaseOrderDetails b : branchPurchaseOrderDetails) {
				//累加付款总金额
				payrMoney+=b.getBpodSubtotal();
				//获取采购订单id
				bpoId=b.getBpoId();
			}
			//订单编号
			String orderNum = UUID.randomUUID().toString();
			//下单时间
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String payTime = format.format(date);
			//创建销售订单对象
			MainSaleOrder saleOrder=new MainSaleOrder();
			saleOrder.setBsfId(bsfId);
			saleOrder.setPayrMoney(payrMoney);
			saleOrder.setOrderNum(orderNum);
			saleOrder.setPayTime(payTime);
			saleOrder.setBpoId(bpoId);
			//1.生成销售订单
			branchClientMapper.addSaleOrder(saleOrder);
			
			//2.生成销售订单详情
			//获取销售订单生成后的主键id
			int orderId=saleOrder.getOrderId();
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("orderId", orderId);
			map.put("purchaseList", branchPurchaseOrderDetails);
			branchClientMapper.addSaleOrderDetail(map);
		}
		
	}
	/**
	 * 方法功能：新增退货订单和退货详情单
	 * @param bsfId 分店id
	 * @param branchPurchaseReturnDetails 分店采购退货单集合
	 */
	@Override
	public void addBackSale(Integer bsfId, List<BranchPurchaseReturnDetails> branchPurchaseReturnDetails) {
		if (branchPurchaseReturnDetails!=null && branchPurchaseReturnDetails.size()>0) {
			//退款金额
			double backMoney=0;
			//采购退货订单id
			Integer bprId=0;
			for (BranchPurchaseReturnDetails b : branchPurchaseReturnDetails) {
				//累加退款总金额
				backMoney+=b.getBprdSubtotal();
				//获取采购退货单id
				bprId=b.getBprId();
			}
			//退货订单编号
			String backOrderNum = UUID.randomUUID().toString();
			//退单时间
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String backTime = format.format(date);
			//创建退货订单对象
			MainBranchbacksale branchbacksale=new MainBranchbacksale();
			branchbacksale.setBackMoney(backMoney);
			branchbacksale.setBprId(bprId);
			branchbacksale.setBackTime(backTime);
			branchbacksale.setBackOrderNum(backOrderNum);
			branchbacksale.setBsfId(bsfId);
			branchbacksale.setBackReason("吃死人了");
			
			//1.生成销退货订单
			branchClientMapper.addBackSale(branchbacksale);
			
			//2.生成退货订单详情
			//获取销售订单生成后的主键id
			int backSaleId=branchbacksale.getBackSaleId();
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("backSaleId", backSaleId);
			map.put("purchaseReturnList", branchPurchaseReturnDetails);
			branchClientMapper.addBackSaleDetail(map);
		}
		
	}

}
