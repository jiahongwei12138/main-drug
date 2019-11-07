package com.drug.entity;
/**
 * 
 * @ClassName: MainRawMaterial 
 * @Description: 原材料实体类 
 * @author lxl
 * @date 2019年10月22日
 *
 */
public class MainRawMaterial {
	private Integer rawMaterialId;
	private String rawMaterialName;
	private String rawMaterialStandard;
	private String rawMaterialUnit;
	private double rawMaterialUnitPrice;
	public Integer getRawMaterialId() {
		return rawMaterialId;
	}
	public void setRawMaterialId(Integer rawMaterialId) {
		this.rawMaterialId = rawMaterialId;
	}
	public String getRawMaterialName() {
		return rawMaterialName;
	}
	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}
	public String getRawMaterialStandard() {
		return rawMaterialStandard;
	}
	public void setRawMaterialStandard(String rawMaterialStandard) {
		this.rawMaterialStandard = rawMaterialStandard;
	}
	public String getRawMaterialUnit() {
		return rawMaterialUnit;
	}
	public void setRawMaterialUnit(String rawMaterialUnit) {
		this.rawMaterialUnit = rawMaterialUnit;
	}
	public double getRawMaterialUnitPrice() {
		return rawMaterialUnitPrice;
	}
	public void setRawMaterialUnitPrice(double rawMaterialUnitPrice) {
		this.rawMaterialUnitPrice = rawMaterialUnitPrice;
	}
	
	
}
