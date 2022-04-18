package com.abc.bankapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bankapp.entity.Account;
import com.abc.bankapp.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountRestController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> doThis()
	{
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/account/{accountNumber}")
	public Account getAccountThroughWebID(@PathVariable int accountNumber)
	{
		return accountService.getAccount(accountNumber);
	}
	
	
	
	@PostMapping("/account") //post :-  localhost:8080/bank/account
	public String savedAccountFromWeb(@RequestBody Account a)
	{
		boolean status = accountService.insertAccount(a);
	
		return status == true?"Account Saved ":"Contact to customer Care";
	}
	
}
