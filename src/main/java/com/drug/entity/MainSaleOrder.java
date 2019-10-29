package com.drug.entity;

public class MainSaleOrder {

	private Integer orderId;//销售订单id
	private String  orderNum;//订单编号
	private String payTime;//下单时间
	private Double payrMoney;//付款金额
	private String getMoneyState;//收款状态
	private String sendTime;//发货时间
	private String receiveTime;//收货时间
	private String payWay;//付款方式
	private String checkState;//审核状态
	private String outStoreState;//出库状态
	private Integer empId;//销售员id（总店员工id）
	private Integer bsfId;//分店id（分店下单显示分店名称）
	private String bsfName;//分店名称
	private Integer field1;//字段1
	private Integer field2;//字段2
	
	
	public String getBsfName() {
		return bsfName;
	}
	public void setBsfName(String bsfName) {
		this.bsfName = bsfName;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public Double getPayrMoney() {
		return payrMoney;
	}
	public void setPayrMoney(Double payrMoney) {
		this.payrMoney = payrMoney;
	}
	public String getGetMoneyState() {
		return getMoneyState;
	}
	public void setGetMoneyState(String getMoneyState) {
		this.getMoneyState = getMoneyState;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getOutStoreState() {
		return outStoreState;
	}
	public void setOutStoreState(String outStoreState) {
		this.outStoreState = outStoreState;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getBsfId() {
		return bsfId;
	}
	public void setBsfId(Integer bsfId) {
		this.bsfId = bsfId;
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
