package com.drug.entity;
/**
 * 
 * 类的描述：采购退货详情类
 * @author 刘鑫旺
 * @dateTime 2019年10月22日上午10:01:37
 * @version 1.0
 */
public class BranchPurchaseReturnDetails {
	private Integer bprdId;//退货详情主键id
	private Integer proId;//商品id(商品表主键id)
	private String proName;//商品名称
	private Double proPrice;//商品价格
	private Double bprdSubtotal;//商品价格
	private Integer bprdQuantity;//商品数量
	private Integer bprId;//退货单ID(退货订单表主键id)
	
	public Double getBprdSubtotal() {
		return bprdSubtotal;
	}
	public void setBprdSubtotal(Double bprdSubtotal) {
		this.bprdSubtotal = bprdSubtotal;
	}
	public Integer getBprdId() {
		return bprdId;
	}
	public void setBprdId(Integer bprdId) {
		this.bprdId = bprdId;
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
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public Integer getBprdQuantity() {
		return bprdQuantity;
	}
	public void setBprdQuantity(Integer bprdQuantity) {
		this.bprdQuantity = bprdQuantity;
	}
	public Integer getBprId() {
		return bprId;
	}
	public void setBprId(Integer bprId) {
		this.bprId = bprId;
	}
	
}
