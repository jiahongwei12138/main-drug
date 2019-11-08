package com.drug.entity;

/**
 * @author hhy
 *	描述：采购退货收入表
 */
public class MainSales {
	private Integer Sales_id;//采购退货收入id
	private String sales_name;//操作人
	private String sales_time;//操作时间
	private double sales_audit;//预计金额
	private double seles_amount;//实际金额
	private Integer seles_returnId;//采购退货id
	private String sales_aaa;//预留字段
	
	public Integer getSales_id() {
		return Sales_id;
	}
	public void setSales_id(Integer sales_id) {
		Sales_id = sales_id;
	}
	public String getSales_name() {
		return sales_name;
	}
	public void setSales_name(String sales_name) {
		this.sales_name = sales_name;
	}
	public String getSales_time() {
		return sales_time;
	}
	public void setSales_time(String sales_time) {
		this.sales_time = sales_time;
	}
	public double getSales_audit() {
		return sales_audit;
	}
	public void setSales_audit(double sales_audit) {
		this.sales_audit = sales_audit;
	}
	public double getSeles_amount() {
		return seles_amount;
	}
	public void setSeles_amount(double seles_amount) {
		this.seles_amount = seles_amount;
	}
	public Integer getSeles_returnId() {
		return seles_returnId;
	}
	public void setSeles_returnId(Integer seles_returnId) {
		this.seles_returnId = seles_returnId;
	}
	public String getSales_aaa() {
		return sales_aaa;
	}
	public void setSales_aaa(String sales_aaa) {
		this.sales_aaa = sales_aaa;
	}
	
	
}
