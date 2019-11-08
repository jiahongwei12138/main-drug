package com.drug.entity;

public class MainBranchbacksaledetail {
	private Integer backSaleDetailId;//退货详情单id
	private Integer backSaleId;//退货订单id（总店）
	private Integer proId;//药品id（药品表id）
	private Double proPrice;//药品价格
	private Integer proNum;//药品数量小计
	private String bprId;//字段1
	private String field2;//字段2
	private String proBatchNumber;
	private String proName;
	private Double retailPrice;
	public Integer getBackSaleDetailId() {
		return backSaleDetailId;
	}
	public void setBackSaleDetailId(Integer backSaleDetailId) {
		this.backSaleDetailId = backSaleDetailId;
	}
	public Integer getBackSaleId() {
		return backSaleId;
	}
	public void setBackSaleId(Integer backSaleId) {
		this.backSaleId = backSaleId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public Integer getProNum() {
		return proNum;
	}
	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}
	
	public String getBprId() {
		return bprId;
	}
	public void setBprId(String bprId) {
		this.bprId = bprId;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getProBatchNumber() {
		return proBatchNumber;
	}
	public void setProBatchNumber(String proBatchNumber) {
		this.proBatchNumber = proBatchNumber;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
}
