package com.drug.entity;

/**
 * 
 * @author hhy
 *	描述：销售收入表
 */
public class MainMarket {
	private Integer market_id;//销售收入idd
	private String market_name;//操作人
	private String market_time;//操作时间
	private double market_amount;//预计金额
	private double market_TAmount;//实际金额
	private String market_aaa;//预留字段
	
	public Integer getMarket_id() {
		return market_id;
	}
	public void setMarket_id(Integer market_id) {
		this.market_id = market_id;
	}
	public String getMarket_name() {
		return market_name;
	}
	public void setMarket_name(String market_name) {
		this.market_name = market_name;
	}
	public String getMarket_time() {
		return market_time;
	}
	public void setMarket_time(String market_time) {
		this.market_time = market_time;
	}
	public double getMarket_amount() {
		return market_amount;
	}
	public void setMarket_amount(double market_amount) {
		this.market_amount = market_amount;
	}
	public double getMarket_TAmount() {
		return market_TAmount;
	}
	public void setMarket_TAmount(double market_TAmount) {
		this.market_TAmount = market_TAmount;
	}
	public String getMarket_aaa() {
		return market_aaa;
	}
	public void setMarket_aaa(String market_aaa) {
		this.market_aaa = market_aaa;
	}
	
	
}
