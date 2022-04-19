package com.abc.bankapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TID")
	private int transactionId;
	
	@Column(nullable = false)
	private int accountNumber;
	
	@Column(nullable = false)
	private String transactionType;
	@Column(name="amount",nullable = false)
	private int amountOfTransaction;
	@Column(name = "TransferTo")
	private int secondAccount;
	@Column(name="DOT",nullable = false)
	private LocalDate transactionDate;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int accountNumber, String transactionType, int amountOfTransaction, int secondAccount,
			LocalDate transactionDate) {
		super();
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.amountOfTransaction = amountOfTransaction;
		this.secondAccount = secondAccount;
		this.transactionDate = transactionDate;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getAmountOfTransaction() {
		return amountOfTransaction;
	}
	public void setAmountOfTransaction(int amountOfTransaction) {
		this.amountOfTransaction = amountOfTransaction;
	}
	public int getSecondAccount() {
		return secondAccount;
	}
	public void setSecondAccount(int secondAccount) {
		this.secondAccount = secondAccount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	

}
