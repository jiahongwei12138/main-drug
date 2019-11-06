package com.drug.entity;

/**
 * 仓库类型
 * @author Administrator
 *
 */

public class MainStorage {
	
	private Integer storageId;
	private String sname;
	private String storageType;
	private String createTime;
	private String storageState;
	private String storageAddr;
	public Integer getStorageId() {
		return storageId;
	}
	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStorageState() {
		return storageState;
	}
	public void setStorageState(String storageState) {
		this.storageState = storageState;
	}
	public String getStorageAddr() {
		return storageAddr;
	}
	public void setStorageAddr(String storageAddr) {
		this.storageAddr = storageAddr;
	}
	
}
