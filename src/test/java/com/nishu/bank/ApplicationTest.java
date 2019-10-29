package com.nishu.bank;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	public  void tearDown() throws Exception {
		context.close();
		assertArrayEquals("hello", new long[] {1l,2l,3l,4l}, new long[] {1l,2l,3l,4l});
	}
	
//	@AfterClass
//	public  void tearDown() throws Exception {
//		context.close();
//	}

	
	@Test
	public void test() {
		
		assertArrayEquals("hello", new long[] {1l,2l,3l,4l}, new long[] {1l,2l,3l,4l});
	}
	
//	@BeforeClass
//	public static  void setup() {
//		context = new ClassPathXmlApplicationContext("beans.xml");
//
//	}
	
	
	@Test
	@Ignore
	public void Test() {


		CustomerService customerService = context.getBean(CustomerService.class);
		Customer customer = customerService.create(); 
		assertNotNull(customer);
	}


	@Test
	@Ignore
	public void addressTest() {
		AddressService addressService = context.getBean(AddressService.class);
		Address address = addressService.create();
		assertNotNull(address);
	}

	@Test
	@Ignore
	public void questionTest() {
		Question question = (Question) context.getBean("question");
		assertNotNull(question);
		System.out.println("Question :"+question.getQuestion());
		System.out.println("Answer List :"+question.getAnswerList());
		System.out.println("Answer Map :"+question.getAnswerMap());
		System.out.println("Answer Set :"+question.getAnswerSet());
	}
}
