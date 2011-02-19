package com.isfasiel.base.web;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.isfasiel.util.data.Data;

public class BaseController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Resource(name="props")
	protected Properties properties;
	
	protected Data getData() throws Exception{
		return new Data(request) ;
	}
	
	public String[] getMultiParam(String name, HttpServletRequest request) {
		return request.getParameterValues(name);
	}
}
