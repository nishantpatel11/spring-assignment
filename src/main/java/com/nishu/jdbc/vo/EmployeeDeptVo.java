package com.nishu.jdbc.vo;

import java.time.LocalDateTime;

public class EmployeeDeptVo {

	private Integer empId;
	private String empName;
	private String empJobId;
	private Double salary;
	private LocalDateTime empHireDate;	
	private Integer deptId;
	private String deptName;
	private Integer managerId;
	
	public EmployeeDeptVo() {
		super();
	}
	
	public EmployeeDeptVo(Integer empId, String empName, String empJobId, Double salary, LocalDateTime empHireDate,
			Integer deptId, String deptName, Integer managerId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empJobId = empJobId;
		this.salary = salary;
		this.empHireDate = empHireDate;
		this.deptId = deptId;
		this.deptName = deptName;
		this.managerId = managerId;
	}
	/**
	 * @return the empId
	 */
	public Integer getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the empJobId
	 */
	public String getEmpJobId() {
		return empJobId;
	}
	/**
	 * @param empJobId the empJobId to set
	 */
	public void setEmpJobId(String empJobId) {
		this.empJobId = empJobId;
	}
	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	/**
	 * @return the empHireDate
	 */
	public LocalDateTime getEmpHireDate() {
		return empHireDate;
	}
	/**
	 * @param empHireDate the empHireDate to set
	 */
	public void setEmpHireDate(LocalDateTime empHireDate) {
		this.empHireDate = empHireDate;
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
		return "EmployeeDeptVo [empId=" + empId + ", empName=" + empName + ", empJobId=" + empJobId + ", salary="
				+ salary + ", empHireDate=" + empHireDate + ", deptId=" + deptId + ", deptName=" + deptName
				+ ", managerId=" + managerId + "]";
	}
	
}
