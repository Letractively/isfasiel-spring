package com.isfasiel.content.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.isfasiel.base.web.BaseController;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.page.PageUtil;

public class ContentController extends BaseController {
	
	@Autowired
	protected PageUtil pageUtil;

	public Data getPageParam(int page, int pageSize) throws Exception{
		Data param = getParam();
		param.add(0,"page", page);
		param.add(0,"pageSize", pageSize);
		param = pageUtil.getRowSize(param);
		return param;
	}
	
}
