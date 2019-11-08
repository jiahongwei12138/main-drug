package com.drug.entity;
/**
 * 
 * @author bobo
 *
 */
public class MainProductionQuality {
	private int pqId; 					//主键
	private int poId; 					//日生产订单表id(外键)
	private String createDate; 			//订单生产日期
	private String piSTypeName = "生产质检入库";			//生产质检入库/退货质检入库
	private String sname = "成品1仓";				//仓库名
	private String qualitystatus; 			//质检状态
	private String checkstatus = "未审核"; 			//审核状态
	private int qualityInspector; 		//质检员,来自员工表Id(外键)
	private String qsData; 				//质检时间
	private String insrock = "未入库"; 				//入库状态
	private String visibles; 				//备注
	public int getPqId() {
		return pqId;
	}
	public void setPqId(int pqId) {
		this.pqId = pqId;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPiSTypeName() {
		return piSTypeName;
	}
	public void setPiSTypeName(String piSTypeName) {
		this.piSTypeName = piSTypeName;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getQualitystatus() {
		return qualitystatus;
	}
	public void setQualitystatus(String qualitystatus) {
		this.qualitystatus = qualitystatus;
	}
	public String getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}
	public int getQualityInspector() {
		return qualityInspector;
	}
	public void setQualityInspector(int qualityInspector) {
		this.qualityInspector = qualityInspector;
	}
	public String getQsData() {
		return qsData;
	}
	public void setQsData(String qsData) {
		this.qsData = qsData;
	}
	public String getInsrock() {
		return insrock;
	}
	public void setInsrock(String insrock) {
		this.insrock = insrock;
	}
	public String getVisibles() {
		return visibles;
	}
	public void setVisibles(String visibles) {
		this.visibles = visibles;
	}
	
	
}
