package com.isfasiel.util;

import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isfasiel.util.data.Data;

@Component
public class Text {
	@Autowired
	ObjectUtil objectUtil;
	public boolean isNull(String value) {
		try {
			if(value == null) {
				return true;
			} else if(value.length() == 0 || value.isEmpty() == true) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public final String ifNull(String s, String nv) {
    	return isNull(s) ? nv : s;
    }
	
	public final String ifNull(Object s, String nv) {
    	return s == null ? nv : s.toString();
    }
	
	public boolean overLength(String value, int length) {
		try {
			if(isNull(value) == true) {
				return false;
			} else if(value.length() > length) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isSpace(String value) {
		try {
			if(value.trim().length() == 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isOk(String value) {
		if(isNull(value) == true) {return false;}
		if(isSpace(value) == true) {return false;}
		return true;
	}
	
	public String areOk(String ... values) {
		for(int i=0; i<values.length; i++)
			if(isOk(values[i]) == false){
				return values[i];
			}
		return null;
	}
	
	public String[] toUnique(String[] stringList) {
		String[] changedList = null;
		List<String> checkedList = new ArrayList<String>();
		boolean isDuplicated = false;
		int length = stringList.length;
		for(int i=0; i < length; i++) {
			for(int j=0; j< i; j++) {
				if( stringList[i].equalsIgnoreCase(stringList[j]) ) {
					isDuplicated = true;
				}
			}
			if(!isDuplicated) {
				checkedList.add(stringList[i]);
			}
			isDuplicated = false;
		}
		changedList = new String[checkedList.size()];
		for(int i=0; i < checkedList.size(); i++) {
			changedList[i] = checkedList.get(i);
		}
		return changedList;
	}
	
	public String[] and(String[] comparedList, Data values, String columnName) {
		return and(comparedList, objectUtil.toStringList(values, columnName));
	}
	
	public String[] and(String[] comparedList, Object[] values){
		return and(comparedList, objectUtil.toStringList(values));
	}
	
	public String[] and(String[] comparedList, String[] values) {
		String[] strResult = new String[]{};
		int i = 0, j = 0;
		for(i=0; i<comparedList.length; i++) {
			for(j=0; j<values.length; j++) {
				if(comparedList[i].equals(values[j]) == true) {
					strResult = add(strResult, comparedList[i]); 
				}
			}
		}
		return strResult;
	}
	
	public String[] andC(Data comparedList, String[] values, String columnName) {
		return andC(objectUtil.toStringList(comparedList, columnName) , values);
	}
	
	public String[] andC(Data comparedList, Object[] values, String columnName) {
		return andC(objectUtil.toStringList(comparedList, columnName) , values);
	}
	
	public String[] andC(String[] comparedList, Data values, String columnName) {
		return andC(comparedList, objectUtil.toStringList(values, columnName));
	}
	
	public String[] andC(String[] comparedList, Object[] values){
		return andC(comparedList, objectUtil.toStringList(values));
	}
	
	public String[] andC(String[] comparedList, String[] values) {
		String[] strResult = null;
		int i = 0, j = 0;
		for(i=0; i<comparedList.length; i++) {
			for(j=0; j<values.length; j++) {
				if(comparedList[i].toUpperCase().equals(values[j].toUpperCase()) == true) {
					strResult = add(strResult, comparedList[i]); 
				}
			}
		}
		return strResult;
	}
	
	public String[] notAnd(Data comparedList, String[] values, String columnName) {
		return notAnd(objectUtil.toStringList(comparedList, columnName), values);
	}
	
	public String[] notAnd(String[] comparedList, Data values, String columnName) {
		return notAnd(comparedList, objectUtil.toStringList(values, columnName));
	}
	
	public String[] notAnd(String[] comparedList, Object[] values){
		return notAnd(comparedList, objectUtil.toStringList(values));
	}
	
	public String[] notAnd(String[] comparedList, String[] values) {
		String[] strResult = null;
		int i = 0, j = 0;
		boolean in = false;
		for(i=0; i<comparedList.length; i++) {
			for(j=0; j<values.length; j++) {
				if(comparedList[i].equals(values[j]) == true) {
					in = true;
				}
			}
			if(in == false) {
				strResult = add(strResult, comparedList[i]);
			} else {
				in = false;
			}
		}
		return strResult;
	}
	
	public String[] notAndC(Object[] comparedList, Data values, String columnName) {
		return notAndC(comparedList, objectUtil.toStringList(values, columnName));
	}
	
	public String[] notAndC(String[] comparedList, Data values, String columnName) {
		return notAndC(comparedList, objectUtil.toStringList(values, columnName));
	}
	
	public String[] notAndC(Data comparedList, String[] values, String columnName) {
		return notAndC(objectUtil.toStringList(comparedList, columnName), values);
	}
	
	public String[] notAndC(Object[] comparedList, String[] values){
		return notAndC(objectUtil.toStringList(comparedList), values);
	}
	
	public String[] notAndC(String[] comparedList, Object[] values){
		return notAndC(comparedList, objectUtil.toStringList(values));
	}
	
	public String[] notAndC(String[] comparedList, String[] values) {
		String[] strResult = null;
		int i = 0, j = 0;
		boolean in = false;
		for(i=0; i<comparedList.length; i++) {
			for(j=0; j<values.length; j++) {
				if(comparedList[i].toUpperCase().equals(values[j].toUpperCase()) == true) {
					in = true;
				}
			}
			if(in == false) {
				strResult = add(strResult, comparedList[i]);
			} else {
				in = false;
			}
		}
		return strResult;
	}
	
	public String[] join(String[] a, String[] b) {
		String[] joined = new String[a.length + b.length];
		int i =0;
		for(i=0; i<a.length; i++) {
			joined[i] = a[i];
		}
		for(; i<a.length + b.length; i++) {
			joined[i] = b[i-a.length];
		}
		return joined;
	}
	
	public String join(String[] list, String splitter) {
		String temp = "";
		for(String item : list){
			temp = temp + item + "\t";
		}
		return temp;
	}
	
	public String[] add(String[] list, String string) {
		if(list == null) 
			return new String[]{string};
		String[] joined = new String[list.length + 1];
		int i =0;
		for(i=0; i<list.length; i++) {
			joined[i] = list[i];
		}
		joined[i] = string;
		return joined;
	}
	
	public final String trimTo(String s, int length, String tail) {
    	if (length <= 0) throw new IllegalArgumentException("length <= 0");
    	s = ifNull(s, "");
    	int sl = s.length();
    	if (sl <= length) return s;
    	
    	sl = s.getBytes().length;
    	
    	StringCharacterIterator iter = new StringCharacterIterator(s);
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(iter.first());
    	for (int i = 1; i < length; i++) buffer.append(iter.next());
    	buffer.append(ifNull(tail, ""));
    	
    	return buffer.toString();
    }
	
	
	public String byteCut(String str, int length) {
		return byteCut(str, 0, length);
	}
	
	public String byteCut(String str, int startIndex, int length) {
		byte[] b1 = null;
		byte[] b2 = null;
		try {
			if (str == null) {
				return "";
			}
			b1 = str.getBytes();
			b2 = new byte[length];

			if (length > (b1.length - startIndex))	{
				length = b1.length - startIndex;
			}
			System.arraycopy(b1, startIndex, b2, 0, length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(b2);
	} 
}
