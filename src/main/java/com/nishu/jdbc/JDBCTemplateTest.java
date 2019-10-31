package com.nishu.jdbc;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.jdbc.beans.Employee;
import com.nishu.jdbc.service.EmployeeService;

public class JDBCTemplateTest {

	public static void main(String [] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");

		//Get the EmployeeDAO Bean
		EmployeeService employeeDAO = ctx.getBean("employeeService", EmployeeService.class);

		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setEmpId(rand);
		emp.setEmpName("Nishant");

		//Create
		employeeDAO.createEmployee(emp);

		//Read
		Employee emp1 = employeeDAO.getById(rand);
		System.out.println("Employee Retrieved::"+emp1);

//		//Update
		emp.setEmpId(336);
		emp.setSalary(4500.0);
		emp.setEmpName("Nitish");
		System.out.println("Record update of "+employeeDAO.update(emp)+" this id");

		//Get All
		List<Employee> empList = employeeDAO.getEmployeeAll();
		System.out.println(empList);
//
//		//Delete
		employeeDAO.deleteById(rand);
		System.out.println("Number of record is deleted is"+employeeDAO.deleteAll());

		//Close Spring Context
		ctx.close();

		System.out.println("DONE");
	}
}
