package com.nishu.bank.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.model.Address;
import com.nishu.bank.service.AddressService;

public class AddressServiceImpl implements AddressService {

	@Override
	public Address create() {
		return (Address) new ClassPathXmlApplicationContext("Spring-Module.xml").getBean("address");
	}

}
