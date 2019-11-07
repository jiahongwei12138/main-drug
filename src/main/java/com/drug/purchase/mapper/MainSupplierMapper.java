package com.drug.purchase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.drug.entity.MainSupplier;
@Repository
public interface MainSupplierMapper {
	
	public List<MainSupplier> getSupplierAllInfo(@Param("page") int page,@Param("limit") int limit);
	
	public int selectCount();
	
	public int addSupplierNewInfo(MainSupplier mainSupplier);
	
	public int deleteSupplier(Integer supplierId);

	public int updateSupplierInfo(MainSupplier mainSupplier);
}
