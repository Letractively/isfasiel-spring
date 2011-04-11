package com.isfasiel.main.path.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("pathDAO")
public class PathDAO extends BaseDAO {

	public Data list() throws Exception{
		return list("pathDAO.list");
	}
	
	public void deletePath(Data data) throws Exception {
		delete("pathDAO.delete", data);
	}
	
	public void updatePath(Data data) throws Exception {
		deletePath(data);
		int size = data.size();
		for(int i =0; i < size; i++) {
			insert("pathDAO.insert", data.getRecord(i));
		}
	}
}
