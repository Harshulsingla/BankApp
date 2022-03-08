package com.bankApp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankApp.model.dto.AccountDto;
import com.bankApp.model.dto.DtoUtil;
import com.bankApp.model.service.AccountService;

//@Controller
public class AccountCrudController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountCrudController(AccountService accountService) {
		this.accountService=accountService;
	}
	
	//---------------  addAccount -------------------------
	
	@GetMapping(path="accounts")
	public ModelAndView accountGet(ModelAndView mv) {
		mv.setViewName("addAccounts");
		mv.addObject("accountDto", new AccountDto());
		return mv;
	}
	
	@PostMapping(path="accounts")
		public String transferPost(@ModelAttribute AccountDto accountDto) {
		accountService.addAccount(DtoUtil.convertToAccount(accountDto));
		return "redirect:success";
	}
	
	@GetMapping(path="success")
	public String transferGet() {
		return "success";
	}
	
}
