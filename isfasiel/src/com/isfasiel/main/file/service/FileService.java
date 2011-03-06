package com.isfasiel.main.file.service;

import com.isfasiel.util.data.Data;

public interface FileService {
	/**
	 * 
	 * @param fileVO
	 * @return
	 * @throws Exception
	 */
	public Data insertFile(Data fileist) throws Exception;
	
	public void insertFileMap(Data data) throws Exception;
	
	/**
	 * 
	 * @param cntId
	 * @return
	 * @throws Exception
	 */
	public Data getFileList(Data data)  throws Exception;
	
	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public Data getFile(Data data) throws Exception;
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Data getDelFileList() throws Exception;
	
}
