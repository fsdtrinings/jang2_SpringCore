package com.abc.bankapp.exceptions;

public class InvalidAccountNumberException extends Exception{
	
	int reqAccountNumber;
	String errorMsg;
	
	public InvalidAccountNumberException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidAccountNumberException(int reqAccountNumber, String errorMsg) {
		super();
		this.reqAccountNumber = reqAccountNumber;
		this.errorMsg = errorMsg;
	}

	public int getReqAccountNumber() {
		return reqAccountNumber;
	}

	public void setReqAccountNumber(int reqAccountNumber) {
		this.reqAccountNumber = reqAccountNumber;
	}

	public String getErrorMsg() {
		return errorMsg+" for Account number "+this.reqAccountNumber;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	

}
