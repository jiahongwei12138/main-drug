package com.drug.entity;
/**
 * 
 * @ClassName: MainPurchaseMajorPlan 
 * @Description: 采购月计划实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainPurchaseMajorPlan {
	private Integer majorPlanId;
	private String majorPlanName;
	private String majorPlanSubmissionTime;
	private String majorPlanRemark;
	private double majorPlanTotalPrices;
	private double majorPlanRealTotalPrices;
	private Integer createName;
	public Integer getMajorPlanId() {
		return majorPlanId;
	}
	public void setMajorPlanId(Integer majorPlanId) {
		this.majorPlanId = majorPlanId;
	}
	public String getMajorPlanName() {
		return majorPlanName;
	}
	public void setMajorPlanName(String majorPlanName) {
		this.majorPlanName = majorPlanName;
	}
	public String getMajorPlanSubmissionTime() {
		return majorPlanSubmissionTime;
	}
	public void setMajorPlanSubmissionTime(String majorPlanSubmissionTime) {
		this.majorPlanSubmissionTime = majorPlanSubmissionTime;
	}
	public String getMajorPlanRemark() {
		return majorPlanRemark;
	}
	public void setMajorPlanRemark(String majorPlanRemark) {
		this.majorPlanRemark = majorPlanRemark;
	}
	public double getMajorPlanTotalPrices() {
		return majorPlanTotalPrices;
	}
	public void setMajorPlanTotalPrices(double majorPlanTotalPrices) {
		this.majorPlanTotalPrices = majorPlanTotalPrices;
	}
	public double getMajorPlanRealTotalPrices() {
		return majorPlanRealTotalPrices;
	}
	public void setMajorPlanRealTotalPrices(double majorPlanRealTotalPrices) {
		this.majorPlanRealTotalPrices = majorPlanRealTotalPrices;
	}
	public Integer getCreateName() {
		return createName;
	}
	public void setCreateName(Integer createName) {
		this.createName = createName;
	}
	
	
}
