package com.nishu.contextware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nishu.contextware.bean.Triangle;

public class DrawingApp {
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
	}
}
