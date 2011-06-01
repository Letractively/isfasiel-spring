package com.isfasiel.main.group.service.impl;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;	
import com.isfasiel.util.data.Data;

@Repository("groupDAO")
public class GroupDAO extends BaseDAO {

	@Resource(name="group.error")
	protected Properties groupProp;
	
	
	public Object insert(Data data) throws Exception {
		if( !list("groupDAO.checkName", data).isNull() ) {
			return groupProp.getProperty("DUPLICATED_NAME");
		}
		long groupId = getSeq("SEQ_TN_GROUP");
		data.add(0, "groupId", groupId);
		insert("groupDAO.insert", data);
		return insert("groupDAO.insertMap", data);
	}
	
	public int update(Data data) throws Exception {
		if( list("groupDAO.checkName", data).isNull() ) {
			return -1;
		}
		return update("groupDAO.update", data);
	}
	
	public int delete(Data data) throws Exception {
		return delete("groupDAO.delete", data);
	}
	
	public Data list(Data data) throws Exception {
		return list("groupDAO.list", data);
	}
	
	public Data viewMyGroupList(Data data) throws Exception {
		return list("groupDAO.myList", data);
	}
}
