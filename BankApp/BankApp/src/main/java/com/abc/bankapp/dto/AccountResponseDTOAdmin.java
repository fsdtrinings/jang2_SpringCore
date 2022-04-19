package com.abc.bankapp.dto;

public class AccountResponseDTOAdmin {
	
	private int accountNumber;
	private int balance;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private boolean kycStatus;
	public AccountResponseDTOAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountResponseDTOAdmin(int accountNumber, int balance, String firstName, String lastName, long phoneNumber,
			boolean kycStatus) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.kycStatus = kycStatus;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isKycStatus() {
		return kycStatus;
	}
	public void setKycStatus(boolean kycStatus) {
		this.kycStatus = kycStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + balance;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (kycStatus ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountResponseDTOAdmin other = (AccountResponseDTOAdmin) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (balance != other.balance)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (kycStatus != other.kycStatus)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}
	
	

}
