package com.nishu.jdbc;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.jdbc.beans.Employee;
import com.nishu.jdbc.dao.EmployeeDao;

public class JDBCTemplateTest {

	public static void main(String [] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");

		//Get the EmployeeDAO Bean
		EmployeeDao employeeDAO = ctx.getBean("employeeDAO", EmployeeDao.class);

		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setEmpId(rand);
		emp.setEmpName("Nishant");

		//Create
//		employeeDAO.createEmployee(emp);

		//Read
		Employee emp1 = employeeDAO.getById(269);
		System.out.println("Employee Retrieved::"+emp1);

//		//Update
		emp.setEmpId(336);
		emp.setSalary(4500.0);
		emp.setEmpName("Nitish");
//		employeeDAO.update(emp);

		//Get All
		List<Employee> empList = employeeDAO.getEmployeeAll();
		System.out.println(empList);
//
//		//Delete
//		employeeDAO.deleteById(rand);

		//Close Spring Context
		ctx.close();

		System.out.println("DONE");
	}
}
