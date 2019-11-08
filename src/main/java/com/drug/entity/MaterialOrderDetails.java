package com.drug.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MaterialOrderDetails {
	private Integer modId;// 主键
	private Integer moId;// 领料单Id(外键)
	private Integer rawMaterialId;// 原材料Id(外键)
	private BigDecimal weight;// 正常生产材料重量
	private String rawMaterialName;
}
