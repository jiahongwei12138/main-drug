package com.drug.entity;

/**
 * 原料入库
 * @author Administrator
 *
 */

public class MainMaterialInStorage {
	
	private Integer inSId;
	private Integer inSType;
	private String inSTime;
	private Integer whID;
	private String inSState;
	private String checkStates;
	private Integer checkStaffID;
	private Integer planOBId;
	public Integer getInSId() {
		return inSId;
	}
	public void setInSId(Integer inSId) {
		this.inSId = inSId;
	}
	public Integer getInSType() {
		return inSType;
	}
	public void setInSType(Integer inSType) {
		this.inSType = inSType;
	}
	public String getInSTime() {
		return inSTime;
	}
	public void setInSTime(String inSTime) {
		this.inSTime = inSTime;
	}
	public Integer getWhID() {
		return whID;
	}
	public void setWhID(Integer whID) {
		this.whID = whID;
	}
	public String getInSState() {
		return inSState;
	}
	public void setInSState(String inSState) {
		this.inSState = inSState;
	}
	public String getCheckStates() {
		return checkStates;
	}
	public void setCheckStates(String checkStates) {
		this.checkStates = checkStates;
	}
	public Integer getCheckStaffID() {
		return checkStaffID;
	}
	public void setCheckStaffID(Integer checkStaffID) {
		this.checkStaffID = checkStaffID;
	}
	public Integer getPlanOBId() {
		return planOBId;
	}
	public void setPlanOBId(Integer planOBId) {
		this.planOBId = planOBId;
	}
	
}
