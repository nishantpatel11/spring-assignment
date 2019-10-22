package com.nishu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishu.bank.service.BankAccountService;


@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankAccountService bankAccountService;

	@GetMapping("/balance")
	public String getBalance() {
		return bankAccountService.getBalance(123455l)+"";
	}
	
	@GetMapping("/balances")
	public ResponseEntity getBalances() {
		
//		ResponseEntity.accepted().body(bankAccountService.getBalance(123455l));
		return ResponseEntity.status(HttpStatus.OK).body(" Balance is :"+bankAccountService.getBalance(123455l));
//		return bankAccountService.getBalance(123455l)+"";
	}
}
