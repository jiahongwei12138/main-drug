package com.drug.entity;

public class WasteManagement {

	private Integer wasteId;//废料单编号
	private String proName;//废料名称
	private Integer wasteQuantity;//废料数量
	private String applydate;//加入日趋
	private String status;//处理状态
	public WasteManagement() {
		super();
	}
	public WasteManagement(Integer wasteId, String proName, Integer wasteQuantity, String applydate, String status) {
		super();
		this.wasteId = wasteId;
		this.proName = proName;
		this.wasteQuantity = wasteQuantity;
		this.applydate = applydate;
		this.status = status;
	}
	public Integer getWasteId() {
		return wasteId;
	}
	public void setWasteId(Integer wasteId) {
		this.wasteId = wasteId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getWasteQuantity() {
		return wasteQuantity;
	}
	public void setWasteQuantity(Integer wasteQuantity) {
		this.wasteQuantity = wasteQuantity;
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
}
