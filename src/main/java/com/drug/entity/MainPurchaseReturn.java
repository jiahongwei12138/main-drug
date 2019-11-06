package com.drug.entity;
/**
 * 
 * @ClassName: MainPurchaseReturn 
 * @Description: 采购退货实体类
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainPurchaseReturn {
	private Integer returnId;
	private Integer supplierId;
	private double returnCause;
	private String returnDescription;
	private String returnState;
	private String returnAuditTime;
	private String FSId;
	private String returnFState;
	private Integer planId;
	public Integer getReturnId() {
		return returnId;
	}
	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public double getReturnCause() {
		return returnCause;
	}
	public void setReturnCause(double returnCause) {
		this.returnCause = returnCause;
	}
	public String getReturnDescription() {
		return returnDescription;
	}
	public void setReturnDescription(String returnDescription) {
		this.returnDescription = returnDescription;
	}
	public String getReturnState() {
		return returnState;
	}
	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}
	public String getReturnAuditTime() {
		return returnAuditTime;
	}
	public void setReturnAuditTime(String returnAuditTime) {
		this.returnAuditTime = returnAuditTime;
	}
	public String getFSId() {
		return FSId;
	}
	public void setFSId(String fSId) {
		FSId = fSId;
	}
	public String getReturnFState() {
		return returnFState;
	}
	public void setReturnFState(String returnFState) {
		this.returnFState = returnFState;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
	
	
}
