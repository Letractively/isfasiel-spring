package com.isfasiel.main.watch.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("watchDAO")
public class WatchDAO extends BaseDAO {
	public void insertWatch(Data data) throws Exception {
		insert("watchDAO.insert", data);
	}
	
	public void deleteWatch(Data data) throws Exception {
		delete("watchDAO.delete", data);
	}
	
	public Data listWatch(Data data) throws Exception {
		return list("watchDAO.list", data);
	}
	
}
