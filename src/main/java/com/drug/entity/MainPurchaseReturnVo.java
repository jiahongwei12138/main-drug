package com.drug.entity;

public class MainPurchaseReturnVo extends MainPurchaseReturn{
       private Integer page;
       private Integer limit;
       
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
       
}
