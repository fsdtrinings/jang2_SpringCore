package com.mkj.bank.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkj.bank.entity.Account;

public class MainAnnotation {

	public static void main(String[] args) {
				
		ApplicationContext spring = new ClassPathXmlApplicationContext("spring-ann.xml");
		
		Account a = (Account) spring.getBean("account");
		
		System.out.println(a);
		
		

		
		
		
	}//end of main
	
}//end of class
