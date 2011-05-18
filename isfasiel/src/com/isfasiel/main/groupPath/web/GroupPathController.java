package com.isfasiel.main.groupPath.web;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.content.web.ContentController;
import com.isfasiel.main.groupPath.service.GroupPathService;
import com.isfasiel.util.Text;
import com.isfasiel.util.data.Data;

@Controller
@RequestMapping("/groupPath")
public class GroupPathController extends ContentController {
	@Resource(name="groupPathService")
	private GroupPathService groupPathService;
	
	@Autowired
	private Text text;
	
	@Resource(name="groupPath.error")
	private Properties groupPathProp;
	
	private String path = "/content/xml";
	
	private int pageSize = 20;
	
	@RequestMapping("/create.do")
	public String create(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model,  groupPathProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getParam();
		
		if(text.isNull(param.getString(0,"groupId"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_GROUP_ID"));
		}
		
		if(text.isNull(param.getString(0,"pathName"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_PATH_NAME"));
		}
		
		groupPathService.insert(param);
		
		param = null;
		return returnOkMsg(model);
		//return path;
	}
	
	@RequestMapping("/update.do")
	public String update(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model,  groupPathProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getParam();
		
		if(text.isNull(param.getString(0,"groupId"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_GROUP_ID"));
		}
		
		if(text.isNull(param.getString(0,"pathName"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_PATH_NAME"));
		}
		
		if(text.isNull(param.getString(0,"pathId"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_PATH_ID"));
		}
		
		groupPathService.update(param);
		
		param = null;
		
		return returnOkMsg(model);
	}
	
	@RequestMapping("/delete.do")
	public String delete(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model,  groupPathProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getParam();
		
		if(text.isNull(param.getString(0,"groupId"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_GROUP_ID"));
		}
		
		if(text.isNull(param.getString(0,"pathId"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_PATH_ID"));
		}
		
		groupPathService.delete(param);
		
		param = null;
		
		return returnOkMsg(model);
	}
	
	@RequestMapping("/list/{page}")
	public String delete(Model model, @PathVariable int page) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model,  groupPathProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getPageParam(page, pageSize);
		
		if(text.isNull(param.getString(0,"groupId"))) {
			param = null;
			return returnErrorMsg(model, groupPathProp.getProperty("NO_GROUP_ID"));
		}
		
		Data result = groupPathService.list(param);
		
		addXML(model, "result", result, "path");
		result = null;
		param = null;
		
		return path;
	}
	
	
}
