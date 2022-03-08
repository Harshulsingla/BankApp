package com.bankApp.model.dto;

import com.bankApp.model.dao.Account;

public class DtoUtil {
	
	public static Account convertToAccount(AccountDto accountDto){
		Account account= new Account();
		account.setName(accountDto.getName());
		account.setAddress(accountDto.getAddress());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setPhoneNumber(accountDto.getPhoneNumber());
		
		return account;
	}
	
}
