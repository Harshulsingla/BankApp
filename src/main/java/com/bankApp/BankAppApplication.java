package com.bankApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bankApp.model.dao.Account;
import com.bankApp.model.service.AccountService;

@EnableJpaRepositories
@SpringBootApplication
public class BankAppApplication implements CommandLineRunner{
	
	@Autowired
	AccountService accountservice;
	

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		accountservice.addAccount(new Account("foo", 5000.00, "12345", "barPalace", "bla@bla"));
//		accountservice.addAccount(new Account("bar", 5000.00, "67890", "fooPalace", "yo@yo"));
		
	}

}
