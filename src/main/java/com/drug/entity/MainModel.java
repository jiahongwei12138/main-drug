package com.drug.entity;

import java.util.ArrayList;
import java.util.List;

public class MainModel {

	private Integer id;//modelId  
	private String title;//modelName              
	private Integer parentModelId;  
	private String modelImg;               
	private String modelUrl;  
	private boolean spread=false;
	private boolean checked=false;
	private Integer menuType;
	private List<MainModel> children=new ArrayList<MainModel>();
	
	public List<MainModel> getChildren() {
		return children;
	}
	public void setChildren(List<MainModel> children) {
		this.children = children;
	}
	public boolean isSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getParentModelId() {
		return parentModelId;
	}
	public void setParentModelId(Integer parentModelId) {
		this.parentModelId = parentModelId;
	}
	public String getModelImg() {
		return modelImg;
	}
	public void setModelImg(String modelImg) {
		this.modelImg = modelImg;
	}
	public String getModelUrl() {
		return modelUrl;
	}
	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}
	public Integer getMenuType() {
		return menuType;
	}
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	
	
}
