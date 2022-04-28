package com.abc.bankapp.web;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bankapp.dto.AccountResponseDTOAdmin;
import com.abc.bankapp.dto.AccountResponseDTOClient;
import com.abc.bankapp.dto.LoginDTO;
import com.abc.bankapp.entity.Account;
import com.abc.bankapp.exceptions.InvalidAccountNumberException;
import com.abc.bankapp.exceptions.InvalidUserExcption;
import com.abc.bankapp.exceptions.UnAuthorizedUserException;
import com.abc.bankapp.service.AccountService;
import com.abc.bankapp.util.AccountToAccountDTOConvertion;
import com.abc.bankapp.validation.ValidateEntry;

@RestController
@RequestMapping("/bank")
public class AccountRestController {

	@Autowired
	AccountService accountService;
	
	
	@PostMapping("/login")
	public boolean doLogin(@RequestBody LoginDTO loginObj,HttpServletRequest req)throws InvalidUserExcption
	{
		String username = loginObj.getUsername();
		String password = loginObj.getPassword();
		
		if(ValidateEntry.validateNull(username) && ValidateEntry.validateNull(password))
		{
			String role = accountService.login(username, password);
			// some code for session handling 
			
			if(role != null)
			{
				// generate new session 
				HttpSession session = req.getSession(true); // in order to create new session
				//session.setAttribute("balance",170000); // store information in session like local storage
				//session.setAttribute("firstName","Ramesh");
				session.setAttribute("role", role);
				session.setAttribute("username",username);
				return true;
				
			}
			else
			{
				throw new InvalidUserExcption("","");
			}
			
		}
		else
		{
			throw new InvalidUserExcption("","");
		}
	
	}
	
	@GetMapping("/logout")
	public boolean doLogout(HttpServletRequest req)
	{
		HttpSession session = req.getSession(false);
		
		if(session != null)
		{
			session.invalidate(); // to logout
			return true;
		}
		else return false;
	}
	
	@GetMapping("/admin/accounts/balance?sort=asc")
	public List<Account> getAccountsBasedonBalanceHL(@RequestParam String sort,HttpServletRequest req)throws UnAuthorizedUserException
	{
		
		HttpSession session = req.getSession(false);
		
		if(session != null)
		{
			String role = (String)session.getAttribute("role");
			
			
			if(role.equals("admin"))
			{
				
					if(sort.equals("asc"))
					{
						
						return accountService.getAllAccountsByBalanceHtoL();
					}
				
					
			}
			else {
				String username = (String)session.getAttribute("username");
				throw new UnAuthorizedUserException(username);
			}
			
		}
		
		return null;
		
	}
	
	
	
	
	@GetMapping("/admin/accounts")
	public List<Account> doThis(HttpServletRequest req)throws UnAuthorizedUserException
	{
		
		HttpSession session = req.getSession(false);
		
		if(session != null)
		{
			String role = (String)session.getAttribute("role");
			
			
			if(role.equals("admin"))
				{
					return accountService.getAllAccounts();
				}
			else {
				String username = (String)session.getAttribute("username");
				throw new UnAuthorizedUserException(username);
			}
			
		}
		
		return null;
		
	}
	
	@GetMapping("/client/account/{accountNumber}")
	public ResponseEntity<AccountResponseDTOClient> getAcountForClientbasedOnId(@PathVariable int accountNumber,HttpServletRequest req)
	 throws InvalidAccountNumberException
	{
		
		HttpSession session = req.getSession(false); // need to access the session build during login time
		
		if(session != null)
		{
			AccountResponseDTOClient dtoObj = new AccountResponseDTOClient();//empty object
			
			Account fetchedAccount = accountService.getAccount(accountNumber);
			
				
			if(fetchedAccount != null)
			{
			  dtoObj = AccountToAccountDTOConvertion.doDTOCLientConvertion(fetchedAccount);
			   // set values in Session storage so that no need to access infomation from Database
			  
			  session.setAttribute("balance", fetchedAccount.getBalance());
			  session.setAttribute("username", fetchedAccount.getUsername());
			
			
			}
			return new ResponseEntity<AccountResponseDTOClient>(dtoObj,HttpStatus.OK);
		}
		else
		{
			
			// move user to login Page 
			// Assignment :throw SessionTimeOutException
			return null;
		}
		
		
		
	}
	
	
	@GetMapping("/admin/account/{accountNumber}")
	public ResponseEntity<AccountResponseDTOAdmin> getAcountForAdminbasedOnId(@PathVariable int accountNumber)
		throws InvalidAccountNumberException
	{
		Account fetchedAccount = accountService.getAccount(accountNumber);
		System.out.println("2 ------>> inside Rest Controller feched Account "+fetchedAccount);
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
	
	
	
	// www.mybank.com/client/depoist/101?amt=2000
	@GetMapping("/client/deposit/{accountId}")
	public boolean doDeposite(@PathVariable int accountId,@RequestParam int amt,HttpServletRequest req)
	throws InvalidAccountNumberException
	{
		boolean status = false;
		System.out.println("---->> acc id "+accountId);
		System.out.println("---->> amount "+amt);
		
		HttpSession session = req.getSession(false);
		
		if(session != null)
		{
			status = accountService.doDeposite(amt, accountId);
		}
		
		return status;
	}
	
	
}
