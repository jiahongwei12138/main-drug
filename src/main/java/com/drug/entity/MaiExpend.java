package com.drug.entity;

/**
 * 
 * @author hhy
 *	描述：采购支出表
 */
public class MaiExpend {
	private Integer expend_id;//采购支出表id
	private String expend_name;//操作人
	private String expend_time;//操作时间
	private double expend_amount;//预计金额
	private double expend_Tamount;//实际金额
	private Integer expend_planId;//采购订单id
	private String expend_aaa;//预留字段
	
	public Integer getExpend_id() {
		return expend_id;
	}
	public void setExpend_id(Integer expend_id) {
		this.expend_id = expend_id;
	}
	public String getExpend_name() {
		return expend_name;
	}
	public void setExpend_name(String expend_name) {
		this.expend_name = expend_name;
	}
	public String getExpend_time() {
		return expend_time;
	}
	public void setExpend_time(String expend_time) {
		this.expend_time = expend_time;
	}
	public double getExpend_amount() {
		return expend_amount;
	}
	public void setExpend_amount(double expend_amount) {
		this.expend_amount = expend_amount;
	}
	public double getExpend_Tamount() {
		return expend_Tamount;
	}
	public void setExpend_Tamount(double expend_Tamount) {
		this.expend_Tamount = expend_Tamount;
	}
	public Integer getExpend_planId() {
		return expend_planId;
	}
	public void setExpend_planId(Integer expend_planId) {
		this.expend_planId = expend_planId;
	}
	public String getExpend_aaa() {
		return expend_aaa;
	}
	public void setExpend_aaa(String expend_aaa) {
		this.expend_aaa = expend_aaa;
	}
	
}
