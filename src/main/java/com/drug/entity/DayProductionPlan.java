package com.drug.entity;

import lombok.Data;

@Data
public class DayProductionPlan {
	private Integer dPlanId;
	private Integer mPlanId;
	private String dApplyDate;
	private String dProposerName;
	//private Integer dPlanNumber;
	private String dAuditingDate;
	private String dProState;
	private String dStatus;
	private String dAuditorName;
	private String des;
}
