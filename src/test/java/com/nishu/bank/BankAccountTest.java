package com.nishu.bank;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.model.BankAccount;
import com.nishu.bank.model.Customer;
import com.nishu.bank.repository.BankAccountRepository;
import com.nishu.bank.service.BankAccountService;
import com.nishu.bank.service.CustomerService;

public class BankAccountTest {

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
	public void TestBankAccount() {


		BankAccount bankAccount = context.getBean(BankAccount.class);
		assertNotNull(bankAccount);

		
	}

	
	@Test
	public void testBankAccountRepository() {


		BankAccountRepository bankAccountRepository = context.getBean(BankAccountRepository.class);
		assertNotNull(bankAccountRepository);
	}

	
	@Test
	public void testBankAccountService() {

		BankAccountService bankAccountService = context.getBean(BankAccountService.class);
		assertNotNull(bankAccountService);
	}

}
