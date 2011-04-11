package com.isfasiel.main.user.web.validator;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.isfasiel.main.domain.Login;
import com.isfasiel.main.domain.User;
import com.isfasiel.main.user.service.UserService;
import com.isfasiel.main.user.web.LoginInfo;

@Component
public class LoginValidator implements Validator {
	private UserService userService;
	
	@Inject
	private Provider<LoginInfo> loginInfoProvider;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Login.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Login login = (Login)target;
		User inputUser = new User(login);
		
		User user = userService.login(inputUser);
		if (user == null) {
			errors.reject("invalidLogin", "Invalid Login");
		}
		else {
			LoginInfo loginInfo = loginInfoProvider.get();
			loginInfo.save(user);
		}
		inputUser = null;
		
	}
}