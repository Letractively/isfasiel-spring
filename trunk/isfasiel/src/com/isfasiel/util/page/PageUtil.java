package com.isfasiel.util.page;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.isfasiel.util.data.Data;

@Component
public class PageUtil {

	@Resource(name="pp.page")
	protected Properties properties;
	
	protected int pageSize = 0; 
	protected int labelSize = 0;
	protected String form = null;
	
	public String buildNavi() {
		if( pageSize == 0) {
			pageSize = Integer.parseInt(properties.getProperty("pageSize"));
			labelSize = Integer.parseInt(properties.getProperty("labelSize"));
		}
		return "";
		
	}
	
	public int getPageSize() {
		if( pageSize == 0) {
			pageSize = Integer.parseInt(properties.getProperty("pageSize"));
		}
		return pageSize;
	}
	
	public int getLabelSize() {
		if( labelSize == 0) {
			labelSize = Integer.parseInt(properties.getProperty("labelSize"));
		}
		return labelSize; 
	}
	
	public Data getRowSize(Data param) {
		int page = param.getPage();
		int pageSize = param.getPageSize();
		if( pageSize < 1) {
			pageSize = getPageSize();
		}
		int firstIndex = page * pageSize;
		
		int lastIndex = firstIndex + pageSize -1;
		param.add(0, "firstIndex", firstIndex);
		param.add(0, "lastIndex", lastIndex);
		return param;
	}
	
	
}
