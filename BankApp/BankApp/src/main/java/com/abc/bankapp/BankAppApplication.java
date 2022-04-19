package com.abc.bankapp;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

}
