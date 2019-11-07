package com.drug.entity;

import org.springframework.stereotype.Component;

@Component
public class MainPurchaseMajorPlanDetails {
	private Integer detailsId;
	private String detailsName;
	private double detailsQuantity;
	private double detailsRealQuantity;
	private Integer majorPlanId;
	private String unit;
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}
	public String getDetailsName() {
		return detailsName;
	}
	public void setDetailsName(String detailsName) {
		this.detailsName = detailsName;
	}
	public double getDetailsQuantity() {
		return detailsQuantity;
	}
	public void setDetailsQuantity(double detailsQuantity) {
		this.detailsQuantity = detailsQuantity;
	}
	public double getDetailsRealQuantity() {
		return detailsRealQuantity;
	}
	public void setDetailsRealQuantity(double detailsRealQuantity) {
		this.detailsRealQuantity = detailsRealQuantity;
	}
	public Integer getMajorPlanId() {
		return majorPlanId;
	}
	public void setMajorPlanId(Integer majorPlanId) {
		this.majorPlanId = majorPlanId;
	}
	
	
}
