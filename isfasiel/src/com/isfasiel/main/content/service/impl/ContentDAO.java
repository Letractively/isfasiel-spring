package com.isfasiel.main.content.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("contentDAO")
public class ContentDAO extends BaseDAO {
	
	protected Long getContentSeq() throws Exception{
		return getSeq("SEQ_TN_CONTENT");
	}
	
	public Long insertContent(Data data) throws Exception {
		Long contentId = getContentSeq();
		data.add(0, "contentId", contentId);
		insert("contentDAO.insert", data);
		return contentId;
	}
	
	public void updateContent(Data data) throws Exception {
		update("contentDAO.update", data);
	}
	
	public void deleteContent(Data data) throws Exception {
		update("contentDAO.delete", data);
	}
	
}
