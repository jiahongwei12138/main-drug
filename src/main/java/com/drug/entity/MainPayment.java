package com.drug.entity;

/**
 * @author hhy
 *	描述：收款单
 */
public class MainPayment {
	private Integer Payment_id;
	private String Payment_name;
	private String Payment_time;
	private double Payment_amount;
	private double Payment_TAmount;
	private Integer Payment_planId;
	
	public Integer getPayment_planId() {
		return Payment_planId;
	}
	public void setPayment_planId(Integer payment_planId) {
		Payment_planId = payment_planId;
	}
	public Integer getPayment_id() {
		return Payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		Payment_id = payment_id;
	}
	public String getPayment_name() {
		return Payment_name;
	}
	public void setPayment_name(String payment_name) {
		Payment_name = payment_name;
	}
	public String getPayment_time() {
		return Payment_time;
	}
	public void setPayment_time(String payment_time) {
		Payment_time = payment_time;
	}
	public double getPayment_amount() {
		return Payment_amount;
	}
	public void setPayment_amount(double payment_amount) {
		Payment_amount = payment_amount;
	}
	public double getPayment_TAmount() {
		return Payment_TAmount;
	}
	public void setPayment_TAmount(double payment_TAmount) {
		Payment_TAmount = payment_TAmount;
	}
	
	
}
