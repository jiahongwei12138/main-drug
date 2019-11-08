package com.drug.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MaterialOrder {
	private Integer moId;// 主键
	private Integer poId;// 生产订单Id(外键)
	private String applydate;// 申请日期
	private Integer proposerId;// 申请人Id 员工表(外键)
	private String proposerName;
	private String auditingdate;// 审核日期
	private String auditorName;// 审核 员工表(外键)
	private String status;//-- 审核状态 (未申请/未通过/已通过)
	private String outStock;// 出库状态
	private String signfor;// 签收状态
	private String materialDes;  //备注
	private Integer pqId;
}
