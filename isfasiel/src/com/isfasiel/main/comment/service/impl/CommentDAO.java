package com.isfasiel.main.comment.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("commentDAO")
public class CommentDAO extends BaseDAO {

	public Data listComment(Data data) throws Exception {
		return list("commentDAO.list", data);
	}
	
	public Data subListComment(Data data) throws Exception {
		return select("commentDAO.subList", data);
	}
	
	public int updateComment(Data data) throws Exception {
		return update("commentDAO.update", data);
	}
	
	public void createComment(Data data) throws Exception {
		long idx = getSeq("SEQ_TN_COMMENT");
		data.add(0,"commentId",idx);
		insert("commentDAO.insertComment", data);
		insert("commentDAO.insertMap", data);
	}
	
	public int deleteComment(Data data) throws Exception {
		delete("commentDAO.deleteCmt", data);
		return delete("commentDAO.deleteMap", data);
	}
}
