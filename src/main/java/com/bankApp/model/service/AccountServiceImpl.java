package com.bankApp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankApp.model.dao.Account;
import com.bankApp.model.dao.AccountDao;
import com.bankApp.model.dto.AccountDetailDto;
import com.bankApp.model.exception.UserAccountNotFoundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	private AccountDao accountDao;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao=accountDao;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

	@Override
	public Account getAccountById(int accountId) {
		// TODO Auto-generated method stub
		return accountDao.findById(accountId).orElseThrow(()->new UserAccountNotFoundException("User Account Not Found"));
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.save(account);
		return account;
	}

	@Override
	public Account updateAccountDetails(int accountId, AccountDetailDto accountDetail) {
		Account account = getAccountById(accountId);
		account.setAddress(accountDetail.getAddress());
		account.setEmail(accountDetail.getEmail());
		account.setPhoneNumber(accountDetail.getPhoneNumber());
		
		accountDao.save(account);
		return account;
	}

	@Override
	public Account deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		Account accountToDelete=getAccountById(accountId);
		accountDao.delete(accountToDelete);
		
		return accountToDelete;
	}

	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		// TODO Auto-generated method stub
		Account fromAcc= getAccountById(fromAccountId);
		Account toAcc=getAccountById(toAccountId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		accountDao.save(fromAcc);
		accountDao.save(toAcc);
	}

	@Override
	public void deposit(int accountId, double amount) {
		// TODO Auto-generated method stub
		Account accToDeposit= getAccountById(accountId);
		accToDeposit.setBalance(accToDeposit.getBalance()+amount);
		accountDao.save(accToDeposit);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account accToWithdraw= getAccountById(accountId);
		accToWithdraw.setBalance(accToWithdraw.getBalance()-amount);
		accountDao.save(accToWithdraw);
		
	}

}
