package com.isfasiel.util;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.isfasiel.util.data.Data;

@Component
public class ObjectUtil {
	
	public  Timestamp toTimestamp(Object value){
		try {
			if (value instanceof Timestamp) {
				return (Timestamp)value;
			}
			return null;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
	
	public  String toString(Object value){
		try {
			if (value == null) {
				return ""; 
			} else if (value instanceof String) {
				return (String)value;
			} else {
				return value.toString();
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public  String[] toStringList(Object[] values) {
		String[] strObject = new String[values.length];
		for(int i=0; i<strObject.length; i++) {
			strObject[i] = toString(values[i]);
		}
		return strObject;
	}
	
	public  String[] toStringList(Data values, String columnName) {
		String[] strValues = new String[values.size()];
		for(int i=0; i<strValues.length; i++) {
			strValues[i] = toString(values.get(i, columnName));
		}
		return strValues;
	}
	
	public  int toInt(Object value){
		try {
			if (value instanceof Integer) {
				return ((Integer)value).intValue();
			}
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public  double toDouble(Object value){
		try {
			if (value instanceof Double) {
				return ((Double)value).doubleValue();
			}
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public  float toFloat(Object value){
		try {
			if (value instanceof Float) {
				return ((Float)value).floatValue();
			}
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public  long toLong(Object value){
		try {
			if (value instanceof Long ) {
				return ((Long)value).longValue();
			} else if (value instanceof BigDecimal) {
				return ((BigDecimal)value).longValue();
			} else if (value instanceof Integer) {
				return ((Integer)value).longValue();
			}
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public  boolean toBoolean(Object value){
		try {
			if (value instanceof Boolean) {
				return ((Boolean)value).booleanValue();
			}
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
