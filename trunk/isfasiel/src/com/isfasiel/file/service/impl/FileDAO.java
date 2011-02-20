package com.isfasiel.file.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.util.data.Data;

/**
 * 
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.file.service.impl
 * @FileName  : FileDAO.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
@Repository("fileDAO")
public class FileDAO extends BaseDAO {
	/**
	 * insert a file information into only a tn_file table.
	 * @param fileVOList
	 */
	public Data insertFile(Data data) throws Exception{
		int size = data.size();
		for( int i=0; i < size; i++) {
			if(data.getString(i, "delYn").equals("Y")) {
				update("FileDAO.updateMap", data.getRecord(i));
			} else {
				Long fileId = getSeq("SEQ_TN_FILE");
				data.add(i, "fileId", fileId);
				insert("FileDAO.insertFile", data.getRecord(i));
			}
		}
		return data;
	}
	
	/**
	 * make a mapping information between tn_content and tn_file
	 * @param data
	 * @throws Exception
	 */
	public void insertFileMap(Data data) throws Exception {
		Long contentId = data.getLong(0, "contentId");
		int size = data.size();
		for(int i=0; i < size; i++) {
			data.add(i, "contentId", contentId);
			insert("FileDAO.insertMap", data.getRecord(i));
		}
		
	}
	
	/**
	 * get a list of files which included in a content.
	 * @param fileVO
	 * @return
	 */
	public Data getFileList(Data data) throws Exception{
		return list("FileDAO.getFileLIST", data);
	}
	
	/**
	 * get an information of a file
	 * @param fileVO
	 * @return
	 */
	public Data getFile(Data fileVO) throws Exception{
		update("FileDAO.updateViewCount", fileVO);
		return list("FileDAO.getFile", fileVO);
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public Data getDelFileList() throws Exception {
		return list("FileDAO.getDelFileList");
	}
	
}
