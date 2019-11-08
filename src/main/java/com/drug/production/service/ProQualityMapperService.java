package com.drug.production.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.drug.entity.PqDetails;
import com.drug.entity.ProQuality;

@Component
public interface ProQualityMapperService {

	/**
	 * 功能描述:查询成品管理界面
	 * @return
	 */
	List<ProQuality> selectProductionQualityView();

	/**
	 * 功能描述:成品质检
	 * @param proQuality
	 */
	void updateProductionQuality(ProQuality proQuality);

	/**
	 * 功能描述:成品质检删除
	 * @param pqId
	 */
	void deleteProductionQuality(Integer pqId);

	/**
	 * 功能描述:查询成品质检详情
	 * @param pqId
	 * @return 
	 */
	List<PqDetails> selectProqualitydetails(Integer pqId);
	
	
}
