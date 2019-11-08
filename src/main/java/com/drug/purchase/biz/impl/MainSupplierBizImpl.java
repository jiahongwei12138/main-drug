package com.drug.purchase.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.purchase.biz.MainSupplierBiz;
import com.drug.entity.MainSupplier;
import com.drug.purchase.mapper.MainSupplierMapper;
@Service
public class MainSupplierBizImpl implements MainSupplierBiz{
	@Autowired
	private MainSupplierMapper mainSupplierMapper;

	@Override
	public List<MainSupplier> getSupplierAllInfo(int page, int limit) {
		int pages=(page-1)*limit;
		return mainSupplierMapper.getSupplierAllInfo(pages, limit);
	}
	
	@Override
	public int selectCount() {
		return mainSupplierMapper.selectCount();
	}

	@Override
	public int addSupplierNewInfo(MainSupplier mainSupplier) {
		return mainSupplierMapper.addSupplierNewInfo(mainSupplier);
	}

	@Override
	public int deleteSupplier(Integer supplierId) {
		return mainSupplierMapper.deleteSupplier(supplierId);
	}

	@Override
	public int updateSupplierInfo(MainSupplier mainSupplier) {
		return mainSupplierMapper.updateSupplierInfo(mainSupplier);
	}

	
	
}
