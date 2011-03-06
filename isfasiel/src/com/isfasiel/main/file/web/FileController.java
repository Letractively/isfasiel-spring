package com.isfasiel.main.file.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.main.file.service.DirService;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.file.DateUtil;
import com.isfasiel.util.file.DirUtil;
import com.isfasiel.util.file.FileUtil;

/**
 * @Class Name : FileController.java
 * @Description : ���� ���� ��Ʈ�ѷ�
 * @Modification Information
 * @  ������	  ������			  ��������
 * @ ---------   ---------   -------------------------------
 * @ 2010. 12. 14.	�躴��
 * @author �躴��
 */
@Controller
public class FileController extends BaseController {
	
	
	@Resource(name="dirService")
	protected DirService dirService;
	
	@Autowired
	protected FileUtil fileUtil;
	
	@Autowired
	protected DirUtil dirUtil;
	
	@Autowired
	protected DateUtil dateUtil;
	
	/**
	 * @param fileVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/file/download/{fileId}")
	public void downloadFile(@PathVariable("fileId") Long fileId, HttpServletResponse response) throws Exception {
		//String realPath = request.getSession().getServletContext().getRealPath("/")+ basePath;
		Data param = new Data();
		param.add("fileId", fileId);
		String ids = param.getString("fileId");
		ids = ids.replaceAll("\r", "");
		ids = ids.replaceAll("\n", "");
		if (ids.contains(";")) {
			ids = ids.substring(0, ids.indexOf(";"));
		} 
		param.add("fileId", Integer.parseInt(ids));
		
		Data result = fileService.getFile(param);
		fileUtil.downloadFile(response, 
				request, 
				result.getString("dirType") + "/" + result.getString("phyPath"), 
				result.getString("phyName"), 
				result.getString("fileName"));
		
	}
	
	/**
	 * ���丮 ������ �����Ѵ�.
	 * @param realPath
	 * @return
	 * @throws Exception
	 */
	protected void setDirInfo(String type) throws Exception{
		Data dir = new Data();
		if(dirUtil.getDirId() == -1) {
			dir.add(0, "phyPath", dateUtil.dateToPath());
			dir.add(0, "dirType", type);
			dir = dirService.insertDir(getBasePath(), dir);
			dirUtil.setDirId(dir.getLong(0, "dirId"));
			dirUtil.setPhyPath(dir.getString(0, "phyPath"));
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
	@RequestMapping(value="/file/upload.do")
	public String uploadFiles(HttpServletRequest request, Model model) throws Exception {
		setDirInfo("N");
		
		Data files =  fileUtil.uploadFiles(	request, 
											dirUtil.getDirType() + "/" + dirUtil.getPhyPath(), 
											dirUtil.getDirId()
										);
		
		int size = files.size();
		
		for(int i =0; i < size; i++) {
			files.add(i, "fileType", "A");
		}
		files = fileService.insertFile(files);
		
		Data param = new Data();
		for(int i = 0; i< size; i++) {
			param.add(i, "fileId", files.getString(i, "fileId"));
			param.add(i, "fileName", files.getString(i, "fileName"));
		}
		files = null;
		addJavaScript(model, "fileList", param);
		
		return "file/upload";
	}
	
	@RequestMapping(value="/file/viewUpload.do") 
	public String viewUpload(Model model) throws Exception {
		
		addJavaScript(model, "fileList", getParam());
		return "file/upload";
	}
	
	
}