package com.isfasiel.main.groupPath.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.groupPath.service.GroupPathService;
import com.isfasiel.util.data.Data;

@Service("groupPathService")
public class GroupPathImpl implements GroupPathService {
	
	@Resource(name="groupPathDAO")
	GroupPathDAO groupPathDAO;
	
	@Override
	public Object insert(Data data) throws Exception {
		return groupPathDAO.insert(data);
	}

	@Override
	public int update(Data data) throws Exception {
		return groupPathDAO.update(data);
	}

	@Override
	public int delete(Data data) throws Exception {
		return groupPathDAO.delete(data);
	}

	@Override
	public Data list(Data data) throws Exception {
		return groupPathDAO.list(data);
	}

		
}
