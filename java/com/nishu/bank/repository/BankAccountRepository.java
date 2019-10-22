package com.nishu.bank.repository;


public interface BankAccountRepository {

	public double getBalance(Long accountId);
	public double getUpdate(Long accountId, double newBalance);
}
