package com.isfasiel.content.service;

import java.util.HashMap;

import com.isfasiel.util.data.Data;

public interface ContentService {

	public Long insert(Data data) throws Exception;
	
	public void update(Data data) throws Exception;
	
	public void delete(Data data) throws Exception;
	
	public HashMap<String, Object> select(Data data) throws Exception;
	
	public Data list(Data data) throws Exception;
	
}
