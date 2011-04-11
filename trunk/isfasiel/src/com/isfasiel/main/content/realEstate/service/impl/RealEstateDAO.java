package com.isfasiel.main.content.realEstate.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("realEstateDAO")
public class RealEstateDAO extends BaseDAO {
	public Data list(Data data) throws Exception {
		return list("realEstateDAO.list", data);
	}
	
	public Data select(Data data) throws Exception {
		return select("realEstateDAO.select", data);
	}
	
	public int update(Data data) throws Exception {
		return update("realEstateDAO.update", data);
	}
	
	public void insert(Data data) throws Exception {
		insert("realEstateDAO.insert", data);
	}
}
