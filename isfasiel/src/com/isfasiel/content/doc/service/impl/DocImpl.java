package com.isfasiel.content.doc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.content.service.impl.ContentImpl;
import com.isfasiel.util.data.Data;

@Service("docService")
public class DocImpl extends ContentImpl {

	@Resource(name="docDAO")
	DocDAO docDAO;

	@Override
	public void insertContent(Data data) throws Exception {
		docDAO.insert(data);
	}

	@Override
	public void updateContent(Data data) throws Exception {
		docDAO.update(data);
	}

	@Override
	public Data selectContent(Data data) throws Exception {
		return docDAO.select(data);
	}

	@Override
	public Data list(Data data) throws Exception {
		return docDAO.list(data);
	}
}
