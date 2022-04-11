package com.mkj.bank.entity;

public class Account {

	private String accountName;
	private String branchName;
	private int accountNumber;
	private int balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountName, String branchName, int accountNumber, int balance) {
		super();
		this.accountName = accountName;
		this.branchName = branchName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
