package com.isfasiel.main.comment.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.comment.service.CommentService;
import com.isfasiel.util.data.Data;

@Service("commentService")
public class CommentImpl implements CommentService {

	@Resource(name="commentDAO")
	private CommentDAO commentDAO;
	
	
	@Override
	public Data list(Data data) throws Exception {
		return commentDAO.listComment(data);
	}

	@Override
	public Data subList(Data data) throws Exception {
		return commentDAO.subListComment(data);
	}

	@Override
	public void craete(Data data) throws Exception {
		commentDAO.createComment(data);
	}

	@Override
	public void update(Data data) throws Exception {
		commentDAO.updateComment(data);
	}

	@Override
	public void delete(Data data) throws Exception {
		commentDAO.deleteComment(data);
	}

}
