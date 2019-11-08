package com.drug.entity;

import lombok.Data;

@Data
public class ProductionOrder {
	private Integer poId;	//主键
	private Integer dplanId; 	//日生产计划表Id(外键)
	private Integer poQuantity; //订单总数
	private Integer poPracticalQuantity; // 完成量
	private Integer poProposerId; //申请人Id(外键 员工表)
	private String poData; //申请时间
	private String poProposerName;	//申请人
	private String poAuditingDate; //审核时间
	private String poAuditorName; //审核人(外键 员工表)
	private String poStatus; //审核状态
	private Integer poVisibles; //显示状态,默认未删除(删除状态) 
	private String poState; //生产状态
	private String poMaterialState; //领料状态
	private String poplanDetailDes; //备注
	private Integer moId;
}
