package com.isfasiel.main.comment.service;

import com.isfasiel.util.data.Data;

public interface CommentService {
	public Data list(Data data) throws Exception;
	public Data subList(Data data) throws Exception;
	public void craete(Data data) throws Exception;
	public void update(Data data) throws Exception;
	public void delete(Data data) throws Exception;
}
