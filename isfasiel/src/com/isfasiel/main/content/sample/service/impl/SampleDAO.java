package com.isfasiel.main.content.sample.service.impl;


import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("sampleDAO")
public class SampleDAO extends BaseDAO{

	//@Transactional(readOnly=true)
	public Data insert(Data param) throws Exception{
		System.out.println(param);
		Data result = list("sampleDAO.Select", param.getRecord(0));
		this.getSqlMapClientTemplate().insert("sampleDAO.insert", param.getRecord(0));
		
		
		System.out.println(result);
		System.out.println(result.toJSArray());
		//this.getSqlMapClientTemplate().insert("sampleDAO.insert", param.getRecord(0));
		return result;
	}
}