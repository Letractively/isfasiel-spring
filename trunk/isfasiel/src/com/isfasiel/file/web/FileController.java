package com.isfasiel.file.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isfasiel.base.web.BaseController;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.file.FileUtil;

/**
 * @Class Name : FileController.java
 * @Description : 파일 관리 컨트롤러
 * @Modification Information
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2010. 12. 14.	배병선
 * @author 배병선
 */
@Controller
public class FileController extends BaseController{
	@Autowired
	protected FileUtil fileUtil;
	
	/**
	 * @param fileVO
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/file/download.do")
	public void downloadFile(HttpServletResponse response) throws Exception {
		//String realPath = request.getSession().getServletContext().getRealPath("/")+ basePath;
		Data param = getParam();
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

}