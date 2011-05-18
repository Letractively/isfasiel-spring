package com.isfasiel.main.group.web;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.content.web.ContentController;
import com.isfasiel.main.domain.User;
import com.isfasiel.main.group.service.GroupService;
import com.isfasiel.util.Text;
import com.isfasiel.util.data.Data;

@Controller
@RequestMapping(value="/group")
public class GroupController extends ContentController {
	@Resource(name="groupService")
	protected GroupService groupService;
	
	@Resource(name="group.error")
	protected Properties groupProp;
	
	@Autowired
	Text text;
	
	private int pageSize = 20;
	private String path = "content/xml";
	
	@RequestMapping("/create.do")
	public String insert(Model model) throws Exception {
		
		if( !isLogin() ) {
			return returnErrorMsg(model, groupProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getParam();
		if(text.isNull(param.getString("groupName"))) {
			return returnErrorMsg(model, groupProp.getProperty("NO_GROUP_NAME"));
		}
		User user= getUser();
		param.add(0, "userIdx", user.getId());
		
		groupService.insert(param);
		param = null;
		return returnOkMsg(model);
	}
	
	@RequestMapping("/update.do")
	public String delete(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, groupProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getParam();
		if(text.isNull(param.getString("groupName"))) {
			return returnErrorMsg(model, "NO_GROUP_NAME");
		}
		if(text.isNull(param.getString("groupId"))) {
			return returnErrorMsg(model, "NO_GROUP_ID");
		}
		
		User user= getUser();
		param.add(0, "userIdx", user.getId());
		
		int count = groupService.update(param);
		param = null;
		if( count < 1) {
			return returnOkMsg(model);
		} else {
			return returnErrorMsg(model, "NO_GROUP");
		}
	}
	
	@RequestMapping("/delete.do")
	public String update(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, groupProp.getProperty("LOGIN_ERROR"));
		}
		
		Data param = getParam();
		User user= getUser();
		param.add(0, "userIdx", user.getId());
		
		if(text.isNull(param.getString("groupId"))) {
			return returnErrorMsg(model, "NO_GROUP_ID");
		}
		
		int count = groupService.delete(param);
		
		param = null;
		
		if( count < 1) {
			return returnOkMsg(model);
		} else {
			return returnErrorMsg(model, "NO_GROUP");
		}
	}
	
	@RequestMapping("/list/{page}")
	public String list(Model model, @PathVariable int page) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, groupProp.getProperty("LOGIN_ERROR"));
		}
		Data param = getPageParam(page, pageSize);
		Data result = groupService.list(param);
		addXML(model, "result", result, "group");
		
		param = null;
		result = null;
		return path;
		
	}
	
	@RequestMapping("/myList/{page}")
	public String myList(Model model, @PathVariable int page) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, groupProp.getProperty("LOGIN_ERROR"));
		}
		Data param = getPageParam(page, pageSize);
		Data result = groupService.list(param);
		addXML(model, "result", result, "group");
		
		param = null;
		result = null;
		return path;
		
	}
	
}
