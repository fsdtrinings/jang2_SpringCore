package com.abc.bankapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bankapp.dto.AccountResponseDTOAdmin;
import com.abc.bankapp.dto.AccountResponseDTOClient;
import com.abc.bankapp.entity.Account;
import com.abc.bankapp.service.AccountService;
import com.abc.bankapp.util.AccountToAccountDTOConvertion;

@RestController
@RequestMapping("/bank")
public class AccountRestController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/admin/accounts")
	public List<Account> doThis()
	{
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/client/account/{accountNumber}")
	public ResponseEntity<AccountResponseDTOClient> getAcountForClientbasedOnId(@PathVariable int accountNumber)
	{
		Account fetchedAccount = accountService.getAccount(accountNumber);
		
		AccountResponseDTOClient dtoObj = new AccountResponseDTOClient();//empty object
		if(fetchedAccount != null)
		{
		  dtoObj = AccountToAccountDTOConvertion.doDTOCLientConvertion(fetchedAccount);
		}
		return new ResponseEntity<AccountResponseDTOClient>(dtoObj,HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/account/{accountNumber}")
	public ResponseEntity<AccountResponseDTOAdmin> getAcountForAdminbasedOnId(@PathVariable int accountNumber)
	{
		Account fetchedAccount = accountService.getAccount(accountNumber);
		
		AccountResponseDTOAdmin dtoObj = new AccountResponseDTOAdmin();//empty object
		if(fetchedAccount != null)
		{
		  dtoObj = AccountToAccountDTOConvertion.doDTOAdminConvertion(fetchedAccount);
		}
		return new ResponseEntity<AccountResponseDTOAdmin>(dtoObj,HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/account") //post :-  localhost:8080/bank/account
	public String savedAccountFromWeb(@RequestBody Account a)
	{
		boolean status = accountService.insertAccount(a);
	
		return status == true?"Account Saved ":"Contact to customer Care";
	}
	
	
	
	
}
