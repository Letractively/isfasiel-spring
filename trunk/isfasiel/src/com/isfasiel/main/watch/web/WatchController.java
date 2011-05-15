package com.isfasiel.main.watch.web;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.main.domain.User;
import com.isfasiel.main.user.web.LoginInfo;
import com.isfasiel.main.watch.service.WatchService;
import com.isfasiel.util.data.Data;

@Controller
@RequestMapping(value="/watch")
public class WatchController extends BaseController {

	private String path = "content/xml";
	
	@Resource(name="watchService")
	WatchService watchService;
	
	private Provider<LoginInfo> loginInfoProvider;
	
	@Inject
	public void setLoginInfoProvider(Provider<LoginInfo> loginInfoProvider) {
		this.loginInfoProvider = loginInfoProvider;
	}
	
	@RequestMapping(value="/create.do")
	public String createWatch(Model model) throws Exception {
		User user = loginInfoProvider.get().currentUser();
		Data result = new Data();
		if(user != null) {
			try {
				Data param = getParam();
				param.add(0, "userIdx", user.getId());
				watchService.insertWatch(param);
				result.add(0, "result", "OK");
				param = null;
			} catch (Exception e) {
				e.printStackTrace();
				result.add(0, "result", "NO");
			}
		} else {
			result.add(0, "result", "NO");
		
		}
		addXML(model, "result", result, "watch");
		return path;
	}
	@RequestMapping(value="/delete.do")
	public String deleteWatch(Model model) throws Exception {
		User user = loginInfoProvider.get().currentUser();
		Data result = new Data();
		if(user != null) {
			try {
				Data param = getParam();
				param.add(0, "userIdx", user.getId());
				watchService.deleteWatch(param);
				result.add(0, "result", "OK");
				param = null;
			} catch (Exception e) {
				e.printStackTrace();
				result.add(0, "result", "NO");
			}
		} else {
			result.add(0, "result", "NO");
		
		}
		addXML(model, "result", result, "watch");
		return path;
	}
	
	@RequestMapping(value="/list.do")
	public String delteWatch(Model model) throws Exception {
		User user = loginInfoProvider.get().currentUser();
		Data result = new Data();
		if(user != null) {
			try {
				Data param = getParam();
				param.add(0, "userIdx", user.getId());
				result = watchService.listWatch(param);
				param = null;
			} catch (Exception e) {
				e.printStackTrace();
				result = new Data();
				result.add(0, "result", "NO");
			}
		} else {
			result = new Data();
			result.add(0, "result", "NO");
		
		}
		addXML(model, "result", result, "watch");
		return path;
	}
}
