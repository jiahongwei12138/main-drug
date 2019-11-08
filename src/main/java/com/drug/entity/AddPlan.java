package com.drug.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddPlan {
	private Integer mpdId;
	private Integer proId;
	private String proName;    
	private Integer number;
	private Integer mDetailsSurplus;
	private Integer podsQuantity;
	private Integer dPlanQuantity;
	private Integer dpdId;
	private Integer podId;
	private Integer poQuantity;
	private Integer podsPracticalQuantity;
	private Integer mplanId;
	private Integer dplanId;
	private Integer podsSurplus;
	private Integer pqdId;
	private Integer poId;
}
