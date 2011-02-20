package com.isfasiel.file.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.util.data.Data;

/**
 * 
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.file.service.impl
 * @FileName  : DirDAO.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
@Repository("dirDAO")
public class DirDAO extends BaseDAO {
	
	public int insertDir(Data data) throws Exception {
		Integer dirId = (Integer)getSqlMapClientTemplate().queryForObject("DirDAO.checkDir", data);
		if( dirId == null) {
			insert("DirDAO.insertDir", data.getRecord(0));
			dirId = (Integer)getSqlMapClientTemplate().queryForObject("DirDAO.checkDir", data);
			return dirId;
		} else {
			return dirId;
		}
	}
	
	public void updateDir(Data data) throws Exception {
		update("DirDAO.updateDir", data);
	}
	
	public void deleteDir(Data data) throws Exception {
		delete("DirDAO.deleteDir", data);
	}
	
	public Data selectDir(Data data) throws Exception {
		return list("DirDAO.selectDir", data);
	}
	
	public Data selectDirList(Data data) throws Exception {
		return list("DirDAO.listDir", data);
	}
}
