package com.isfasiel.main.user.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.main.domain.User;

@Repository("userDAO")
public class UserDAO extends BaseDAO {
	
	public User login(User user) {
		return (User)this.getSqlMapClientTemplate().queryForObject("userDAO.login", user);
	}
	
	public User findUser(String email) {
		return (User)this.getSqlMapClientTemplate().queryForObject("userDAO.findUser", email);
	}
	
	public User create(User user) throws Exception {
		User preUser = findUser(user.getEmail());
		if(preUser != null) {
			preUser = null;
			return null;
		}
		long userIdx = getSeq("SQL_TN_USER_INFO");
		user.setId(userIdx);
		this.getSqlMapClientTemplate().insert("userDAO.createUser", user);
		preUser = null;
		return findUser(user.getEmail());
	}
	
}
