package com.drug.entity;

import lombok.Data;

@Data
public class AddPlans {
	private Integer dPlanId;
	private Integer mPlanId;
	private Integer mProposerId;
	private String mAuditingDate;
	private Integer mPlanNumber;
	private String mPlanDetailDes;

}
