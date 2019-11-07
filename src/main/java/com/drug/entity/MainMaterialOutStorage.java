package com.drug.entity;

/**
 * 原料出库
 * @author Administrator
 *
 */

public class MainMaterialOutStorage {
	
	private Integer outSId;
	private Integer outSType;
	private String outSTime;
	private Integer whId;
	private String outSState;
	private String checkStates;
	private Integer checkStaffId;
	private Integer moOAoId;
	public Integer getOutSId() {
		return outSId;
	}
	public void setOutSId(Integer outSId) {
		this.outSId = outSId;
	}
	public Integer getOutSType() {
		return outSType;
	}
	public void setOutSType(Integer outSType) {
		this.outSType = outSType;
	}
	public String getOutSTime() {
		return outSTime;
	}
	public void setOutSTime(String outSTime) {
		this.outSTime = outSTime;
	}
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getOutSState() {
		return outSState;
	}
	public void setOutSState(String outSState) {
		this.outSState = outSState;
	}
	public String getCheckStates() {
		return checkStates;
	}
	public void setCheckStates(String checkStates) {
		this.checkStates = checkStates;
	}
	public Integer getCheckStaffId() {
		return checkStaffId;
	}
	public void setCheckStaffId(Integer checkStaffId) {
		this.checkStaffId = checkStaffId;
	}
	public Integer getMoOAoId() {
		return moOAoId;
	}
	public void setMoOAoId(Integer moOAoId) {
		this.moOAoId = moOAoId;
	}
	
}
