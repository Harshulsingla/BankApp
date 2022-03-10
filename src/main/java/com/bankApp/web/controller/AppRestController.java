package com.bankApp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankApp.model.dao.Account;
import com.bankApp.model.service.AccountService;

@RestController
public class AppRestController {
	
	private AccountService accountService;

	@Autowired
	public AppRestController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping(path="account")
	public ResponseEntity<List<Account>>getAllAccount(){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts());
	}
	
	@GetMapping(path="account/{id}")
	public ResponseEntity<Account>getAccountbyId(@PathVariable(name = "id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccountById(id));
	}
	
	@PostMapping(path="addaccount")
	public ResponseEntity<Account>addAccount(@RequestBody Account account){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.addAccount(account));
	}
	
	
	
	
	
}
