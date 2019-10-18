package com.drug.entity;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
/**
*	 描述:月计划界面
* @author:易哲泽
* @date: 2019年10月17日下午8:22:13
* @version:1.0
 */
public class MProductionPlan {
	//生产月计划编号
	private Integer mPlanId;
	//申请人
	private String mProposerName;
	//申请时间
	private String mApplyDate;
	//生产月计划完成总量
	private Integer mPlanQuantity;
	//生产月计划实际完成总量
	private Integer mPracticalQuantity;
	//生产进度
	//private String  productionSchedule;
	//审核状态
	private String mStatus;
	//审核人
	private String mAuditorName;
	//审核时间
	private String mAuditingDate;
	//完成时间
	private String mEnddate;

}
