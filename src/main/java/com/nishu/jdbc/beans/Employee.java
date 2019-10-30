package com.nishu.jdbc.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author nishu
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3181938249698830340L;

	private Integer empId;
	private String empName;
	private LocalDateTime empHireDate;
	private String empJobId;
	private Double salary;
	private Department dept;
	
	/**
	 * 
	 */
	public Employee() {
		super();
	}

	
	/**
	 * @param empId
	 * @param empName
	 * @param empHireDate
	 * @param empJobId
	 * @param salary
	 * @param dept
	 */
	public Employee(Integer empId, String empName, LocalDateTime empHireDate, String empJobId, Double salary,
			Department dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empHireDate = empHireDate;
		this.empJobId = empJobId;
		this.salary = salary;
		this.dept = dept;
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
	 * @return the dept
	 */
	public Department getDept() {
		return dept;
	}


	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empHireDate=" + empHireDate + ", empJobId="
				+ empJobId + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
}
