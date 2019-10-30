package com.nishu.jdbc.beans;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1588172363026610908L;

	
	private Integer deptId;
	private String deptName;
	private Integer managerId;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer deptId, String deptName, Integer managerId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.managerId = managerId;
	}
	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * @return the managerId
	 */
	public Integer getManagerId() {
		return managerId;
	}
	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", managerId=" + managerId + "]";
	}

}
