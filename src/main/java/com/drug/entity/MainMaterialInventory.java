package com.drug.entity;

/**
 * 原料库存
 * @author Administrator
 *
 */

public class MainMaterialInventory {
    
    private Integer materialInvId;
    private double materialNumber;
    private Integer materialId;
    private Integer whID;
	public Integer getMaterialInvId() {
		return materialInvId;
	}
	public void setMaterialInvId(Integer materialInvId) {
		this.materialInvId = materialInvId;
	}
	public double getMaterialNumber() {
		return materialNumber;
	}
	public void setMaterialNumber(double materialNumber) {
		this.materialNumber = materialNumber;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	public Integer getWhID() {
		return whID;
	}
	public void setWhID(Integer whID) {
		this.whID = whID;
	}
    
}
