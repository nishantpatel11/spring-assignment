package com.nishu.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.model.Address;
import com.nishu.bank.model.Customer;
import com.nishu.bank.model.Question;
import com.nishu.bank.service.AddressService;
import com.nishu.bank.service.CustomerService;


public class Application {


	public static void main(String[] args) {


		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
				

			CustomerService customerService = context.getBean(CustomerService.class);
			Customer customer = customerService.create(); 
			System.out.println(customer);


			AddressService addressService = context.getBean(AddressService.class);
			Address address = addressService.create();
			System.out.println(address);

			
			Question question = (Question) context.getBean("question");
			System.out.println(question);
			
	}
}
