package com.nishu.bank.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BankAccountAspect {

	@Before("execution(public String getAccountHolderName())")
	public void getNameAdvice(){
		System.out.println("Executing Advice on getAccountHolderName()");
	}
	
	@Before("execution(* com.nishu.bank.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");
	}
}
