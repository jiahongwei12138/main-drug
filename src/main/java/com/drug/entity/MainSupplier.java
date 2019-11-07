package com.drug.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MainSupplier
 * @Description: 总店供应商实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
@Component
public class MainSupplier {
	private Integer supplierId;
	private String supplierClassify;
	private String supplierName;
	private String supplierNumber;
	private String supplierSite;
	private String supplierContact;
	private String createTime;
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierClassify() {
		return supplierClassify;
	}
	public void setSupplierClassify(String supplierClassify) {
		this.supplierClassify = supplierClassify;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getSupplierSite() {
		return supplierSite;
	}
	public void setSupplierSite(String supplierSite) {
		this.supplierSite = supplierSite;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
