package com.abc.bankapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.bankapp.entity.Transaction;

@Service
public interface TransactionService {

	public List<Transaction> getAllTransactions();
}
