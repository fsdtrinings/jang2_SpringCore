package com.abc.bankapp.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.bankapp.entity.Account;
import com.abc.bankapp.entity.Transaction;
import com.abc.bankapp.entity.UserDetails;
import com.abc.bankapp.exceptions.InsufficientFundException;
import com.abc.bankapp.exceptions.InvalidAccountNumberException;
import com.abc.bankapp.exceptions.InvalidUserExcption;

@Service
public interface AccountService {
	
	/* provide username & password and get Role if verfied user else through Custom Exception InvalidUser*/
	public String login(String username,String password) throws InvalidUserExcption;

	public boolean logout(String username);
	
	/* update user details based on username set newUserDetails*/
	public boolean updateUserDetails(String username,UserDetails newUserDetails);
	
	/*return balance in DB based on accountNumber , throws CustomException InvalidAccountNumberException*/
	public int getBalance(int accountNumber)throws InvalidAccountNumberException;
	
	/*return new updated balance after deposite else throw exception incase accountNumber not found in the database*/
	public int depositAmount(int accountNumber,int balance)throws InvalidAccountNumberException;


	/* return updated balance after fund transfer , returns InvalidAccount number if 
	 *          a) accountNumber not in database
	 *          b) transferTo not in database
	 *  and raised InsufficientFundException if funds are insufficient*/
	public int doFundTransfer(int accountNumber,int transferTo,int amount)throws InvalidAccountNumberException,InsufficientFundException;

	/* method return the List of transactions made by accountNumber */
	public List<Transaction> getTransactionBasedOnAccountNumber(int accountNumber)throws InvalidAccountNumberException;
	public List<Transaction> getTransactionBasedOnAccountNumber(int accountNumber,LocalDate d1,LocalDate d2)throws InvalidAccountNumberException;
	
	public List<Account> getAllAccountsByBalanceHtoL();
	public List<Account> getAllAccounts();
	public boolean insertAccount(Account a);
	public Account getAccount(int accountNumber)throws InvalidAccountNumberException;
	public boolean doDeposite(int amount,int accountId)throws InvalidAccountNumberException;
	
	
}
