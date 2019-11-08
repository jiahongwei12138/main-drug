package com.drug.entity;

/**
 * @author hhy
 *	描述：销售退货支出表
 */
public class MainFisca {
	private Integer Fiscal_Id;//销售退货收入id//
	private String Fiscal_name;//操作人
	private String Fiscal_time;//操作时间
	private double Fiscal_amount;//支出金额
	private String Fiscal_aaa;//预留字段
	
	public Integer getFiscal_Id() {
		return Fiscal_Id;
	}
	public void setFiscal_Id(Integer fiscal_Id) {
		Fiscal_Id = fiscal_Id;
	}
	public String getFiscal_name() {
		return Fiscal_name;
	}
	public void setFiscal_name(String fiscal_name) {
		Fiscal_name = fiscal_name;
	}
	public String getFiscal_time() {
		return Fiscal_time;
	}
	public void setFiscal_time(String fiscal_time) {
		Fiscal_time = fiscal_time;
	}
	public double getFiscal_amount() {
		return Fiscal_amount;
	}
	public void setFiscal_amount(double fiscal_amount) {
		Fiscal_amount = fiscal_amount;
	}
	public String getFiscal_aaa() {
		return Fiscal_aaa;
	}
	public void setFiscal_aaa(String fiscal_aaa) {
		Fiscal_aaa = fiscal_aaa;
	}
	
	
}
