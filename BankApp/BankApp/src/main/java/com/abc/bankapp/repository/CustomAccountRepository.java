package com.abc.bankapp.repository;

import com.abc.bankapp.exceptions.InvalidUserExcption;

public interface CustomAccountRepository {
	
	public String verifyUser(String username,String password)throws InvalidUserExcption;

}
