package com.drug.entity;

public class MainSaleOrderdetail {
	private Integer detailsId;//订单详情id
	private Integer proId;//药品id（药品表id）
	private Integer orderId;//销售订单id
	private Integer proNum;//药品数量
	private Double proPrice;//药品价格小计
	private Integer field1;//字段1
	private Integer field2;//字段2
	private String proBatchNumber;
	private String proName;
	private Double retailPrice;
	
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
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
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProNum() {
		return proNum;
	}
	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public Integer getField1() {
		return field1;
	}
	public void setField1(Integer field1) {
		this.field1 = field1;
	}
	public Integer getField2() {
		return field2;
	}
	public void setField2(Integer field2) {
		this.field2 = field2;
	}
	
}
