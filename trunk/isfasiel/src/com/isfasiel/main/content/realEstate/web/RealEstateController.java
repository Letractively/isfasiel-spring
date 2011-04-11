package com.isfasiel.main.content.realEstate.web;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.content.service.ContentService;
import com.isfasiel.main.content.web.ContentController;
import com.isfasiel.main.domain.User;
import com.isfasiel.main.user.web.LoginInfo;
import com.isfasiel.util.data.Data;

@Controller
@RequestMapping(value="/real")
public class RealEstateController extends ContentController {
	private int pageSize = 20;
	
	private Provider<LoginInfo> loginInfoProvider;

	@Inject
	public void setLoginInfoProvider(Provider<LoginInfo> loginInfoProvider) {
		this.loginInfoProvider = loginInfoProvider;
	}
	
	@Resource(name="realEstateService")
	ContentService realEstateService;
	
	private String path = "content/xml";
	
	@RequestMapping(value="/create.do")
	public String createContent(Model model) throws Exception {
		Data result = new Data();
		User user = loginInfoProvider.get().currentUser();
		if(user != null) {
			
		
			try {
				Data param = getParam();
				param.add(0, "userIdx", user.getId());
				realEstateService.insert(param);
				result.add(0,"result", "OK");
				
			} catch (Exception e) {
				result.add(0,"result", "NO");
			}
		} else {
			result.add(0,"result", "NO");
		}
		addXML(model, "result", result, "result");
		return path;
	}
	
	@RequestMapping(value="/update.do") 
	public String updateContent(Model model) throws Exception {
		Data result = new Data();
		try {
			realEstateService.update(getParam());
			result.add(0,"result", "OK");
			
		} catch (Exception e) {
			result.add(0,"result", "NO");
		}
		addXML(model, "result", result, "result");
		return path;
	}
	
	@RequestMapping(value="/list/{pageNumber}")
	public String listContent(@PathVariable("pageNumber") int pageNumber, Model model) throws Exception {
		Data param = getPageParam(pageNumber, pageSize);
		
		Data result = realEstateService.list(param);
		addXML(model, "result", result, "content");
		param = null;
		return path;
	}
	
	@RequestMapping(value="/view/{contentId}")
	public String viewContent(@PathVariable("contentId") long contentId, Model model) throws Exception {
		Data result = realEstateService.select(getParam()).get(0);
		addXML(model, "result", result, "content");
		return path;
	}
	
	@RequestMapping(value="/test")
	public String test(Model model) throws Exception{
		model.addAttribute("user", loginInfoProvider.get().currentUser());
		return "real/test";
	}
}
