package com.mkj.bank.entity;

public class CustomerRelationshipExecutive {

	private int empId;
	private String name;
	private String email;
	private long phone;
	private float userRatings;
	public CustomerRelationshipExecutive() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerRelationshipExecutive(int empId, String name, String email, long phone, float userRatings) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.userRatings = userRatings;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public float getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(float userRatings) {
		this.userRatings = userRatings;
	}
	@Override
	public String toString() {
		return "CustomerRelationshipExecutive [empId=" + empId + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", userRatings=" + userRatings + "]";
	}
	
	
}
