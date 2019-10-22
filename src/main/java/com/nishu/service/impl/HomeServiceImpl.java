package com.nishu.service.impl;

import org.springframework.stereotype.Service;

import com.nishu.service.HomeService;


@Service
public class HomeServiceImpl implements HomeService{

	@Override
	public String sayHello(String message) {
		return message;
	}

}
