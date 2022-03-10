package com.bankApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankApp.model.dao.User;
import com.bankApp.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	private UserDao userDao;

	@Autowired
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
