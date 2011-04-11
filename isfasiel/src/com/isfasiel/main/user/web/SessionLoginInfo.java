package com.isfasiel.main.user.web;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.isfasiel.main.domain.User;


@Component
@Scope("session")
public class SessionLoginInfo implements LoginInfo {
	private User currentUser;
	private Date loginTime;
	
	@Override
	public User currentUser() {
		return this.currentUser;
	}

	@Override
	public boolean isLoggedIn() {
		return (this.currentUser != null);
	}

	@Override
	public void remove() {
		if (this.currentUser == null) throw new IllegalStateException();
		this.currentUser = null;
		this.loginTime = null;
	}

	@Override
	public void save(User user) {
		this.currentUser = user;
		this.loginTime = new Date();
	}

	@Override
	public Date getLoginTime() {
		return this.loginTime;
	}

}
