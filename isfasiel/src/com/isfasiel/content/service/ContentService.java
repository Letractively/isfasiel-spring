package com.isfasiel.content.service;

import com.isfasiel.util.data.Data;

public interface ContentService {

	public Long insertContent(Data data) throws Exception;
	
	public Long updateContent(Data data) throws Exception;
	
	public boolean deleteContent(Data data) throws Exception;
	
	public Data selectContent(Data data) throws Exception;
	
	public Data listContent(Data data) throws Exception;
	
}
