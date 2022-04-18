package com.abc.bankapp.entity;

import javax.persistence.Embeddable;

@Embeddable
public class UserDetails {
	
	private String firstName;
	private String lastName;
	private String houseAddress;
	private String city;
	private String panNumber;
	private long mobileNumber;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(String firstName, String lastName, String houseAddress, String city, String panNumber,
			long mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseAddress = houseAddress;
		this.city = city;
		this.panNumber = panNumber;
		this.mobileNumber = mobileNumber;
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
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

}
