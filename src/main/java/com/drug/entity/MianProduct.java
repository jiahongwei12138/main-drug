package com.drug.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MianProduct {
	   private Integer proId; // '产品id',
	   private String proName; // '产品名称',
	   private String enlishName; // '英文名称',
	   private String CHARACTER; // '形状',
	   private String methodOfApplication; // '用法用量',
	   private String packaging; // '包装',
	   private String proBatchNumber; // '产品批号',
	   private String expirationdate; // '保质期',
	   private String storageCondition; // '存储环境',
	   private String specification; // '规格',
	   private String thebarcode; // '条码编号',
	   private String proImageUrl; // '产品图片路径',
	   private String proCure; // '功效描述',
	   private String proForbidden; // '禁用描述',
	   private String proBadness; // '不良反应描述',
	   private BigDecimal costPice; // '成本价',
	   private BigDecimal retailPrice; // '售价'
	   private Integer recipeId; // '配方表id',
	   private Integer hqtId; // '生产商id（总店id）',
	   private String field1; // '字段1',
	   private String field2; // '字段2',
}
