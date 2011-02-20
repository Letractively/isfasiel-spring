package com.isfasiel.base.web;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.isfasiel.file.service.DirService;
import com.isfasiel.file.service.FileService;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.file.DateUtil;
import com.isfasiel.util.file.DirUtil;
import com.isfasiel.util.file.FileUtil;

public class BaseController {
	
	@Autowired
	protected HttpServletRequest request;
	
	@Resource(name="pp.file")
	protected Properties fileProp;
	
	@Autowired
	protected FileUtil fileUtil;
	
	@Autowired
	protected DateUtil dateUtil;
	
	@Autowired
	protected DirUtil dirUtil;
	
	@Resource(name="fileService")
	protected FileService fileService;
	
	@Resource(name="dirService")
	protected DirService dirService;
	
	protected Data getParam() throws Exception{
		return new Data(request) ;
	}
	
	protected void addList(Model model, String name, Data data) {
		model.addAttribute(name, data.toList());
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
	
	/**
	 * 디렉토리 정보를 생성한다.
	 * @param realPath
	 * @return
	 * @throws Exception
	 */
	protected void setDirInfo(String type) throws Exception{
		Data dir = new Data();
		if(dirUtil.getDirId() == -1) {
			
			dir.add(0, "phyPath", dateUtil.dateToPath());
			dir = dirService.insertDir(getBasePath(), dir);
			dirUtil.setDirId(dir.getLong(0, "dirId"));
			dirUtil.setPhyName(dir.getString(0, "phyPatn"));
			dirUtil.setDirType(dir.getString(0, "dirType"));
		}
		dir = null;
	}
	
	/**
	 * upload files into the server
	 * @param request
	 * @param userId
	 * @param cntId
	 * @throws Exception
	 */
	protected Data uploadFiles() throws Exception {
		Data param = getParam();
		setDirInfo("N");
		
		Data files =  fileUtil.uploadFiles(	request, 
											dirUtil.getDirType() + "/" + dirUtil.getPhyPath(), 
											dirUtil.getDirId()
										);
		int size = param.size();
		for(int i =0; i < size; i++) {
			param.add(i, "fileType", "A");
		}
		return fileService.insertFile(files);
		
	}
	
	/**
	 * make a link between a content and a file
	 * @param param
	 * @param contentId
	 * @throws Exception
	 */
	protected void linkFileMap(Data param, long contentId) throws Exception{
		int size = param.size();
		for(int i =0; i < size; i++) {
			param.add(i, "contentId", contentId);
			
		}
		fileService.insertFileMap(param);
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
	
}
