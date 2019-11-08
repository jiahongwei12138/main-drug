package com.drug.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.AddPlan;
import com.drug.entity.MaterialOrder;
import com.drug.entity.MaterialOrderDetails;
import com.drug.entity.ProductionOrder;
import com.drug.entity.ReturnOf;
import com.drug.production.mapper.ProductionOrderMapper;
import com.drug.production.service.ProductionOrderService;

@Service
public class ProductionOrderServiceImpl implements ProductionOrderService{
	
	@Autowired
	private ProductionOrderMapper productionOrderMapper;

	@Override
	public List<ProductionOrder> selectProductionOrderView() {
		List<ProductionOrder> list=productionOrderMapper.selectProductionOrderView();
		return list;
	}

	@Override
	public List<AddPlan> selectproductionOrderDetails(Integer poId) {
		List<AddPlan> list=productionOrderMapper.selectproductionOrderDetails(poId);
		return list;
	}

	@Override
	public void deleteProductionOrder(Integer poId) {
		productionOrderMapper.deleteProductionOrder(poId);
	}

	@Override
	public void updatePoStatus(ProductionOrder productionOrder) {
		productionOrderMapper.updatePoStatus(productionOrder);
	}

	@Override
	public int addMaterialOrder(MaterialOrder materialOrder) {
		productionOrderMapper.addMaterialOrder(materialOrder);
		int moId= materialOrder.getMoId();
		return moId;
	}

	@Override
	public List<MaterialOrderDetails> selectRecipeRaw(Integer poId) {
		List<MaterialOrderDetails> list=productionOrderMapper.selectRecipeRaw(poId);
		return list;
	}

	@Override
	public void addMaterialOrderDetails(MaterialOrderDetails moDetails) {
		productionOrderMapper.addMaterialOrderDetails(moDetails);
	}

	@Override
	public void updatePoMaterialState(Integer poId) {
		productionOrderMapper.updatePoMaterialState(poId);
	}

	@Override
	public void updatePoState(Integer poId) {
		productionOrderMapper.updatePoState(poId);
	}

	@Override
	public List<AddPlan> selectOvrePo(Integer poId) {
		List<AddPlan> list=productionOrderMapper.selectOvrePo(poId);
		return list;
	}

	@Override
	public void updateAccomplishNum(AddPlan addPlan) {
		productionOrderMapper.updateAccomplishNum(addPlan);
	}

	@Override
	public void addProductionQualityDetails(AddPlan addPlan) {
		productionOrderMapper.addProductionQualityDetails(addPlan);
	}

	@Override
	public void deleteCancelOver() {
		productionOrderMapper.deleteCancelOver();
	}

	@Override
	public void updateCancelOver(Integer poId) {
		productionOrderMapper.updateCancelOver(poId);
	}

	@Override
	public List<AddPlan> selectPqDetails() {
		List<AddPlan> list=productionOrderMapper.selectPqDetails();
		return list;
	}

	@Override
	public void updatePqDetails(AddPlan addPlan) {
		productionOrderMapper.updatePqDetails(addPlan);
	}

	@Override
	public void addProductionQuality(MaterialOrder materialOrder) {
		productionOrderMapper.addProductionQuality(materialOrder);
	}

	@Override
	public void updatePqPqId(int pqId) {
		productionOrderMapper.updatePqPqId(pqId);
	}

	@Override
	public AddPlan selectPoPracticalQuantity(Integer poId) {
		AddPlan addPlan =productionOrderMapper.selectPoPracticalQuantity(poId);
		return addPlan;
	}

	@Override
	public void updatePoPracticalQuantity(AddPlan addPlan) {
		productionOrderMapper.updatePoPracticalQuantity(addPlan);
	}

	@Override
	public void updateMrealityNumber(AddPlan addPlan) {
		productionOrderMapper.updateMrealityNumber(addPlan);
	}

	@Override
	public List<AddPlan> selectMplanDetailsRealityNumber(Integer poId) {
		List<AddPlan> list=productionOrderMapper.selectMplanDetailsRealityNumber(poId);
		return list;
		
	}

	@Override
	public void updateMplanDetailsAddSurplus(AddPlan addPlan) {
		productionOrderMapper.updateMplanDetailsAddSurplus(addPlan);
	}

	@Override
	public void updateProductionOrder(Integer poId) {
		productionOrderMapper.updateProductionOrder(poId);
	}

	@Override
	public void addreturnOf(ReturnOf returnOf) {
		productionOrderMapper.addreturnOf(returnOf);
	}
}
