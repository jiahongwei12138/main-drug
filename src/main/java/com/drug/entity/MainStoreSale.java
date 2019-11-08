package com.drug.entity;
/**
 * 
 * @author bobo
 *
 */
public class MainStoreSale {
	private Integer orderId; 		//销售订单id
	private Integer sendTime;		//发货时间
	private Integer checkState;		//审核状态
	private Integer outStoreState;	//出库状态
	private Integer whID;			//出库仓库
	private Integer sname;			//仓库名
	private Integer empId;			//审核人Id
	private String empName;			//审核人姓名
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getSendTime() {
		return sendTime;
	}
	public void setSendTime(Integer sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getCheckState() {
		return checkState;
	}
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}
	public Integer getOutStoreState() {
		return outStoreState;
	}
	public void setOutStoreState(Integer outStoreState) {
		this.outStoreState = outStoreState;
	}
	public Integer getWhID() {
		return whID;
	}
	public void setWhID(Integer whID) {
		this.whID = whID;
	}
	public Integer getSname() {
		return sname;
	}
	public void setSname(Integer sname) {
		this.sname = sname;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
