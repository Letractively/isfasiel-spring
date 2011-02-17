package com.isfasiel.base.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.isfasiel.util.data.Data;

public class BaseController {
	@Autowired
	HttpServletRequest request;
	
	protected Data getData() throws Exception{
		return new Data(request) ;
	}
	
	public String[] getMultiParam(String name, HttpServletRequest request) {
		return request.getParameterValues(name);
	}
}
