package com.bankApp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankApp.model.service.AccountService;

@Controller
public class HomeController {

	private AccountService accountService;
	
	@Autowired
	public HomeController(AccountService accountService) {
		this.accountService=accountService;
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
