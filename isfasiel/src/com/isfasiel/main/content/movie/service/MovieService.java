package com.isfasiel.main.content.movie.service;

import com.isfasiel.main.content.service.ContentService;
import com.isfasiel.util.data.Data;

public interface MovieService extends ContentService {

	public Data listAll(Data data) throws Exception;
}
