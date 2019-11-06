package com.drug.warehouse.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainPurchaseDetails;
import com.drug.entity.MainPurchasePlan;

/**
 * 持久层(原料入库)
 * @author Administrator
 *
 */
@Repository
public interface MainMaterialInStorageMapper {

	/**
	 * 根据入库状态,财务审核,质检状态查询数据
	 * @return
	 */
	public List<MainPurchasePlan> AllMainPurchasePlan(Map<String, String> map);
	
	/**
	 * 根据入库状态查询数据行数
	 * @param inStoregState
	 * @return
	 */
	public int countMainPurchasePlan(Map<String, String> map);
	
	/**
	 * 根据采购订单id删除数据
	 * @param id
	 * @return 
	 */
	public int delMainPurchasePlan(int id);
	
	/**
	 * 根据采购订单Id查询详情
	 * @param planId
	 * @return
	 */
	public List<MainPurchaseDetails> getMainPurchaseDetails(int planId);
	
	/**
	 * 根据采购订单id查询详情行数
	 * @param planId
	 * @return
	 */
	public int countMainPurchaseDetails(int planId);
	
	/**
	 * 根据采购订单详情质检状态与采购订单id查询数据
	 * @param detailsqualitystatus
	 * @return
	 */
	public List<MainPurchaseDetails> getDetailsqualitystatus(Map<String, Object> map);
	
	/**
	 * 根据采购订单详情质检状态与采购订单id查询数据行数
	 * @param detailsqualitystatus
	 * @return
	 */
	public int countDetailsqualitystatus(Map<String, Object> map);
	
	/**
	 * 根据原料名称查询数据
	 * @param detailsName
	 * @return
	 */
	public List<MainPurchaseDetails> getDetailsName(String detailsName);
	
}
