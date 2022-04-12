package com.mkj.bank.app;

import com.mkj.bank.entity.Account;
import com.mkj.bank.entity.CustomerRelationshipExecutive;

public class OldJavaMain {

	public static void main(String[] args) {
		
		Account a = new Account("Kavita", "New Delhi123",123, 5000);
		CustomerRelationshipExecutive e = new CustomerRelationshipExecutive(101, "Vijay Kumar", "Vijay@abcBank.com", 985595959, 3.9f);
		a.setExecutive(e);
		
		
	}
}
