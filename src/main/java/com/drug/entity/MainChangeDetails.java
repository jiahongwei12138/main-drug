package com.drug.entity;
/**
 * 
 * @ClassName: MainChangeDetails 
 * @Description: 采购换货详情实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainChangeDetails {
	private Integer changeDetailsId;
	private String changeDetailsName;
	private Integer changeDetailsQuantity;
	private double changeDetailsUnitPrice;
	private double changeDetailsTotalPrice;
	private Integer changeId;
	private Integer detailsId;
	public Integer getChangeDetailsId() {
		return changeDetailsId;
	}
	public void setChangeDetailsId(Integer changeDetailsId) {
		this.changeDetailsId = changeDetailsId;
	}
	public String getChangeDetailsName() {
		return changeDetailsName;
	}
	public void setChangeDetailsName(String changeDetailsName) {
		this.changeDetailsName = changeDetailsName;
	}
	public Integer getChangeDetailsQuantity() {
		return changeDetailsQuantity;
	}
	public void setChangeDetailsQuantity(Integer changeDetailsQuantity) {
		this.changeDetailsQuantity = changeDetailsQuantity;
	}
	public double getChangeDetailsUnitPrice() {
		return changeDetailsUnitPrice;
	}
	public void setChangeDetailsUnitPrice(double changeDetailsUnitPrice) {
		this.changeDetailsUnitPrice = changeDetailsUnitPrice;
	}
	public double getChangeDetailsTotalPrice() {
		return changeDetailsTotalPrice;
	}
	public void setChangeDetailsTotalPrice(double changeDetailsTotalPrice) {
		this.changeDetailsTotalPrice = changeDetailsTotalPrice;
	}
	public Integer getChangeId() {
		return changeId;
	}
	public void setChangeId(Integer changeId) {
		this.changeId = changeId;
	}
	public Integer getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}
	
	
}
