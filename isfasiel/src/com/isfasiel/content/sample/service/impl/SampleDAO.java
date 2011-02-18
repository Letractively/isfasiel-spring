package com.isfasiel.content.sample.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.util.data.Data;

@Repository("sampleDAO")
public class SampleDAO extends BaseDAO{

	//@Transactional(readOnly=true)
	public Data insert(Data param) throws Exception{
		System.out.println(param);
		Data result = new Data((List<HashMap<String, Object>>)this.getSqlMapClientTemplate().queryForList("sampleDAO.Select"));
		System.out.println(result);
		System.out.println(result.toJSArray());
		this.getSqlMapClientTemplate().insert("sampleDAO.insert", param.getRecord(0));
		return result;
	}
}
