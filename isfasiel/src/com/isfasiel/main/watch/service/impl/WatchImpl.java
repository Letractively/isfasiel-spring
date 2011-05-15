package com.isfasiel.main.watch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.main.watch.service.WatchService;
import com.isfasiel.util.data.Data;

@Service("watchService")
public class WatchImpl implements WatchService {

	@Resource(name="watchDAO")
	protected WatchDAO watchDAO;
	
	@Override
	public void insertWatch(Data data) throws Exception {
		watchDAO.insertWatch(data);
	}

	@Override
	public void deleteWatch(Data data) throws Exception {
		watchDAO.deleteWatch(data);
	}

	@Override
	public Data listWatch(Data data) throws Exception {
		return watchDAO.listWatch(data);
	}

}
