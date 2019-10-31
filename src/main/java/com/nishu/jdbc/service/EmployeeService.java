package com.nishu.jdbc.service;

import java.util.List;

import javax.sql.DataSource;

import com.nishu.jdbc.beans.Employee;

public interface EmployeeService {
	
	public void setDataSource(DataSource ds);

	public Integer createEmployee(Employee employee);

	public Employee getById(int id);
	
	public Integer update(Employee employee);
	
	public Integer deleteById(int id);
	
	public Employee selectAll(Integer empId, String name);

	public List<Employee> getEmployeeAll();

	public Integer deleteAll();

	public Integer delete(Integer empId, String name);

	public List<Employee> getEmployeeDetailsByEmpId(Integer empId);
	
	public List<Employee> getEmployeeDetailsByDeptId(Integer deptId);

	public List<Employee> getEmployeeMaxSalary();
	
	public List<Employee> getEmployeeMaxSalaryByDeptId(Integer deptId);
	
	public List<Employee> getEmployeeDepartment();
	
	public List<Employee> getAllEmployeeByDeptId(Integer deptId);
		
}
