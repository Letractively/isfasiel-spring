package com.isfasiel.main.content.movie.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("movieDAO")
public class MovieDAO extends BaseDAO {
	public void insert(Data data) throws Exception {
		insert("movieDAO.insert", data);
	}
	
	public void update(Data data) throws Exception {
		update("movieDAO.update", data);
	}
	
	public Data select(Data data) throws Exception {
		return select("movieDAO.select", data);
	}
	
	public Data list(Data data) throws Exception {
		return list("movieDAO.list", data);
	}
	
	public Data listAll(Data data) throws Exception {
		return list("movieDAO.listAll", data);
	}
}
