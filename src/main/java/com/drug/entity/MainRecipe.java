package com.drug.entity;

public class MainRecipe {

	private Integer recipeId;
	private String recipeName;
	private String createTime;
	private Integer empId;
	private String recipeDesc;
	private String recipeState;
	private Integer proId;
	private String empName;
	
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getRecipeDesc() {
		return recipeDesc;
	}
	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc = recipeDesc;
	}
	public String getRecipeState() {
		return recipeState;
	}
	public void setRecipeState(String recipeState) {
		this.recipeState = recipeState;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}
