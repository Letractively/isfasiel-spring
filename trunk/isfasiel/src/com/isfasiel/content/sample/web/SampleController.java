package com.isfasiel.content.sample.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.base.web.BaseController;
import com.isfasiel.content.sample.service.SampleService;
import com.isfasiel.content.sample.service.SampleVO;
import com.isfasiel.util.smtp.EmailDelivery;
@Controller
public class SampleController extends BaseController{
	
	@Autowired
	private EmailDelivery emailDelivery;
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample.do")
	public String go() throws Exception {
		sampleService.insert(getData());
		return "";
	}
	
	@RequestMapping(value="/sample/create/{id}/{name}")
	public String create(@PathVariable("id") int id, @PathVariable("name") String name) throws Exception {
		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(id);
		sampleVO.setName(name);
		return "";
		
	}
	
	@RequestMapping(value="/sample/email/{addr}")
	public String sendMail(@PathVariable("addr") String addr) throws Exception {
		
		emailDelivery.setSMTPHost("smtp.gmail.com", 587, "isfasiel", "bs19ms");
		emailDelivery.setTo(addr +"@gmail.com");
		emailDelivery.setFrom("isfasiel@gmail.com", "Bae Byeongseon");
		emailDelivery.setSubject("�ѱ��� ������ �̰���");
		emailDelivery.setBody("Test message body.�ѱ��� �����ε� �ѱ��� �� ����?");
		emailDelivery.sendMsg();
		return "";
	}
}
