package com.isfasiel.file.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isfasiel.file.service.FileService;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.file.FileUtil;

/**
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.file.service.impl
 * @FileName  : FileImpl.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
@Service("fileService")
public class FileImpl implements FileService {
	
	@Autowired
	protected FileUtil fileUtil;
	
	@Resource(name="fileDAO")
	private FileDAO fileDAO;
	
	public Data insertFile(Data fileList) throws Exception {
		return fileDAO.insertFile(fileList);
	}

	public Data getFileList(Data file) throws Exception {
		return fileDAO.getFileList(file);
	}
	
	public Data getFile(Data file) throws Exception {
		return fileDAO.getFile(file);
	}

	public Data getDelFileList() throws Exception {
		
		return fileDAO.getDelFileList();
	}

	public void insertFileMap(Data data) throws Exception {
		fileDAO.insertFileMap(data);
	}
	
}
