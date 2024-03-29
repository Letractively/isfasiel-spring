package com.isfasiel.main.content.job.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.content.service.impl.ContentImpl;
import com.isfasiel.util.data.Data;

@Service("jobService")
public class JobImpl extends ContentImpl {

	@Resource(name="jobDAO")
	JobDAO jobDAO;
	
	@Override
	public void insertContent(Data data) throws Exception {
		jobDAO.insert(data);

	}

	@Override
	public void updateContent(Data data) throws Exception {
		jobDAO.update(data);
	}

	@Override
	public Data selectContent(Data data) throws Exception {
		return jobDAO.select(data);
	}

	@Override
	public Data list(Data data) throws Exception {
		return jobDAO.list(data);
	}

}
