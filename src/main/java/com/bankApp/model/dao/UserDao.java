package com.bankApp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
