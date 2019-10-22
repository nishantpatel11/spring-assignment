package com.nishu.bank.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.nishu.bank.model.BankAccount;
import com.nishu.bank.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository{


	static Map<Long,BankAccount> bankAccountMap = new HashMap<Long,BankAccount>();

	@Override
	public double getBalance(Long accountId) {

		if(bankAccountMap.containsKey(accountId))
			return bankAccountMap.get(accountId).getAccountBalance();

		return 0;
	}

	@Override
	public Boolean getUpdate(Long accountId, double newBalance) {

		if(bankAccountMap.containsKey(accountId)) {
			bankAccountMap.get(accountId).setAccountBalance(bankAccountMap.get(accountId).getAccountBalance()+newBalance);
			return true;
		}
		return false;
	}

	@Override
	public Boolean createBankAccount(BankAccount bankAccount) {

		if(bankAccount!=null) {
			bankAccount = bankAccountMap.putIfAbsent(bankAccount.getAccountId(), bankAccount);
			if(bankAccount!=null)
				return true;
			else
				return false;
		}

		return false;
	}

	@Override
	public double withdraw(Long accountId, double balance) {

		if(bankAccountMap.containsKey(accountId)) {
			if((bankAccountMap.get(accountId).getAccountBalance() - balance ) >= 0)
				return bankAccountMap.get(accountId).getAccountBalance()- balance;
			else
				return 0;
		}
		return 0;
	}

}
