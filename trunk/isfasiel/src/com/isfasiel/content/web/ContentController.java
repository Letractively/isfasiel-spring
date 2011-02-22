package com.isfasiel.content.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.base.web.BaseController;
import com.isfasiel.content.service.ContentService;

@Controller
public class ContentController extends BaseController {
	@Resource(name="contentService")
	ContentService contentService;
	
	@RequestMapping(value="/content/insert.do")
	public String insert() throws Exception {
		contentService.insertContent(getParam());
		return "content/list";
	}
	
	@RequestMapping(value="/content/viewInsert.do")
	public String viewInsert() throws Exception{
		
		return "content/insert";
	}
	
	
	
}
