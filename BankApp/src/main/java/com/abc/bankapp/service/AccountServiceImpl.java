package com.abc.bankapp.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bankapp.entity.Account;
import com.abc.bankapp.entity.Transaction;
import com.abc.bankapp.entity.UserDetails;
import com.abc.bankapp.exceptions.InsufficientFundException;
import com.abc.bankapp.exceptions.InvalidAccountNumberException;
import com.abc.bankapp.exceptions.InvalidUserExcption;
import com.abc.bankapp.repository.AccountRepository;
import com.abc.bankapp.sort.AccountBalanceHighToLow;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public String login(String username, String password) throws InvalidUserExcption {

		String role = accountRepository.verifyUser(username, password);
		return role;
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
	public List<Account> getAllAccountsByBalanceHtoL() {

		List<Account> accounts = getAllAccounts();
		Collections.sort(accounts, new AccountBalanceHighToLow());
		return accounts;
	}

	
	@Override
	@Transactional
	public boolean insertAccount(Account a) {
		Account savedObject = accountRepository.save(a);

		return savedObject != null ? true : false;
	}

	@Override
	public Account getAccount(int accountNumber) throws InvalidAccountNumberException {
		try {
			System.out.println(" ------->> 1 before findById call");
			Account returnedAccount = accountRepository.findById(accountNumber).get();
			System.out.println(
					"----->> 2 Inside ServiceIMPL class getAccountById returned Account is " + returnedAccount);
			return returnedAccount;
		} catch (java.util.NoSuchElementException e) {
			System.out.println("---->>2 inside CATCH block of ServiceImpl class ");
			throw new InvalidAccountNumberException(accountNumber, e.getMessage());
		}

	}

	@Override
	@Transactional
	public boolean doDeposite(int amount, int accountId) throws InvalidAccountNumberException {

		try {
			Account a = accountRepository.findById(accountId).get();

			if (a != null) {
				// code to update balance;
				a.setBalance(a.getBalance() + amount);
				return true;
			}
			else {
				throw new NoSuchElementException();
			}
			
		} catch (java.util.NoSuchElementException e) {
			System.out.println("---->>2 inside CATCH block of ServiceImpl class ");
			throw new InvalidAccountNumberException(accountId, e.getMessage());
		}
		
	}

}// end of class
