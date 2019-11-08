package com.drug.entity;

public class MainLog {
	private Integer logId; 
	private String dateTimes;      
	private String thread;        
	private String levels; 
	private String notes;
	private String empName;
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public String getDateTimes() {
		return dateTimes;
	}
	public void setDateTimes(String dateTimes) {
		this.dateTimes = dateTimes;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	} 
	
}
