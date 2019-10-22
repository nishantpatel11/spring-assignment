package com.nishu.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.bank.model.Address;
import com.nishu.bank.model.BankAccount;
import com.nishu.bank.model.Customer;
import com.nishu.bank.model.Question;
import com.nishu.bank.service.AddressService;
import com.nishu.bank.service.BankAccountService;
import com.nishu.bank.service.CustomerService;
import com.nishu.service.impl.EmployeeServiceImpl;


public class Application {


	public static void main(String[] args) {


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
				

			CustomerService customerService = context.getBean(CustomerService.class);
			Customer customer = customerService.create(); 
			System.out.println(customer);


			AddressService addressService = context.getBean(AddressService.class);
			Address address = addressService.create();
			System.out.println(address);

			
			Question question = (Question) context.getBean("question");
			System.out.println(question);

			BankAccountService bankAccountService = context.getBean(BankAccountService.class);
			BankAccount bankAccount = bankAccountService.getBankAccount();
			System.out.println(bankAccount);

			
			System.out.println("Spring Context initialized");
			
			EmployeeServiceImpl employeeService = context.getBean("employeeService",EmployeeServiceImpl.class);

			System.out.println("Bean retrieved from Spring Context");
			
			System.out.println("Employee Name="+employeeService.getEmployee().getName());
			
			context.close();;
			System.out.println("Spring Context Closed");
		
			
	}
}
