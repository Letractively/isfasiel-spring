package com.isfasiel.main.content.service;

import java.util.List;

import com.isfasiel.util.data.Data;

public interface ContentService {

	public Long insert(Data data) throws Exception;
	
	public void update(Data data) throws Exception;
	
	public void delete(Data data) throws Exception;
	
	public List<Data> select(Data data) throws Exception;
	
	public Data list(Data data) throws Exception;
	
}
