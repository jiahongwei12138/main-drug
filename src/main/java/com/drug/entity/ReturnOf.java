package com.drug.entity;

public class ReturnOf {

	private Integer returnOfId;
	private Integer poId;
	private String applydate;
	private String status;
	private String insrock;
	private String empName;
	private String auditorName;
	public ReturnOf() {
		super();
	}
	public ReturnOf(Integer returnOfId, Integer poId, String applydate, String status, String insrock,
			String empName, String auditorName) {
		super();
		this.returnOfId = returnOfId;
		this.poId = poId;
		this.applydate = applydate;
		this.status = status;
		this.insrock = insrock;
		this.empName = empName;
		this.auditorName = auditorName;
	}
	public Integer getReturnOfId() {
		return returnOfId;
	}
	public void setReturnOfId(Integer returnOfId) {
		this.returnOfId = returnOfId;
	}
	public Integer getPoId() {
		return poId;
	}
	public void setPoId(Integer poId) {
		this.poId = poId;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInsrock() {
		return insrock;
	}
	public void setInsrock(String insrock) {
		this.insrock = insrock;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	
}
