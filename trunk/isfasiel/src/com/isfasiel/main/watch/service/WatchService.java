package com.isfasiel.main.watch.service;

import com.isfasiel.util.data.Data;

public interface WatchService {

	public void insertWatch(Data data) throws Exception;
	public void deleteWatch(Data data) throws Exception;
	public Data listWatch(Data data) throws Exception;
}
