package com.isfasiel.util;

import org.springframework.stereotype.Component;

@Component
public class ParamUtil {
	public String toNumList(long[] value) {
		if(value.length == 0) {return "";}
		String list = "";
		int i = 0;
		for(i=0; i< value.length -1; i++) {
			list += ((Long)value[i]).toString();
			list +=", ";
		}
		list += ((Long)value[i]).toString();
		return list;
	}
	
	public String toNumList(long[] value, int limit) {
		if(value.length == 0) {return "";}
		String list = "";
		int i = 0;
		for(i=0; i< limit -1; i++) {
			list += ((Long)value[i]).toString();
			list +=", ";
		}
		list += ((Long)value[i]).toString();
		return list;
	}
	
	public String toNumList(int[] value) {
		if(value.length == 0) {return "";}
		String list = "";
		int i = 0;
		for(i=0; i< value.length -1; i++) {
			list += ((Integer)value[i]).toString();
			list +=", ";
		}
		list += ((Integer)value[i]).toString();
		return list;
	}
	
	public String toNumList(int[] value, int limit) {
		if(value.length == 0) {return "";}
		String list = "";
		int i = 0;
		for(i=0; i< limit -1; i++) {
			list += ((Integer)value[i]).toString();
			list +=", ";
		}
		list += ((Integer)value[i]).toString();
		return list;
	}
	
	public String toStingList(String[] value) {
		if(value.length == 0) {return "";}
		String list = "'";
		int i = 0;
		for(i=0; i< value.length -1; i++) {
			list += value[i];
			list +="', '";
		}
		list += value[i];
		list += "'";
		return list;
	}
	
	public String toStingList(String[] value, int limit) {
		if(value.length == 0) {return "";}
		String list = "'";
		int i = 0;
		for(i=0; i< limit -1; i++) {
			list += value[i];
			list +="', '";
		}
		list += value[i];
		list += "'";
		return list;
	}
}
