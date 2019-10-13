package com.drug.entity;

public class MainRole {
	private Integer roleId; 
	private String roleName; 
	private String roleDesc;   
	private String roleState; 
	private Integer deptId;
	private MainDepartment dept;
	
	/*
	 * public String getDeptName() { return dept.getDeptName(); }
	 */
	
	public MainDepartment getDept() {
		return dept;
	}
	public void setDept(MainDepartment dept) {
		this.dept = dept;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleState() {
		return roleState;
	}
	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	
}
