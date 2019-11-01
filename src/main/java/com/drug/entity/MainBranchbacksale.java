package com.drug.entity;

public class MainBranchbacksale {
	private Integer backSaleId;//退货单id
	private Integer bsfId;//分店id
	private String backReason;//退货原因 
	private String backTime;//退货时间 
	private Double backMoney;//退款金额 
	private String checkState;//审核状态 
	private String inStoreState;//入库状态 
	private String payMoneyState;//退款状态 
	private String inStoreCheckState;//质检状态 
	private String backOrderNum;//订单编号  
	private Integer empId;//销售员id（员工表id）
	private Integer bprId;//采购退货单id
	private String field2;//字段2
	private String bsfName;//分店名称 
	
	public String getBsfName() {
		return bsfName;
	}
	public void setBsfName(String bsfName) {
		this.bsfName = bsfName;
	}
	public Integer getBackSaleId() {
		return backSaleId;
	}
	public void setBackSaleId(Integer backSaleId) {
		this.backSaleId = backSaleId;
	}
	public Integer getBsfId() {
		return bsfId;
	}
	public void setBsfId(Integer bsfId) {
		this.bsfId = bsfId;
	}
	public String getBackReason() {
		return backReason;
	}
	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}
	public String getBackTime() {
		return backTime;
	}
	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}
	public Double getBackMoney() {
		return backMoney;
	}
	public void setBackMoney(Double backMoney) {
		this.backMoney = backMoney;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getInStoreState() {
		return inStoreState;
	}
	public void setInStoreState(String inStoreState) {
		this.inStoreState = inStoreState;
	}
	public String getPayMoneyState() {
		return payMoneyState;
	}
	public void setPayMoneyState(String payMoneyState) {
		this.payMoneyState = payMoneyState;
	}
	public String getInStoreCheckState() {
		return inStoreCheckState;
	}
	public void setInStoreCheckState(String inStoreCheckState) {
		this.inStoreCheckState = inStoreCheckState;
	}
	public String getBackOrderNum() {
		return backOrderNum;
	}
	public void setBackOrderNum(String backOrderNum) {
		this.backOrderNum = backOrderNum;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public Integer getBprId() {
		return bprId;
	}
	public void setBprId(Integer bprId) {
		this.bprId = bprId;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	
}
