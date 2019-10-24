package com.nishu.bank;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.model.Address;
import com.nishu.bank.model.Customer;
import com.nishu.bank.model.Question;
import com.nishu.bank.service.AddressService;
import com.nishu.bank.service.CustomerService;

public class ApplicationTest {

	ClassPathXmlApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("beans.xml");

	}

	@After
	public void tearDown() throws Exception {
		context.close();
	}

	
	@Test
	public void Test() {


		CustomerService customerService = context.getBean(CustomerService.class);
		Customer customer = customerService.create(); 
		assertNotNull(customer);
	}


	@Test
	public void addressTest() {
		AddressService addressService = context.getBean(AddressService.class);
		Address address = addressService.create();
		assertNotNull(address);
	}

	@Test	
	public void questionTest() {
		Question question = (Question) context.getBean("question");
		assertNotNull(question);
	}
}
