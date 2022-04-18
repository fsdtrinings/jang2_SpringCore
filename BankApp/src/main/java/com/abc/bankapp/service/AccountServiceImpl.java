package com.abc.bankapp.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bankapp.entity.Account;
import com.abc.bankapp.entity.Transaction;
import com.abc.bankapp.entity.UserDetails;
import com.abc.bankapp.exceptions.InsufficientFundException;
import com.abc.bankapp.exceptions.InvalidAccountNumberException;
import com.abc.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {


	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logout(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserDetails(String username, UserDetails newUserDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBalance(int accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int depositAmount(int accountNumber, int balance) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doFundTransfer(int accountNumber, int transferTo, int amount)
			throws InvalidAccountNumberException, InsufficientFundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transaction> getTransactionBasedOnAccountNumber(int accountNumber)
			throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getTransactionBasedOnAccountNumber(int accountNumber, LocalDate d1, LocalDate d2)
			throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}

	@Override
	public boolean insertAccount(Account a) {
		Account savedObject = accountRepository.save(a);
		
		return savedObject!=null?true:false;
	}

	@Override
	public Account getAccount(int accountNumber) {
		
		return accountRepository.findById(accountNumber).get();
	}


	
}













