package com.isfasiel.main.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.domain.User;
import com.isfasiel.main.user.service.UserService;

@Service("userService")
public class UserImpl implements UserService {

	@Resource(name="userDAO")
	UserDAO userDao;
	
	@Override
	public User findUser(String userName) {
		return null;
	}

	@Override
	public User login(User user) {
		try {
			return userDao.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User createUser(User user) {
		try {
			return userDao.create(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
