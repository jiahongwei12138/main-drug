package com.drug.purchase.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.entity.MainSupplierOffer;

@Repository
public interface MainSupplierOfferMapper {
	
	public List<MainSupplierOffer> getSupplierOfferInfo(Integer supplierId);
	
	public Integer selectSupplierOfferCount();
	
	public Integer addSupplierOfferInfo(MainSupplierOffer mainSupplierOffer);
	
	public Integer updateSupplierOffer(MainSupplierOffer mainSupplierOffer);
	
	public Integer deleteSupplierOffer(MainSupplierOffer mainSupplierOffer);
}
