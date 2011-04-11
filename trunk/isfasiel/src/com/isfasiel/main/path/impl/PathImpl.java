package com.isfasiel.main.path.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.path.service.PathService;
import com.isfasiel.util.data.Data;

@Service("pathService")
public class PathImpl implements PathService {
	@Resource(name="pathDAO")
	private PathDAO pathDAO;
	
	@Override
	public Data list() throws Exception {
		return pathDAO.list();
	}

}
