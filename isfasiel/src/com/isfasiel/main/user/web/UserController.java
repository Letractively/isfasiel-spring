package com.isfasiel.main.user.web;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.security.Cryptograph;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {

	@Autowired
	protected Cryptograph cryptograph;
	
	@Resource(name="pp.security")
	protected Properties scProp;
	
	protected String encode(String text) throws Exception{
		if(cryptograph.getKey() == null) {
			cryptograph.init( getContextPath() + "WEB-INF/config/key/" + scProp.getProperty("keyFileName"));
		}
		return cryptograph.encode(text);
	}
	
	protected String decode(String text) throws Exception{
		if(cryptograph.getKey() == null) {
			cryptograph.init(scProp.getProperty("keyFileName"));
		}
		return cryptograph.decode(text);
	}
	
	
	@RequestMapping(value="/new")
	public String insertUser() throws Exception{
		Data param = getParam();
		param.add(0,"password", encode(param.getString(0,"pwd")));
		System.out.println(param.getString(0, "password"));
		System.out.println(param.getString(0, "pwd"));
		System.out.println(decode( param.getString(0, "password")) );
		return "user/join";
	}
	
}
