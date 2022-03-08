package com.bankApp.model.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankApp.model.dao.User;

public interface UserService{
	public void addUser(User user);
	public User getUserByUsername(String username);
}
