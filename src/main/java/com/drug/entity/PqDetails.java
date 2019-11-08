package com.drug.entity;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class PqDetails {
	private Integer pqdId;//主键
	private Integer pqId;//生产成品管理(质检)(外键)
	private Integer proId;// 成品主键(外键)
	private Integer proQuantity;// 生产数量
	private String proName;
}
