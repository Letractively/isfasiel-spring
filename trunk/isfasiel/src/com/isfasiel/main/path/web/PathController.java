package com.isfasiel.main.path.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.main.path.service.PathService;

@Controller
@RequestMapping(value="/path")
public class PathController extends BaseController {
	@Resource(name="pathService")
	private PathService pathService;
	
	@RequestMapping(value="/list")
	public String getPath(Model model) throws Exception {
		addList(model, "path", pathService.list());
		return "path/list";
	}
}
