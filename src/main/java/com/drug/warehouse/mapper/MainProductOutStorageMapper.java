package com.drug.warehouse.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.drug.entity.MainProductInStorage;
import com.drug.entity.MainProductOutStorage;
import com.drug.entity.MainProductStorage;
import com.drug.entity.MainProductionQuality;
import com.drug.entity.MainSaleOrderdetail;
import com.drug.entity.ProductionOrderDetails;

public interface MainProductOutStorageMapper {
	/**
	 * 条件查询入库信息   分页
	 * @param map
	 * @return
	 */
	public List<MainProductOutStorage> getOutStorageInf(Map<String,Object> map);
	/**
	 * 分页总行数
	 * @param map
	 * @return
	 */
	public int getCountOSI(Map<String,Object> map);
	
	
	@Select("select * from main_saleorderdetail s join main_product p  on s.proId = p.proId where orderId = #{orderId}")
	List<MainSaleOrderdetail> getMainSaleOrderdetailInf(int orderId);
	
	
	@Update("update main_productOutStorage set posTime=now(), posState = '已出库' , checkStates='已审核',checkStaffId = #{empId} where posId = #{posId}")
	int updOutStoreInf(Map<String,Object> map);
	
	@Update("update main_saleorder set outStoreState = '已出库'  where orderId = #{orderId}")
	int updMainSaleorderOutStoreState(int orderId);
	
	public List<MainProductOutStorage> getOutStorageInfReady(Map<String,Object> map);
	
	public int getCountOSIR(Map<String,Object> map);
	/**
	 *   传入销售订单Id
	 *   成品出库添加一条信息
	 * @param orderId
	 * @return
	 */
	@Insert("insert into main_productOutStorage (whID,orderId) values(1,#{orderId})")
	int saleOrderInfInOutStore(int orderId);
}
