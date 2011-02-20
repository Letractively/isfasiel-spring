package com.isfasiel.base.DAO.content;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.util.data.Data;

public class ContentDAO extends BaseDAO {
	protected Long getContentSeq() throws Exception{
		return getSeq("SEQ_TN_CONTENT");
	}
	
	protected void insertContent(Data data) throws Exception{
		insert("contentDAO.insert", data);
	}
}
