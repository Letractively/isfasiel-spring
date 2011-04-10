package com.isfasiel.main.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.util.test.TestUtil;
@Controller
public class Test2Controller extends BaseController {
	
	@Autowired
	TestUtil util;
	
	@RequestMapping(value="/test/do2.do")
	public String test(){
		util = new TestUtil();
		util.print();
		return "";
	}

}
