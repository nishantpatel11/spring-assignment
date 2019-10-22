package com.nishu.bank.service.impl;

import org.springframework.stereotype.Service;

import com.nishu.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Override
	public double withdraw(long accountId, double balance) {
		return 0;
	}

	@Override
	public double deposit(long accountId, double balance) {
		return 0;
	}

	@Override
	public double getBalance(long accountId) {
		return 5.7;
	}

	@Override
	public double fundTransfer(long fromAccount, long toAccount, double balance) {
		return 0;
	}

}
