package com.drug.purchase.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.purchase.biz.MainSupplierOfferBiz;
import com.drug.entity.MainSupplierOffer;
import com.drug.purchase.mapper.MainSupplierOfferMapper;
@Service
public class MainSupplierOfferBizImpl implements MainSupplierOfferBiz{
	@Autowired
	private MainSupplierOfferMapper mainSupplierOfferMapper;
	

	@Override
	public Integer selectSupplierOfferCount() {
		return mainSupplierOfferMapper.selectSupplierOfferCount();
	}

	@Override
	public List<MainSupplierOffer> getSupplierOfferInfo(Integer supplierId) {
		return mainSupplierOfferMapper.getSupplierOfferInfo(supplierId);
	}

	@Override
	public Integer addSupplierOfferInfo(MainSupplierOffer mainSupplierOffer) {
		return mainSupplierOfferMapper.addSupplierOfferInfo(mainSupplierOffer);
	}

	@Override
	public Integer updateSupplierOffer(MainSupplierOffer mainSupplierOffer) {
		return mainSupplierOfferMapper.updateSupplierOffer(mainSupplierOffer);
	}

	@Override
	public Integer deleteSupplierOffer(MainSupplierOffer mainSupplierOffer) {
		return mainSupplierOfferMapper.deleteSupplierOffer(mainSupplierOffer);
	}


}
