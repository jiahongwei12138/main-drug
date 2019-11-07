package com.drug.purchase.biz;

import java.util.List;

import com.drug.entity.MainSupplierOffer;

public interface MainSupplierOfferBiz {

	public List<MainSupplierOffer> getSupplierOfferInfo(Integer supplierId);

	public Integer selectSupplierOfferCount();
	
	public Integer addSupplierOfferInfo(MainSupplierOffer mainSupplierOffer);

	public Integer updateSupplierOffer(MainSupplierOffer mainSupplierOffer);
	
	public Integer deleteSupplierOffer(MainSupplierOffer mainSupplierOffer);
}
