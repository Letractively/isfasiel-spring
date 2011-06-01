package com.isfasiel.main.content.movie.web;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	
	private String path = "content/xml";
	
	@RequestMapping("/create.do")
	public String create(HttpServletRequest request,  Model model) throws Exception {
		
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		
		User user = getUser();
		Data param = getParam(request);
		
		param.add(0, "contentType", "M");
		param.add(0, "userIdx", user.getId());
		param.add(0, "ipAddr", getRemoteIP());
		System.out.println(param);
		long contentId = movieService.insert(param);
		
		Data files = uploadFiles(request, contentId);
		//files.add(0,"contentId", contentId);
		System.out.println(files);
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
		List<Data> result = movieService.select(param);
		param = null;
		
		int size = result.get(2).size();
		int index = 0;//EXTENTION
		for(int i =0; i < size; i++) {
			if( "mov".equals( result.get(2).getString(i, "extention")) ) {
				String movieFile = fileUtil.copyFileToWebServer(getContextPath("/tempFile/"), 
						result.get(2).getString(i,"dirType") + "/" + result.get(2).getString(i, "phyPath"),
						result.get(2).getString(i,"phyName"));
				
				result.get(0).add(0, "movieFile", "/tempFile/"+ movieFile);
			} else {
				String filePath = "/file/download/" + result.get(2).getString(i, "fileId");
				result.get(0).add(index, "imageFile", filePath);
				index += 1;
			}
		}
		System.out.println(result.get(0));
		addXML(model, "result", result.get(0), "content");
		return path;
		//return returnOkMsg(model);
		
	}
	
	@RequestMapping("list/{page}")
	public String view(Model model, @PathVariable int page) throws Exception {
		if(!isLogin()) {
			return returnErrorMsg(model, "NO_LOGIN");
		}
		
		User user = getUser();
		Data param = getPageParam(page, pageSize);
		param.add(0, "userIdx", user.getId());
		
		System.out.println(param);
		Data result = movieService.list(param);

		addXML(model, "result", result, "content");
		result = null;
		param = null;
		return path;
	}
	
}