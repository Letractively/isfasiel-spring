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
	
	public long insertDir(Data data) throws Exception {
		Long dirId = (Long)getSqlMapClientTemplate().queryForObject("DirDAO.checkDir", data.getRecord(0));
		if( dirId == null) {
			dirId = getSeq("SEQ_TN_DIR");
			data.add(0, "dirId", dirId);
			insert("DirDAO.insertDir", data.getRecord(0));
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
