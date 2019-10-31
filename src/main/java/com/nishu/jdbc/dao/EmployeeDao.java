package com.nishu.jdbc.dao;

import javax.sql.DataSource;

public interface EmployeeDao {

	
	
	
	
	public static final String findDetailsOfAllEmployeeByDeptId = "select emp_id, name, emp_job_id, salary, emp_hire_date from employee where dept_id = ?"; 
	
	public static final String findAllEmployeeByEmpId = "select * from employee where emp_id = ?"; 
	
	public static final String findEmpNameJobIdAndSalary = "select name, emp_job_id, salary  from employee where emp_job_id in ('sales representative','stock clerk') and salary >= 5000 and salary <= 13000 order by name"; 
	
	public static final String findEmployeeMaxSalaryByDeptId = "select name, salary from employee where salary = ("
			+ "select max(salary) from employee where dept_id = ?)";
	
	public static final String findDepartmentAndEmployeeDetails = "select emp_id, name salary from employee order by dept_id";
	
	
	
	public static final String findEmployeeAndDepartment = "select emp.emp_id emp_id, emp.name name, emp.salary salary, dept.dept_name dept_name from"
			+ "employee emp inner join department dept on dept.dept_id = emp.dept_id";
	
	
	
	public void setDataSource(DataSource ds);

	
}
