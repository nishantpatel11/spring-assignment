package com.nishu.bank.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DemoBean implements InitializingBean, DisposableBean{
	
	public void customInit(){
		
		System.out.println("Method customInit() invoked...");
	}

	public void customDestroy(){
		
		System.out.println("Method customDestroy() invoked...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Method Destory is Called");		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
