
package com.drug.entity;

/**
 * 成品入库
 * @author Administrator
 *
 */

public class MainProductInStorage {

	private Integer piSId;
	private Integer piSType;
	private String piSTypeName;
	private String piSTime;
	private Integer whID;
	private String sname;
	private String piSState;
	private String checkStates;
	private Integer checkStaffId;
	private String empName;
	private Integer poOBoId;
	public Integer getPiSId() {
		return piSId;
	}
	public void setPiSId(Integer piSId) {
		this.piSId = piSId;
	}
	public Integer getPiSType() {
		return piSType;
	}
	public void setPiSType(Integer piSType) {
		this.piSType = piSType;
	}
	public String getPiSTime() {
		return piSTime;
	}
	public void setPiSTime(String piSTime) {
		this.piSTime = piSTime;
	}
	public Integer getWhID() {
		return whID;
	}
	public void setWhID(Integer whID) {
		this.whID = whID;
	}
	public String getPiSState() {
		return piSState;
	}
	public void setPiSState(String piSState) {
		this.piSState = piSState;
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
	public Integer getPoOBoId() {
		return poOBoId;
	}
	public void setPoOBoId(Integer poOBoId) {
		this.poOBoId = poOBoId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPiSTypeName() {
		return piSTypeName;
	}
	public void setPiSTypeName(String piSTypeName) {
		this.piSTypeName = piSTypeName;
	}
	
}
