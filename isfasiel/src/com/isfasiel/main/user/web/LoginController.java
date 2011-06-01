package com.isfasiel.main.user.web;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;

import com.isfasiel.main.domain.Login;
import com.isfasiel.main.domain.User;
import com.isfasiel.main.user.service.UserService;
import com.isfasiel.main.user.web.validator.LoginValidator;

@Controller
@RequestMapping("/login")
//@SessionAttributes("login") 
public class LoginController extends UserController{
	private LoginValidator loginValidator;
	private UserService userService;
	private Provider<LoginInfo> loginInfoProvider;

	@Inject
	public void setLoginInfoProvider(Provider<LoginInfo> loginInfoProvider) {
		this.loginInfoProvider = loginInfoProvider;
	}

	@Autowired
	public void init(LoginValidator loginValidator, UserService userService) {
		this.loginValidator = loginValidator;
		this.userService = userService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showform(ModelMap model) {
		model.addAttribute(new Login());
		return "login";
	}
	
	//RequestMapping(value="login.do", method=RequestMethod.POST)
	//RequestMapping(method=RequestMethod.POST)
	@RequestMapping(value="login.do")
	public String login(@ModelAttribute @Valid Login login, BindingResult result, Model model /*, SessionStatus status */) throws Exception {
		if (result.hasErrors()) return "login";
		login.setPassword(encode(login.getPassword()) );
		this.loginValidator.validate(login, result);
		if (result.hasErrors()) {
			return "login";
		} else {
			//userService.login(loginInfoProvider.get().currentUser());
			//status.setComplete();
			//return "redirect:user/list";
			model.addAttribute("user", loginInfoProvider.get().currentUser());
			return "user/logedin";
		}
	}
	
	@RequestMapping(value="/create.do" ,method=RequestMethod.POST)
	public String create(@ModelAttribute User user, Model model) throws Exception{
		user.setPassword(encode(user.getPassword()) );
		User result = userService.createUser(user);
		String path = "user/created";
		
		model.addAttribute("userIdx", result == null ? -1 : result.getId());
		result = null;
		user = null;
		return path;
	}
}