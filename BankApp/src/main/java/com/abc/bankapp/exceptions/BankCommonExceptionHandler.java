package com.abc.bankapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
public class BankCommonExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<MyUserExceptionResponse> handleInvalidAccountNumberException(InvalidAccountNumberException e)
	{
		MyUserExceptionResponse excResponse = new MyUserExceptionResponse();
		
		excResponse.setNow(LocalDateTime.now());
		excResponse.setUsername("ramesh123"); // replace from Session Tracking 
		excResponse.setErrorMsg(e.getErrorMsg());
		excResponse.setExceptionCause(e.getReqAccountNumber()+"");
		
		return new ResponseEntity<MyUserExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyUserExceptionResponse> handleInvalidUserException(InvalidUserExcption e)
	{
		MyUserExceptionResponse excResponse = new MyUserExceptionResponse();
		
		excResponse.setNow(LocalDateTime.now());
		excResponse.setUsername(e.getUsername()); // replace from Session Tracking 
		excResponse.setErrorMsg(" "+e.getUsername()+" and "+e.getPassword()+" not present in the DB");
		excResponse.setExceptionCause("Username & password not match");
		
		return new ResponseEntity<MyUserExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyUserExceptionResponse> handleUnAuthorizedUserException(UnAuthorizedUserException e)
	{
		MyUserExceptionResponse excResponse = new MyUserExceptionResponse();
		
		excResponse.setNow(LocalDateTime.now());
		excResponse.setUsername(e.getLoginUser()); // replace from Session Tracking 
		excResponse.setErrorMsg(e.exceptionCause());
		excResponse.setExceptionCause("UnAuthroized Resource Access !!! ");
		
		return new ResponseEntity<MyUserExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
	}
	
	
	

}
