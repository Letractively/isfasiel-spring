package com.isfasiel.main.file.service;

import com.isfasiel.util.data.Data;

/**
 * 
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.file.service
 * @FileName  : DirService.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
public interface DirService {
	/**
	 * 
	 * @param realPath
	 * @param dirVO
	 * @return
	 * @throws Exception
	 */
	public Data insertDir(String realPath, Data data) throws Exception;
}
