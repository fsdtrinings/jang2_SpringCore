package com.abc.bankapp.exceptions;

public class UnAuthorizedUserException extends Exception{

	String loginUser;
	
	
	
	public UnAuthorizedUserException(String loginUser) {
		super();
		this.loginUser = loginUser;
	}



	public String getLoginUser() {
		return loginUser;
	}



	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}



	public String exceptionCause()
	{
		return loginUser+"not Authorized for the information";
	}
}
