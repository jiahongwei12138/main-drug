package com.drug.entity;
/**
 * 
 * @ClassName: MainPurchaseChange 
 * @Description: 采购换货实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainPurchaseChange {
	private Integer changeId;
	private Integer supplierId;
	private double changeCause;
	private String changeDescription;
	private String changeState;
	private Integer planId;
	public Integer getChangeId() {
		return changeId;
	}
	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public double getChangeCause() {
		return changeCause;
	}
	public void setChangeCause(double changeCause) {
		this.changeCause = changeCause;
	}
	public String getChangeDescription() {
		return changeDescription;
	}
	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}
	public String getChangeState() {
		return changeState;
	}
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
}
