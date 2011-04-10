package com.isfasiel.main.user.web;

import java.util.Date;

import com.isfasiel.main.domain.User;


public interface LoginInfo {
	void save(User user);
	void remove();
	boolean isLoggedIn();
	User currentUser();
	Date getLoginTime();
}