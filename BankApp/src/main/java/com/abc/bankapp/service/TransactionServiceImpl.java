package com.abc.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bankapp.entity.Transaction;
import com.abc.bankapp.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	
	@Override
	public List<Transaction> getAllTransactions() {
			return transactionRepository.findAll();
	}

	
}
