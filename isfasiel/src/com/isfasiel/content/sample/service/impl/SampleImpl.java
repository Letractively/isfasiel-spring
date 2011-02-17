package com.isfasiel.content.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.content.sample.service.SampleService;
import com.isfasiel.content.sample.service.SampleVO;
import com.isfasiel.util.data.Data;

@Service("sampleService")
public class SampleImpl implements SampleService {

	@Resource(name="sampleDAO")
	SampleDAO sampleDAO;
	@Override
	public int update(SampleVO sampleVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void insert(Data data) throws Exception {
		sampleDAO.insert(data);
		
	}

}
