package com.drug.entity;
/**
 * 
 * @ClassName: MainPurchaseDetails 
 * @Description: 采购计划表(采购订单)详情
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainPurchaseDetails {
	private Integer detailsId;
	private String detailsName;
	private String detailsCategory;
	private double detailsQuantity;
	private double detailsUnitPrice;
	private double detailsPrice;
	private Integer planId;
	private String detailsqualitystatus;
	private String displayState;
	private Integer detailsPassQuantity;
	private Integer detailsQuantitys;
	private String percent;
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
	public String getDetailsCategory() {
		return detailsCategory;
	}
	public void setDetailsCategory(String detailsCategory) {
		this.detailsCategory = detailsCategory;
	}
	public double getDetailsQuantity() {
		return detailsQuantity;
	}
	public void setDetailsQuantity(double detailsQuantity) {
		this.detailsQuantity = detailsQuantity;
	}
	public double getDetailsUnitPrice() {
		return detailsUnitPrice;
	}
	public void setDetailsUnitPrice(double detailsUnitPrice) {
		this.detailsUnitPrice = detailsUnitPrice;
	}
	public double getDetailsPrice() {
		return detailsPrice;
	}
	public void setDetailsPrice(double detailsPrice) {
		this.detailsPrice = detailsPrice;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public String getDetailsqualitystatus() {
		return detailsqualitystatus;
	}
	public void setDetailsqualitystatus(String detailsqualitystatus) {
		this.detailsqualitystatus = detailsqualitystatus;
	}
	public String getDisplayState() {
		return displayState;
	}
	public void setDisplayState(String displayState) {
		this.displayState = displayState;
	}
	public Integer getDetailsPassQuantity() {
		return detailsPassQuantity;
	}
	public void setDetailsPassQuantity(Integer detailsPassQuantity) {
		this.detailsPassQuantity = detailsPassQuantity;
	}
	public Integer getDetailsQuantitys() {
		return detailsQuantitys;
	}
	public void setDetailsQuantitys(Integer detailsQuantitys) {
		this.detailsQuantitys = detailsQuantitys;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	
	
}
