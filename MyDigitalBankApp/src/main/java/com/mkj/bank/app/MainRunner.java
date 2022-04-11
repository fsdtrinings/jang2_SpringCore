package com.mkj.bank.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkj.bank.entity.Account;

public class MainRunner {

	public static void main(String[] args) {
		// -----------------------------------------------------------------------------------
		    /*   code to initilize String*/
		
		ApplicationContext spring = new ClassPathXmlApplicationContext("spring-conf.xml");
		
		
		// -------------------------------------------------------------------------------------
		// Type 1 object - default object 
		
		// account object without spring 
		Account a = new Account();
		System.out.println("-------->> Without Spring "+a);
		
		// account object through Spring (Factory class of object creation)
		
		Account a2 = (Account)spring.getBean("defaultSavingAccount");
		System.out.println("------->> Through Spring "+a2);
		
		
		
		
		
		
		
		
		
		
		// Type 2 - Properties set through constructor 
		
		
		
		
		// Type 3 - Properties set through setter method
		
		
		
		
		
	}//end of main
	
}//end of class
