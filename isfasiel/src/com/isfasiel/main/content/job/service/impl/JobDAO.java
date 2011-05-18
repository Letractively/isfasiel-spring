package com.isfasiel.main.content.job.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("jobDAO")
public class JobDAO extends BaseDAO {
	
	public void insert(Data data) throws Exception {
		insert("jobDAO.insert", data);
	}
	
	public void update(Data data) throws Exception {
		update("jobDAO.update", data);
	}
	
	public Data select(Data data) throws Exception {
		return select("jobDAO.select", data);
	}
	
	public Data list(Data data) throws Exception {
		return list("jobDAO.list", data);
	}
}
