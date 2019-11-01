package com.nishu.poxy;

import com.nishu.poxy.service.Internet;
import com.nishu.poxy.service.impl.ProxyInternet;

public class ClientTest {

	public static void main(String[] args) {

		Internet internet = new ProxyInternet(); 
        try{
        	
            internet.connectTo("nishu.org"); 
            internet.connectTo("nishu.com"); 
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 
	}

}
