package com.isfasiel.main.groupPath.service.impl;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("groupPathDAO")
public class GroupPathDAO extends BaseDAO {
	
	@Resource(name="groupPath.error")
	private Properties groupPathProp;
	
	
	public Object insert(Data data) throws Exception {
		if( list("groupPathDAO.checkName", data).isNull() ) {
			return groupPathProp.getProperty("DUPLICATED_NAME");
		}
		long pathId = getSeq("SEQ_TN_PATH");
		data.add(0, "pathId", pathId);
		insert("groupPathDAO.insertMap", data);
		return insert("groupPathDAO.insert", data);
	}
	
	public int update(Data data) throws Exception {
		if( list("groupPathDAO.checkName", data).isNull() ) {
			return -1;
		}
		return update("groupPathDAO.update", data);
	}
	
	public int delete(Data data) throws Exception {
		
		return update("groupPathDAO.delete", data);
	}
	
	public Data list(Data data) throws Exception {
		return list("groupPathDAO.delete", data);
	}
}
