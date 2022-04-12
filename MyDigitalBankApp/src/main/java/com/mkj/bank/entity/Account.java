package com.mkj.bank.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Account {

	@Value("${account.name}")
	private String accountName;
	@Value("New Delhi")
	private String branchName;
	@Value("78787874")
	private int accountNumber;
	@Value("#{2000+6000}")
	private int balance;
	
	@Autowired
	private CustomerRelationshipExecutive executive;
	@Autowired
	private KYCDetails kycDetails;
	
	// List<Stocks>
	// List<Policy>
	// List<Insurance>
	
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
		System.out.println("--- constructor called for "+this.accountName);
	}
	
	
	


	public KYCDetails getKycDetails() {
		return kycDetails;
	}

	
	public void setKycDetails(KYCDetails kycDetails) {
		this.kycDetails = kycDetails;
	}

	public CustomerRelationshipExecutive getExecutive() {
		return executive;
	}

	public void setExecutive(CustomerRelationshipExecutive executive) {
		this.executive = executive;
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

	@Override
	public String toString() {
	
		
		return accountName+", "+accountNumber+", "+balance+" , "+branchName+" ,\n "+executive.getName()+" , "+executive.getPhone()+"\n"
				+ ""+kycDetails+" ";
		 
	
	}
	
	
}
