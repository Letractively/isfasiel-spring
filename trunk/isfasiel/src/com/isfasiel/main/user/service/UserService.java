package com.isfasiel.main.user.service;

import com.isfasiel.main.domain.User;

public interface UserService {

	public User findUser(String userName);
	
	public User login(User user);
	
	public User createUser(User user);
}
