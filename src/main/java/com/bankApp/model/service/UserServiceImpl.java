package com.bankApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankApp.model.dao.User;
import com.bankApp.model.dao.UserDao;

public class UserServiceImpl implements UserService{
	
	
	private UserDao userDao;
	
	
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
