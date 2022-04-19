package com.abc.bankapp.dto;

// Request DTO
public class LoginDTO {
	
	String username;
	String password;
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
