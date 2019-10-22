package com.nishu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishu.service.HomeService;

@RestController
@RequestMapping("/")
public class HelloController {

	@Autowired
	private HomeService helloSerivce;
	
	
	@GetMapping("hello")
	public String greet() {
		return helloSerivce.sayHello("Hello");
	}
}