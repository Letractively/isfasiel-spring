package com.isfasiel.content.doc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.content.doc.service.DocService;
import com.isfasiel.util.data.Data;

@Service("docService")
public class DocImpl implements DocService {

	@Resource(name="docDAO")
	DocDAO docDAO;
	
	@Override
	public Long insert(Data data) throws Exception {
		return docDAO.insert(data);
	}

}
