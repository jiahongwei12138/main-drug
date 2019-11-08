package com.drug.production.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.AddPlan;
import com.drug.entity.AddPlans;
import com.drug.entity.MProductionPlan;
import com.drug.entity.MainEmployee;
import com.drug.entity.MainProduct;
import com.drug.production.mapper.SelectProductMapper;
import com.drug.production.service.SelectProductService;

@Service
public class SelectProductServiceImpl implements SelectProductService{
	
	@Autowired
	private SelectProductMapper selectProductMapper;
	
	@Override
	public List<MainProduct> selectProduct() {
		List<MainProduct> list=selectProductMapper.selectProduct();
		return list;
	}

	@Override
	public int addMPlan(String Id, String proName, String num) throws IOException{
		int row=0;
		if(proName!=null) {
			proName=new String(proName.getBytes("ISO-8859-1"),"utf-8");
		}
		int proId=0;
		if(Id!=null&&!"".equals(Id)) {
			proId=Integer.parseInt(Id);
		}
		int number=0;
		if(num!=null&&!"".equals(num)) {
			number=Integer.parseInt(num);
		}
		AddPlan addPlan=new AddPlan();
		addPlan.setProId(proId);
		addPlan.setProName(proName);
		addPlan.setNumber(number);
		
		if(proName!=null) {
			row=selectProductMapper.addMPlan(addPlan);
		}
		return row;
	}
	
	@Override
	public List<AddPlan> selectMplanDetails() {
		List<AddPlan> list=selectProductMapper.selectMplanDetails();
		return list;
	}

	@Override
	public int addMplans(AddPlans addPlans) {
		selectProductMapper.addMplans(addPlans);
		int mPlanId =addPlans.getMPlanId();
		return mPlanId;
	}

	@Override
	public List<MainEmployee> selectEmployee() {
		List<MainEmployee> list=selectProductMapper.selectEmployee();
		return list;
	}

	@Override
	public int updateMplanDetails(int mPlanId) {
		int row=selectProductMapper.updateMplanDetails(mPlanId);
		return row;
	}
	
	@Override
	public void delectRestoreMPlan() {
		selectProductMapper.delectRestoreMPlan();
	}
	
	@Override
	public void deleteEditProduct(Integer mpdId) {
		selectProductMapper.deleteEditProduct(mpdId);
	}
	
	@Override
	public void updateEditProduct(Integer mplanId) {
		selectProductMapper.updateEditProduct(mplanId);
	}
	
	@Override
	public void updateEditAffirm(Integer mplanId) {
		selectProductMapper.updateEditAffirm(mplanId);
	}
	
	@Override
	public void updateDelAffirm() {
		selectProductMapper.updateDelAffirm();
	}
	
	@Override
	public void updateMplanNumber(AddPlan addPlan) {
		selectProductMapper.updateMplanNumber(addPlan);
	}

	@Override
	public int selectQuantity() {
		int quantity = selectProductMapper.selectQuantity();
		return quantity;
	}

	@Override
	public int deleteCancel() {
		int row=selectProductMapper.deleteCancel();
		return row;
	}

	@Override
	public List<AddPlan> queryMplanDetails(Integer mplanId) {
		List<AddPlan> list=selectProductMapper.queryMplanDetails(mplanId);
		return list;
	}

	@Override
	public int deleteMplan(Integer mplanId) {
		int row=selectProductMapper.deleteMplan(mplanId);
		return row;
	}

	@Override
	public int deleteProduct(Integer mpdId) {
		int row=selectProductMapper.deleteProduct(mpdId);
		return row;
	}

	@Override
	public int updateAudit(MProductionPlan mProductionPlan) {
		int row=selectProductMapper.updateAudit(mProductionPlan);
		return row;
	}

	@Override
	public List<AddPlan> selectDplanDetails(Integer mplanId) {
		List<AddPlan> list =selectProductMapper.selectDplanDetails(mplanId);
		return list;
	}

	@Override
	public void updatedQuantity(AddPlan addPlan) {
		selectProductMapper.updatedQuantity(addPlan);
	}

	@Override
	public void addDplanDetails(AddPlan addPlan) {
		selectProductMapper.addDplanDetails(addPlan);
	}

	@Override
	public List<AddPlan> selectdPlanDetailsProId() {
		List<AddPlan> list=selectProductMapper.selectdPlanDetailsProId();
		return list;
	}

	@Override
	public void updatedPlanQuantity(AddPlan addPlan) {
		selectProductMapper.updatedPlanQuantity(addPlan);
	}

	@Override
	public int addDplan(AddPlans addPlans) {
		selectProductMapper.addDplan(addPlans);
		int dPlanId=addPlans.getDPlanId();
		return dPlanId;
	}

	@Override
	public void updateDetDPlanId(int dPlanId) {
		selectProductMapper.updateDetDPlanId(dPlanId);
	}

	@Override
	public void updateDquantityReset() {
		selectProductMapper.updateDquantityReset();
	}

	@Override
	public AddPlan selectEditAffirmNum(Integer mplanId) {
		AddPlan addPlan=selectProductMapper.selectEditAffirmNum(mplanId);
		return addPlan;
	}

	@Override
	public List<AddPlan> selectAllDplanQuantity(AddPlan addPlan) {
		List<AddPlan> listNum =selectProductMapper.selectAllDplanQuantity(addPlan);
		return listNum;
	}

	@Override
	public void deleteCancelMplanDetails() {
		selectProductMapper.deleteCancelMplanDetails();
	}

	@Override
	public List<AddPlan> selectmDetailsSurplus(Integer mplanId) {
		List<AddPlan> list=selectProductMapper.selectmDetailsSurplus(mplanId);
		return list;
	}

	@Override
	public void updatemDetailsSurplus(AddPlan addPlan) {
		selectProductMapper.updatemDetailsSurplus(addPlan);
	}

}
