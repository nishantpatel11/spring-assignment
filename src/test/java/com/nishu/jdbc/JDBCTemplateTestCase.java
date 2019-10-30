package com.nishu.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.jdbc.beans.Employee;
import com.nishu.jdbc.dao.EmployeeDao;

public class JDBCTemplateTestCase {


	ClassPathXmlApplicationContext context = null;
	EmployeeDao employeeDAO = null;
	static int empId = new Random().nextInt(1000);

	@Before
	@Test
	public void setUp() throws Exception {

		context = new ClassPathXmlApplicationContext("spring-bean.xml");
		assertNotNull(context);
		employeeDAO = context.getBean("employeeDAO", EmployeeDao.class);
		assertNotNull(employeeDAO);

	}

	@After
	@Test
	public void tearDown() throws Exception {

		employeeDAO=null;
		assertNull(employeeDAO);
		context.close();
	}


	@Test
	public void employeeCreationTest() {

		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName("Nishant");

		Integer employeeId = employeeDAO.createEmployee(emp);
		assertNotNull(employeeId);
	}



	@Test
	public void getInfoByEmpIdTest() {

		Employee emp1 = employeeDAO.getById(336);
		System.out.println("Employee Retrieved::"+emp1);

	}

	@Test
	public void updateEmpoyeeTest() {

		Employee emp = employeeDAO.getById(336);
		emp.setEmpId(336);
		emp.setSalary(4500.0);
		emp.setEmpName("Nitish");
		Integer employeeId = employeeDAO.update(emp);
		assertNotNull(employeeId);
	}

	@Test
	public void deleteEmployeeByIdTest() {

		Integer employeeId = employeeDAO.deleteById(373);
		assertNotNull(employeeId);
	}




}
