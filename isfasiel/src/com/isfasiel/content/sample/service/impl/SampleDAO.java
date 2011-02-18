package com.isfasiel.content.sample.service.impl;


import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.content.sample.service.SampleVO;
import com.isfasiel.util.data.Data;

@Repository("sampleDAO")
public class SampleDAO extends BaseDAO{

	//@Transactional(readOnly=true)
	public void insert(Data param) throws Exception{
		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(1);
		sampleVO.setName("test");
		this.getSqlMapClientTemplate().insert("sampleDAO.insert", sampleVO);
		 //this.getSqlMapClientTemplate().insert("sampleDAO.insert", sampleVO);
		//String query = "sampleDAO.Select";
		//System.out.println(param);
		//System.out.println(param.toJSArray());
		

	}
}
