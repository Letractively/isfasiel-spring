package com.isfasiel.main.content.realEstate.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.content.service.impl.ContentImpl;
import com.isfasiel.util.data.Data;

@Service("realEstateService")
public class RealEstateImpl extends ContentImpl{
	
	@Resource(name="realEstateDAO")
	RealEstateDAO realEstateDAO;
	

	@Override
	public void insertContent(Data data) throws Exception {
		realEstateDAO.insert(data);
		
	}

	@Override
	public Data selectContent(Data data) throws Exception {
		return realEstateDAO.select(data);
	}

	@Override
	public Data list(Data data) throws Exception {
		return realEstateDAO.list(data);
	}

	@Override
	public void updateContent(Data data) throws Exception {
		realEstateDAO.update(data);
		
	}
}
