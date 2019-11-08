package com.drug.entity;

import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: MainSupplierOffer 
 * @Description: 总店供应商详情实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
@Component
public class MainSupplierOffer {
	private Integer offerId;
	private String offerName;
	private double offerPrice;
	private String offerPlaceOfOrigin;
	private String offerRemark;
	private Integer supplierId;
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getOfferPlaceOfOrigin() {
		return offerPlaceOfOrigin;
	}
	public void setOfferPlaceOfOrigin(String offerPlaceOfOrigin) {
		this.offerPlaceOfOrigin = offerPlaceOfOrigin;
	}
	public String getOfferRemark() {
		return offerRemark;
	}
	public void setOfferRemark(String offerRemark) {
		this.offerRemark = offerRemark;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
}
