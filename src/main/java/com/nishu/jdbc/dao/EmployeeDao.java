package com.nishu.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.nishu.jdbc.beans.Employee;

public interface EmployeeDao {

	public void setDataSource(DataSource ds);

	public Integer createEmployee(Employee employee);

	public Employee getById(int id);
	
	public Integer update(Employee employee);
	
	public Integer deleteById(int id);
	
	public Employee select(Integer empId, String name);

	public List<Employee> getEmployeeAll();

	public Integer deleteAll();

	public Integer delete(Integer empId, String name);
	
}
