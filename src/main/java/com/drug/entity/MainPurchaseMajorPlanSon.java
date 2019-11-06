package com.drug.entity;

import org.springframework.stereotype.Component;

@Component
public class MainPurchaseMajorPlanSon extends MainPurchaseMajorPlan{
	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
}
