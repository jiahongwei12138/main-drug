package com.drug.purchase.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.drug.entity.MainSupplier;

public interface MainSupplierBiz {
	
	public List<MainSupplier> getSupplierAllInfo(@Param("page") int page,@Param("limit") int limit);
	
	public int selectCount();
	
	public int addSupplierNewInfo(MainSupplier mainSupplier);
	
	public int deleteSupplier(Integer supplierId);
	
	public int updateSupplierInfo(MainSupplier mainSupplier);
}
