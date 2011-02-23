package com.isfasiel.content.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.base.web.BaseController;
import com.isfasiel.content.service.ContentService;
import com.isfasiel.tag.service.TagService;
import com.isfasiel.util.data.Data;

//@Controller
public class ContentController extends BaseController {
	//@Resource(name="contentService")
	ContentService contentService;
	
	//@Resource(name="tagService")
	TagService tagService;
	
	@RequestMapping(value="/content/insert.do")
	public String insert() throws Exception {
		Data param = getParam();
		Long contentId = contentService.insert(getParam());
		param.add(0,"contentId", contentId);
		tagService.updateTag(param);
		return "content/list";
	}
	
	@RequestMapping(value="/content/viewInsert.do")
	public String viewInsert() throws Exception{
		
		return "content/insert";
	}
	
	
	
}
