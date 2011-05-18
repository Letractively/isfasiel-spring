package com.isfasiel.main.groupPath.service;

import com.isfasiel.util.data.Data;

public interface GroupPathService {

	public Object insert(Data data) throws Exception;
	
	public int update(Data data) throws Exception;
	
	public int delete(Data data) throws Exception;
	
	public Data list(Data data) throws Exception;
}
