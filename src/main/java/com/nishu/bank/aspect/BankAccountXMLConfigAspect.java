package com.nishu.bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class BankAccountXMLConfigAspect {

	public Object bankAccountAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("BankAccountXMLConfigAspect:: Before invoking getAccountName() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("BankAccountXMLConfigAspect:: After invoking getAccountName() method. Return value="+value);
		return value;
	}
}
