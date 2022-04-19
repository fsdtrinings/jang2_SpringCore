package com.abc.bankapp.exceptions;

import java.time.LocalDateTime;

/* class act like as template */
public class MyUserExceptionResponse {

	private LocalDateTime now;
	private String errorMsg;
	private String exceptionCause;
	private String username;
	public MyUserExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyUserExceptionResponse(LocalDateTime now, String errorMsg, String exceptionCause, String username) {
		super();
		this.now = now;
		this.errorMsg = errorMsg;
		this.exceptionCause = exceptionCause;
		this.username = username;
	}
	public LocalDateTime getNow() {
		return now;
	}
	public void setNow(LocalDateTime now) {
		this.now = now;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getExceptionCause() {
		return exceptionCause;
	}
	public void setExceptionCause(String exceptionCause) {
		this.exceptionCause = exceptionCause;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
