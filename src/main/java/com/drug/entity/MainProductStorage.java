package com.drug.entity;
/**
 * 成品库存
 * @author bobo
 *
 */
public class MainProductStorage {
	public Integer productSId; 		//成品库存表Id
	public Integer proId;			//产品Id
	public String proName;			//产品名
	public Integer productNumber;	//库存量
	public Integer whID;			//仓库Id
	public String sname;			//仓库名
	public Integer getProductSId() {
		return productSId;
	}
	public void setProductSId(Integer productSId) {
		this.productSId = productSId;
	}
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
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public Integer getWhID() {
		return whID;
	}
	public void setWhID(Integer whID) {
		this.whID = whID;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "MainProductStorage [productSId=" + productSId + ", proId=" + proId + ", proName=" + proName
				+ ", productNumber=" + productNumber + ", whID=" + whID + ", sname=" + sname + "]";
	}
	public MainProductStorage() {
		super();
	}
	public MainProductStorage(Integer proId, Integer productNumber, Integer whID) {
		super();
		this.proId = proId;
		this.productNumber = productNumber;
		this.whID = whID;
	}
	public MainProductStorage(Integer proId) {
		super();
		this.proId = proId;
	}
	
	
}
