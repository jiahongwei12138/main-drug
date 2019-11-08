package com.drug.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ReturnOf {
	private Integer proId;
	private Integer returnOfId;
	private Integer poId;
	private String applydate;
	private String status;
	private String insrock;
	private String empName;
	private String auditorName;
	private Integer proposerId;
}
