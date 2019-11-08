package com.drug.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MainPurchasePlan 
 * @Description: 采购计划表(采购订单)  
 * @author lxl
 * @date 2019年10月22日
 *
 */
@Component
public class MainPurchasePlan {
	private Integer planId;
	private String planName;
	private String planSubmissionTime;
	private String planState;
	private String planRemark;
	private double planTotalPrices;
	private double planRealTotalPrices;
	private Integer createName;
	private Integer financeCheck;
	private Integer StoreCheck;
	private Integer purchaseCheck;
	private String checkState;
	private String inStoregState;
	private String planAuditTime;
	private String planAuditOpinion;
	private String rawMaterialTheQualityStatus;
	private Integer supplierId;
	private Integer majorPlanId;
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanSubmissionTime() {
		return planSubmissionTime;
	}
	public void setPlanSubmissionTime(String planSubmissionTime) {
		this.planSubmissionTime = planSubmissionTime;
	}
	public String getPlanState() {
		return planState;
	}
	public void setPlanState(String planState) {
		this.planState = planState;
	}
	public String getPlanRemark() {
		return planRemark;
	}
	public void setPlanRemark(String planRemark) {
		this.planRemark = planRemark;
	}
	public double getPlanTotalPrices() {
		return planTotalPrices;
	}
	public void setPlanTotalPrices(double planTotalPrices) {
		this.planTotalPrices = planTotalPrices;
	}
	public double getPlanRealTotalPrices() {
		return planRealTotalPrices;
	}
	public void setPlanRealTotalPrices(double planRealTotalPrices) {
		this.planRealTotalPrices = planRealTotalPrices;
	}
	public Integer getCreateName() {
		return createName;
	}
	public void setCreateName(Integer createName) {
		this.createName = createName;
	}
	public Integer getFinanceCheck() {
		return financeCheck;
	}
	public void setFinanceCheck(Integer financeCheck) {
		this.financeCheck = financeCheck;
	}
	public Integer getStoreCheck() {
		return StoreCheck;
	}
	public void setStoreCheck(Integer storeCheck) {
		StoreCheck = storeCheck;
	}
	public Integer getPurchaseCheck() {
		return purchaseCheck;
	}
	public void setPurchaseCheck(Integer purchaseCheck) {
		this.purchaseCheck = purchaseCheck;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getInStoregState() {
		return inStoregState;
	}
	public void setInStoregState(String inStoregState) {
		this.inStoregState = inStoregState;
	}
	public String getPlanAuditTime() {
		return planAuditTime;
	}
	public void setPlanAuditTime(String planAuditTime) {
		this.planAuditTime = planAuditTime;
	}
	public String getPlanAuditOpinion() {
		return planAuditOpinion;
	}
	public void setPlanAuditOpinion(String planAuditOpinion) {
		this.planAuditOpinion = planAuditOpinion;
	}
	public String getRawMaterialTheQualityStatus() {
		return rawMaterialTheQualityStatus;
	}
	public void setRawMaterialTheQualityStatus(String rawMaterialTheQualityStatus) {
		this.rawMaterialTheQualityStatus = rawMaterialTheQualityStatus;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getMajorPlanId() {
		return majorPlanId;
	}
	public void setMajorPlanId(Integer majorPlanId) {
		this.majorPlanId = majorPlanId;
	}
	
	
}