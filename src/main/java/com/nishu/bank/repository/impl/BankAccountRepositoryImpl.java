package com.nishu.bank.repository.impl;

import org.springframework.stereotype.Repository;

import com.nishu.bank.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository{

	@Override
	public double getBalance(Long accountId) {
		return 0;
	}

	@Override
	public double getUpdate(Long accountId, double newBalance) {
		return 0;
	}

}
