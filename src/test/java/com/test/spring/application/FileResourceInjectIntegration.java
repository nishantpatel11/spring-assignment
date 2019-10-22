//package com.test.spring.application;
//
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.nishu.bank.model.BankAccount;
//import com.nishu.bank.service.BankAccountService;
//import com.test.spring.application.config.BankAccountServiceTestConfig;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {BankAccountServiceTestConfig.class})
//public class FileResourceInjectIntegration {
//
//
//	@Autowired
//	private BankAccountService bankAccountService;
//
//	@Autowired
//	public void setProductService(BankAccountService bankAccountService) {
//		this.bankAccountService = bankAccountService;
//	}
//
//
//	@Test
//	public void testBankAccountService(){
//		BankAccount bankAccount = bankAccountService.getBankAccount();
//		assertNotNull(bankAccount);
//	}
//
//}
