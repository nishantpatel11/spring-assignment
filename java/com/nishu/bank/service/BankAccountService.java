package com.nishu.bank.service;

public interface BankAccountService {

	public double withdraw(long accountId,double balance);
	public double deposit(long accountId,double balance);
	public double getBalance(long accountId);
	public double fundTransfer(long fromAccount,long toAccount,double balance);

}
