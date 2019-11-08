package com.drug.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.MaterialOrder;
import com.drug.production.mapper.MaterialOrderMapper;
import com.drug.production.service.MaterialOrderService;

@Service
public class MaterialOrderServiceImpl implements MaterialOrderService{

	@Autowired
	private MaterialOrderMapper MaterialOrderMapper;

	@Override
	public List<MaterialOrder> selectMaterialOrderView() {
		List<MaterialOrder> list=MaterialOrderMapper.selectMaterialOrderView();
		return list;
	}

	@Override
	public List<MaterialOrder> selectMorDetails(Integer moId) {
		List<MaterialOrder> list=MaterialOrderMapper.selectMorDetails(moId);
		return list;
	}

	@Override
	public void deleteMaterialOrder(Integer moId) {
		MaterialOrderMapper.deleteMaterialOrder(moId);
	}

	@Override
	public void updateMaterialOrderStatus(MaterialOrder materialOrder) {
		MaterialOrderMapper.updateMaterialOrderStatus(materialOrder);
	}

	@Override
	public void updateMoSignfor(Integer moId) {
		MaterialOrderMapper.updateMoSignfor(moId);
	}

	@Override
	public void updatePickingPoMaterialState(Integer poId) {
		MaterialOrderMapper.updatePickingPoMaterialState(poId);
	}
}
