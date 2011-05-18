package com.isfasiel.main.content.movie.web;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.content.service.ContentService;
import com.isfasiel.main.content.web.ContentController;
import com.isfasiel.main.domain.User;
import com.isfasiel.util.data.Data;

@Controller
@RequestMapping("/movie")
public class MovieController extends ContentController {
	
	private int pageSize = 20;
	
	@Resource(name="movieService")
	ContentService movieService;
	
	@Resource(name="movie.error")
	Properties movieProp;
	
	@RequestMapping("/create.do")
	public String create(Model model) throws Exception {
		
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		User user = getUser();
		Data param = getParam();
		param.add(0, "contentType", "M");
		param.add(0, "userIdx", user.getId());
		movieService.insert(param);
		param = null;
		return returnOkMsg(model);
	}
	
	@RequestMapping("update.do")
	public String update(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		User user = getUser();
		Data param = getParam();
		param.add(0, "userIdx", user.getId());
		movieService.update(param);
		param = null;
		return returnOkMsg(model);
		
	}
	
	@RequestMapping("delete.do")
	public String delete(Model model) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		User user = getUser();
		Data param = getParam();
		param.add(0, "userIdx", user.getId());
		movieService.delete(param);
		param = null;
		return returnOkMsg(model);
		
	}
	
	@RequestMapping("view/{contentId}")
	public String view(Model model, @PathVariable long contentId) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		User user = getUser();
		Data param = getParam();
		param.add(0, "userIdx", user.getId());
		param.add(0, "contentId", contentId);
		movieService.select(param);
		param = null;
		return returnOkMsg(model);
		
	}
	
	@RequestMapping("list/{page}")
	public String view(Model model, @PathVariable int page) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		User user = getUser();
		Data param = getPageParam(page, pageSize);
		param.add(0, "userIdx", user.getId());
		movieService.list(param);
		param = null;
		return returnOkMsg(model);
		
	}
	
}