package com.drug.entity;

/**
 * 成品出库
 * @author Administrator
 *
 */

public class MainProductOutStorage {

	private Integer posId;
	private String posTime;
	private Integer whID;
	private String posState;
	private String checkStates;
	private Integer checkStaffId;
	private Integer orderId;
	public Integer getPosId() {
		return posId;
	}
	public void setPosId(Integer posId) {
		this.posId = posId;
	}
	public String getPosTime() {
		return posTime;
	}
	public void setPosTime(String posTime) {
		this.posTime = posTime;
	}
	public Integer getWhID() {
		return whID;
	}
	public void setWhID(Integer whID) {
		this.whID = whID;
	}
	public String getPosState() {
		return posState;
	}
	public void setPosState(String posState) {
		this.posState = posState;
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
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
