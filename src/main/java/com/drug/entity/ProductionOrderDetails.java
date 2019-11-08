package com.drug.entity;
/**
 * 
 * @author bobo
 *
 */
public class ProductionOrderDetails {
	private Integer podId;				//主键
	private Integer poId;				//成品生产订单id(外键)
	private Integer proId;				//成品主键(外键)
	private String proName;				//成品名称
	private String qualitystatus;		//质检状态
	private Integer proQuantity;		//生产数量
	private Integer proPassQuantity;	//通过数量
	private Double percent;				//合格率
	
	public Integer getPodId() {
		return podId;
	}
	public void setPodId(Integer podId) {
		this.podId = podId;
	}
	public Integer getPoId() {
		return poId;
	}
	public void setPoId(Integer poId) {
		this.poId = poId;
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
	public String getQualitystatus() {
		return qualitystatus;
	}
	public void setQualitystatus(String qualitystatus) {
		this.qualitystatus = qualitystatus;
	}
	public Integer getProQuantity() {
		return proQuantity;
	}
	public void setProQuantity(Integer proQuantity) {
		this.proQuantity = proQuantity;
	}
	public Integer getProPassQuantity() {
		return proPassQuantity;
	}
	public void setProPassQuantity(Integer proPassQuantity) {
		this.proPassQuantity = proPassQuantity;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	
}
