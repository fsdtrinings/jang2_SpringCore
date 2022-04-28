package com.abc.bankapp.sort;

import java.util.Comparator;

import com.abc.bankapp.entity.Account;

public class AccountBalanceHighToLow implements Comparator<Account> {

	@Override
	public int compare(Account a1, Account a2) {

		return a1.getBalance() - a2.getBalance();
	}
	
	

}
