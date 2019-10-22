package com.nishu.bank.service.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nishu.bank.service.BankAccountService;


@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService; 

	@GetMapping("/")
	public ResponseEntity getBankAccount() {
		return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.getBankAccount()+"");
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity getBalance(@PathVariable (name = "accountId") Long accountId ) {
		return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.getBalance(accountId)+"");
	}
	
	
	@GetMapping("/{accountId}/{balance}")
	public ResponseEntity deposit(@PathVariable (name = "accountId") Long accountId ,@PathVariable (name = "balance") Long balance ) {
		return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.deposit(accountId, balance)+"");
	}
	
	@PostMapping("/")
	public ResponseEntity withdraw(@RequestBody Map<String,Object> params ) {
		
		long accountId = params!=null ? params.containsKey("accountId") ? (Long) params.get("accountId") : 0 : 0;
		double balance = params!=null ? params.containsKey("balance") ? (Long) params.get("balance") : 0 : 0;
		return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.withdraw(accountId, balance)+"");
	}
	
	@PostMapping("/fund-transfer")
	public ResponseEntity fundTransfer(@RequestBody Map<String,Object> params) {
		
		
		long fromAccount = params!=null ? params.containsKey("fromAccount") ? (Long) params.get("fromAccount") : 0 : 0;
		long toAccount = params!=null ? params.containsKey("toAccount") ? (Long) params.get("toAccount") : 0 : 0;
		double balance = params!=null ? params.containsKey("balance") ? (Long) params.get("balance") : 0 : 0;
		return ResponseEntity.status(HttpStatus.OK).body(bankAccountService.fundTransfer(fromAccount, toAccount, balance)+"");
	}
	
}
