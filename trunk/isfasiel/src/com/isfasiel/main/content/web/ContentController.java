package com.isfasiel.main.content.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.isfasiel.main.base.web.BaseController;
import com.isfasiel.main.file.service.DirService;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.file.DateUtil;
import com.isfasiel.util.file.DirUtil;
import com.isfasiel.util.file.FileUtil;
import com.isfasiel.util.page.PageUtil;

public class ContentController extends BaseController {
	
	@Autowired
	protected PageUtil pageUtil;
	

	@Resource(name="dirService")
	protected DirService dirService;
	
	@Autowired
	protected FileUtil fileUtil;
	
	@Autowired
	protected DirUtil dirUtil;
	
	@Autowired
	protected DateUtil dateUtil;
	
	
	/**
	 * generate a director information.
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
	public Data uploadFiles(HttpServletRequest request, long contentId) throws Exception {
		setDirInfo("N");
		
		Data files =  fileUtil.uploadFiles(	request, 
											dirUtil.getDirType() + "/" + dirUtil.getPhyPath(), 
											dirUtil.getDirId()
										);
		
		if( files.isNull()) {
			return new Data();
		}
		files.add(0, "contentId", contentId);
		
		
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
		return param;

		
	}

	public Data getPageParam(int page, int pageSize) throws Exception{
		Data param = getParam();
		param.setPageSize(pageSize);
		param.setPage(page);
		param.add(0,"page", page);
		param.add(0,"pageSize", pageSize);
		param = pageUtil.getRowSize(param);
		return param;
	}
	
	public Data toFileData(List<Data> result) throws Exception{
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
		return result.get(0);
	}
	
}
