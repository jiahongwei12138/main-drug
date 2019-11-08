package com.drug.production.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.entity.PqDetails;
import com.drug.entity.ProQuality;
import com.drug.production.mapper.ProQualityMapper;
import com.drug.production.service.ProQualityMapperService;

@Service
public class ProQualityMapperServiceImpl implements ProQualityMapperService{
	
	@Autowired
	private ProQualityMapper proQualityMapper;

	@Override
	public List<ProQuality> selectProductionQualityView() {
		List<ProQuality> list=proQualityMapper.selectProductionQualityView();
		return list;
	}

	@Override
	public void updateProductionQuality(ProQuality proQuality) {
		proQualityMapper.updateProductionQuality(proQuality);
	}

	@Override
	public void deleteProductionQuality(Integer pqId) {
		proQualityMapper.deleteProductionQuality(pqId);
	}

	@Override
	public List<PqDetails> selectProqualitydetails(Integer pqId) {
		List<PqDetails> list=proQualityMapper.selectProqualitydetails(pqId);
		return list;
	}
}
