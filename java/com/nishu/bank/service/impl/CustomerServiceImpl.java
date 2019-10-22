package com.nishu.bank.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.model.Customer;
import com.nishu.bank.service.CustomerService;

//@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public Customer create() {
		return (Customer) new ClassPathXmlApplicationContext("Spring-Module.xml").getBean("customer");
	}

}
