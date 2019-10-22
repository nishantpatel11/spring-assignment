package com.nishu.bank.repository;

import com.nishu.bank.model.BankAccount;

public interface BankAccountRepository {

	public Boolean createBankAccount(BankAccount bankAccount);
	public double getBalance(Long accountId);
	public Boolean getUpdate(Long accountId, double newBalance);
	public double withdraw(Long accountId, double balance);
	
}
