package com.isfasiel.main.base.web;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.isfasiel.main.file.service.FileService;
import com.isfasiel.util.data.Data;

public class BaseController {
	
	@Resource(name="fileService")
	protected FileService fileService;
	
	@Autowired
	protected HttpServletRequest request;
	
	@Resource(name="pp.file")
	protected Properties fileProp;
	
		
	protected Data getParam() throws Exception{
		return new Data(request) ;
	}
	
	protected void addList(Model model, String name, Data data) {
		model.addAttribute(name, data.toList());
	}
	
	protected void addParam(Model model, Data data) {
		model.addAttribute("param", data.toList());
	}
	
	protected void addTagView(Model model, List<Data> data) {
		model.addAttribute("result", data.get(0).getRecord(0));
		model.addAttribute("tag", data.get(1).toList());
	}
	
	protected void addMap(Model model, String name, Data data) {
		addMap(model, name, data, 0);
	}
	
	protected void addMap(Model model, String name, Data data, int index) {
		model.addAttribute(name, data.getRecord(index));
	}
	
	protected void addString(Model model, String name, Data data) {
		model.addAttribute(name, data.toString());
	}
	
	protected void addJavaScript(Model model, String name, Data data) {
		model.addAttribute(name, data.toJSArray());
	}

	
	public String[] getMultiParam(String name, HttpServletRequest request) {
		return request.getParameterValues(name);
	}
	
	protected void linkFileMap(Data param) throws Exception{
		long contentId = param.getLong(0, "contentId");
		linkFileMap(param, contentId);
	}
	
	/**
	 * make a link between a content and a file
	 * @param param
	 * @param contentId
	 * @throws Exception
	 */
	protected void linkFileMap(Data param, long contentId) throws Exception{
		int size = param.size();
		
		int index =0;
		Data fileParam = new Data();
		for(int i =0; i < size; i++) {
			if( param.get(i, "fileId") != null) {
				fileParam.add(index, "contentId", contentId);
				fileParam.add(index, "fileId", param.get(i, "fileId"));
				index++;
			}
		}
		if( fileParam.size() == 0) {
			return;
		}
		fileService.insertFileMap(fileParam);
	}
	
	/**
	 * retrieve a list of files belong to a target content 
	 * @param cntId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected Object getFileList(long contentId) throws Exception{
		Data param = new Data();
		param.add("contentId", contentId);
		return fileService.getFileList(param);
	}
	
	protected String getBasePath() {
		return fileProp.getProperty("baseDir");
	}
	
	protected String getContextPath() {
		return request.getSession().getServletContext().getRealPath("/");
	}
	
}
