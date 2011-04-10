package com.isfasiel.main.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.util.smtp.EmailDelivery;
import com.isfasiel.util.test.TestUtil;

@Controller
public class TestController extends BaseController {
	@Autowired
	TestUtil util;
	
	@RequestMapping(value="/test/do.do")
	public String test() {
		TestUtil util2 = new TestUtil();
		TestUtil util3 = new TestUtil();
		util2.print();
		util.print();
		
		EmailDelivery ed = new EmailDelivery();
		try {
			ed.setSMTPHost("smtp.gmail.com", 587, "isfasiel", "bs19ms");
			//ed.setSMTPHost("smtp.gmail.com", 587, "isfasiel", "bs19ms", true);
			
			ed.setTo("happypgh@gmail.com");
			//ed.setFrom("isfasiel@gmail.com", "Bae Byeongseon");
			ed.setSubject("ㄴ이ㅏ러;밍러");
			ed.setBody("Test message body.한글이 문제인데 한글은 잘 가나?");
			//ed.addFileAttachment("C:\\Users\\Ted\\Desktop\\googleMapUtil.txt");
			//ed.setSMTPHost("smtp.gmail.com", 587, "isfasiel", "bs19ms");
			ed.sendMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
