package com.nishu.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.nishu.jdbc.beans.Employee;

public interface EmployeeDao {

	public void setDataSource(DataSource ds);

	public void createEmployee(Employee employee);

	public Employee getById(int id);
	
	public void update(Employee employee);
	
	public void deleteById(int id);
	
	public List<Employee> select(Integer empId, String name);

	public List<Employee> getEmployeeAll();

	public void deleteAll();

	public void delete(Integer empId, String name);
	
}
