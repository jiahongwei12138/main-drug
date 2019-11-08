package com.drug.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.AddPlan;
import com.drug.entity.DayProductionPlan;
import com.drug.entity.ProductionOrder;
import com.drug.production.mapper.DayPlanMapper;
import com.drug.production.service.DayPalnService;

@Service
public class DayPalnServiceImpl implements DayPalnService{

	@Autowired
	private DayPlanMapper dayPlanMapper;

	@Override
	public List<DayProductionPlan> selectDayPalnView() {
		List<DayProductionPlan> list=dayPlanMapper.selectDayPalnView();
		return list;
	}

	@Override
	public List<AddPlan> selectDplanDetails(Integer dplanId) {
		List<AddPlan> list=dayPlanMapper.selectDplanDetails(dplanId);
		return list;
	}

	@Override
	public void deleteDplan(Integer dplanId) {
		dayPlanMapper.deleteDplan(dplanId);
	}

	@Override
	public List<AddPlan> selectUpdateView(Integer dplanId) {
		List<AddPlan> list=dayPlanMapper.selectUpdateView(dplanId);
		return list;
	}

	@Override
	public AddPlan selectMplanNumber(Integer mplanId) {
		AddPlan addPlan=dayPlanMapper.selectMplanNumber(mplanId);
		return addPlan;
	}

	@Override
	public void updatedDplanDetailsNum(AddPlan addPlan) {
		dayPlanMapper.updatedDplanDetailsNum(addPlan);
	}

	@Override
	public void updateAffirmDplanDetails(AddPlan addPlan) {
		dayPlanMapper.updateAffirmDplanDetails(addPlan);
	}

	@Override
	public int updateDplanDetailsRes(Integer dplanId) {
		int row=dayPlanMapper.updateDplanDetailsRes(dplanId);
		return row;
	}

	@Override
	public void updateDplanAudit(DayProductionPlan dPlan) {
		dayPlanMapper.updateDplanAudit(dPlan);
	}

	@Override
	public List<AddPlan> selectAddpo(Integer dplanId) {
		List<AddPlan> list = dayPlanMapper.selectAddpo(dplanId);
		return list;
	}

	@Override
	public AddPlan selectDplanQuantity(AddPlan addPlan) {
		AddPlan addPlans=dayPlanMapper.selectDplanQuantity(addPlan);
		return addPlans;
	}

	@Override
	public void updatePodsQuantity(AddPlan addPlan) {
		dayPlanMapper.updatePodsQuantity(addPlan);
	}

	@Override
	public void addProductionOrderDetails(AddPlan addPlan) {
		dayPlanMapper.addProductionOrderDetails(addPlan);
	}

	@Override
	public List<AddPlan> selectPoDetails() {
		List<AddPlan> list=dayPlanMapper.selectPoDetails();
		return list;
	}

	@Override
	public void updatePoPodsQuantity(AddPlan addPlan) {
		dayPlanMapper.updatePoPodsQuantity(addPlan);
	}

	@Override
	public AddPlan selectQuantity(Integer dplanId) {
		AddPlan addPlan=dayPlanMapper.selectQuantity(dplanId);
		return addPlan;
	}

	@Override
	public ProductionOrder addProductionOrder(ProductionOrder productionOrder) {
		dayPlanMapper.addProductionOrder(productionOrder);
		int poId=productionOrder.getPoId();
		productionOrder.setPoId(poId);
		return productionOrder;
	}

	@Override
	public void updatePoId(Integer poId) {
		dayPlanMapper.updatePoId(poId);
	}

	@Override
	public void updateResetPodsQuantity() {
		dayPlanMapper.updateResetPodsQuantity();
	}

	@Override
	public void deleteCancelPo() {
		dayPlanMapper.deleteCancelPo();
	}

	@Override
	public void updateMdetailsSurplusD(AddPlan addPlan2) {
		dayPlanMapper.updateMdetailsSurplusD(addPlan2);
	}

	@Override
	public List<AddPlan> selectMplanDetailsProNum(Integer mplanId) {
		List<AddPlan> list=dayPlanMapper.selectMplanDetailsProNum(mplanId);
		return list;
	}

	@Override
	public List<AddPlan> selectPodsSurplus(Integer dplanId) {
		List<AddPlan> list=dayPlanMapper.selectPodsSurplus(dplanId);
		return list;
	}

	@Override
	public void updatePodsSurplus(AddPlan addPlan) {
		dayPlanMapper.updatePodsSurplus(addPlan);
	}

}
