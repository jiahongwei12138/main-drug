package com.drug.entity;

/**
 * 废料库存
 * @author Administrator
 *
 */

public class MainWasteStorage {

	private Integer wasteSId;
	private Integer proId;
	private double wasteNumber;
	private Integer whId;
	private String description;
	public Integer getWasteSId() {
		return wasteSId;
	}
	public void setWasteSId(Integer wasteSId) {
		this.wasteSId = wasteSId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public double getWasteNumber() {
		return wasteNumber;
	}
	public void setWasteNumber(double wasteNumber) {
		this.wasteNumber = wasteNumber;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
