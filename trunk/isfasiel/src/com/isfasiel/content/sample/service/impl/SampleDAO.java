package com.isfasiel.content.sample.service.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("sampleDAO")
public class SampleDAO extends BaseDAO{

	@Transactional(readOnly=false)
	public void insert(Data param) throws Exception{
		 //this.getSqlMapClientTemplate().insert("sampleDAO.insert", sampleVO);
		String query = "sampleDAO.Select";
		System.out.println(param);
		System.out.println(param.toJSArray());
		

	}
}
