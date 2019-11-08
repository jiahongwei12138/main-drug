package com.drug.entity;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class ProQuality {
	private Integer pqId;
	private Integer poId;
	private Integer poPracticalQuantity;
	private String createDate;
	private String qualitystatus;
	private String qualityInspector;
	private String qsData;
	private String visibles;
	
}
