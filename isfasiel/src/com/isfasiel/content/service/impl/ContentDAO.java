package com.isfasiel.content.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.BaseDAO;
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
	
	
}
