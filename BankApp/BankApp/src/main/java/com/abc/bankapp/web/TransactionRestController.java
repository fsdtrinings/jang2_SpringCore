package com.abc.bankapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bankapp.entity.Transaction;
import com.abc.bankapp.service.TransactionService;

@RestController
@RequestMapping("tra")
public class TransactionRestController {

	@Autowired
	TransactionService transactionService;
	
	public TransactionRestController() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("------- Inside Transaction Constructor ----");
	}
	
	@GetMapping("/alltransactions")
	public List<Transaction> getAllTransactions()
	{
		return transactionService.getAllTransactions();
	}
	
	

}
