package com.nishu.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishu.bank.model.BankAccount;
import com.nishu.bank.repository.BankAccountRepository;
import com.nishu.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{


//	@Autowired
	private BankAccount bankAccount;

	@Autowired
	private BankAccountRepository bankAccountRepository;


	@Override
	public double withdraw(long accountId, double balance) {
		return bankAccountRepository.withdraw(accountId, balance);
	}

	@Override
	public Boolean deposit(long accountId, double balance) {
		return bankAccountRepository.getUpdate(accountId, balance);
	}

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public Boolean fundTransfer(long fromAccount, long toAccount, double balance) {
		double  amt = bankAccountRepository.withdraw(fromAccount, balance);
		if(amt==balance) {
			bankAccountRepository.getUpdate(toAccount, balance);
			return true;
		}
		return false;
	}

	@Override
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	@Override
	public Boolean createBankAccount(BankAccount bankAccount) {
		return bankAccountRepository.createBankAccount(bankAccount);
	}


}
