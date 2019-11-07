package com.drug.entity;
/**
 * 
 * @ClassName: MainReturnDetails 
 * @Description: 采购退货详情实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainReturnDetails {
	private Integer returnDetailsId;
	private String returnDetailsName;
	private double returnDetailsQuantity;
	private double returnDetailsUnitPrice;
	private double returnDetailsTotalPrice;
	private Integer returnId;
	private Integer detailsId;
	public Integer getReturnDetailsId() {
		return returnDetailsId;
	}
	public void setReturnDetailsId(Integer returnDetailsId) {
		this.returnDetailsId = returnDetailsId;
	}
	public String getReturnDetailsName() {
		return returnDetailsName;
	}
	public void setReturnDetailsName(String returnDetailsName) {
		this.returnDetailsName = returnDetailsName;
	}
	public double getReturnDetailsQuantity() {
		return returnDetailsQuantity;
	}
	public void setReturnDetailsQuantity(double returnDetailsQuantity) {
		this.returnDetailsQuantity = returnDetailsQuantity;
	}
	public double getReturnDetailsUnitPrice() {
		return returnDetailsUnitPrice;
	}
	public void setReturnDetailsUnitPrice(double returnDetailsUnitPrice) {
		this.returnDetailsUnitPrice = returnDetailsUnitPrice;
	}
	public double getReturnDetailsTotalPrice() {
		return returnDetailsTotalPrice;
	}
	public void setReturnDetailsTotalPrice(double returnDetailsTotalPrice) {
		this.returnDetailsTotalPrice = returnDetailsTotalPrice;
	}
	public Integer getReturnId() {
		return returnId;
	}
	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}
	
}
