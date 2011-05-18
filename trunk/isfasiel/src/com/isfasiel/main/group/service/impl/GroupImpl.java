package com.isfasiel.main.group.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.group.service.GroupService;
import com.isfasiel.util.data.Data;

@Service("groupService")
public class GroupImpl implements GroupService{

	@Resource(name="groupDAO")
	GroupDAO groupDAO;
	
	@Override
	public Object insert(Data data) throws Exception {
		return groupDAO.insert(data);
	}

	@Override
	public int update(Data data) throws Exception {
		return groupDAO.update(data);
	}

	@Override
	public int delete(Data data) throws Exception {
		return groupDAO.delete(data);
	}

	@Override
	public Data list(Data data) throws Exception {
		return groupDAO.list(data);
	}

	@Override
	public Data viewMyGroupList(Data data) throws Exception {
		return groupDAO.viewMyGroupList(data);
	}
	
}
