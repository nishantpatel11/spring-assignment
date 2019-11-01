package com.nishu.bank;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.service.BankAccountService;

public class BankAccountImplTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bank-beans.xml");
		
		BankAccountService bankAccountService = ctx.getBean("bankAccountService", BankAccountService.class);
		System.out.println(bankAccountService.getBankAccount().getAccountHolderName());
		bankAccountService.getBankAccount().setAccountHolderName("Nitish");
		bankAccountService.getBankAccount().throwException();

		ctx.close();

	}

}
