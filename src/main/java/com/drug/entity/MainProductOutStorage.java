package com.drug.entity;
/**
 * 
 * @author bobo
 *
 */
public class MainProductOutStorage {
	
	private int posId;			// 成品出库表Id
	private int poSType =1;		// 出库类型
	private String poSTypeName;	// 出库类型名
	private String posTime;		// 成品出库时间
	private int whID;			// 成品仓ID
	private String sname;		// 仓库名
	private String posState;	// 成品出库状态
	private String checkStates;	// 审核状态
	private int checkStaffId;	// 审核人Id
	private String empName;		// 审核人姓名
	private int orderId;		// 销售订单Id
	public int getPosId() {
		return posId;
	}
	public void setPosId(int posId) {
		this.posId = posId;
	}
	public int getPoSType() {
		return poSType;
	}
	public void setPoSType(int poSType) {
		this.poSType = poSType;
	}
	public String getPosTime() {
		return posTime;
	}
	public void setPosTime(String posTime) {
		this.posTime = posTime;
	}
	public int getWhID() {
		return whID;
	}
	public void setWhID(int whID) {
		this.whID = whID;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public int getCheckStaffId() {
		return checkStaffId;
	}
	public void setCheckStaffId(int checkStaffId) {
		this.checkStaffId = checkStaffId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPoSTypeName() {
		return poSTypeName;
	}
	public void setPoSTypeName(String poSTypeName) {
		this.poSTypeName = poSTypeName;
	}
	
}
