package com.drug.entity;

public class ProductManagement {

	private Integer proId;//产品id
	private String proName;//产品名称
	private String proPassQuantity;//成品数量
	private String dAuditingDate;//生产时间
	private String qualityStatus;//质检状态
	
	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProPassQuantity() {
		return proPassQuantity;
	}

	public void setProPassQuantity(String proPassQuantity) {
		this.proPassQuantity = proPassQuantity;
	}

	public String getdAuditingDate() {
		return dAuditingDate;
	}

	public void setdAuditingDate(String dAuditingDate) {
		this.dAuditingDate = dAuditingDate;
	}

	public String getQualityStatus() {
		return qualityStatus;
	}

	public void setQualityStatus(String qualityStatus) {
		this.qualityStatus = qualityStatus;
	}

	public ProductManagement() {
		super();
	}

	public ProductManagement(Integer proId, String proName, String proPassQuantity, String dAuditingDate,
			String qualityStatus) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proPassQuantity = proPassQuantity;
		this.dAuditingDate = dAuditingDate;
		this.qualityStatus = qualityStatus;
	}

	
	
	
}
