package com.isfasiel.main.content.movie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.content.service.impl.ContentImpl;
import com.isfasiel.util.data.Data;

@Service("movieService")
public class MovieImpl extends ContentImpl {

	@Resource(name="movieDAO")
	MovieDAO movieDAO;
	
	@Override
	public void insertContent(Data data) throws Exception {
		movieDAO.insert(data);
	}

	@Override
	public void updateContent(Data data) throws Exception {
		movieDAO.update(data);
	}

	@Override
	public Data selectContent(Data data) throws Exception {
		return movieDAO.select(data);
	}

	@Override
	public Data list(Data data) throws Exception {
		return movieDAO.list(data);
	}

}
