package com.isfasiel.util.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.isfasiel.util.ObjectUtil;

/**
 * Data container
 * @author ¹èº´¼±
 *
 */
public class Data {
	
	ObjectUtil objectUtil = new ObjectUtil();
	
	private Vector<HashMap<String,Object>> hMapList = new Vector<HashMap<String,Object>>();
	//private Object[] columnNameList = null;
	private long maxRow;
	private int pageSize;
	private int page;
	
	public long getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(long maxRow) {
		this.maxRow = maxRow;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	public void setHashMapList(ResultSet rs) {
		try {
			int i =0;
			Vector<HashMap<String,Object>> hMapList = new Vector<HashMap<String,Object>>();
			
			String[] columnNameList = new String[rs.getMetaData().getColumnCount()];
			for(i=0; i < columnNameList.length; i++) {
				//columnNameList[i] =  rs.getMetaData().getColumnName(i+1).toString().toLowerCase();
				columnNameList[i] =  toKeyName( rs.getMetaData().getColumnLabel(i+1).toString() );
			}
			while(rs.next()) {
				HashMap<String,Object> hResultMap = new HashMap<String, Object>();
				for(i =0; i< columnNameList.length; i++ ){
					hResultMap.put(columnNameList[i], rs.getObject(i+1));
				}
				hMapList.add(hResultMap);
			}
			setHMapList(hMapList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<HashMap<String, Object>> toList() {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		int size = this.hMapList.size();
		for(int i =0; i < size; i++) {
			list.add(this.hMapList.get(i));
		}
		return list;
	}
	
	public Vector<HashMap<String, Object>> getHMapList() {
		return this.hMapList;
	}

	public void setHMapList(Vector<HashMap<String, Object>> hMapList) {
		this.hMapList = hMapList;
	}
	
	public Object[] getColumnNameList() {
		
		return getColumnNameList(0);
	}
	
	public boolean remove(int index) {
		int length = getHMapList().size();
		if( index >= length) {
			return false;
		}
		this.hMapList.remove(index);
		return true;
	}
	
	public boolean remove(String name, Object key) {
		int index = getRowIndex(name, key);
		if( index == -1) {
			return false;
		}
		return remove(index);
	}
	
	public void removeAll(){
		int length = getHMapList().size();
		
		for(int i =0; i < length; i++){
			this.hMapList.remove(0);
		}
	}
	
	public int getColumnSize() {
		return getColumnSize(0);
	}
	
	public int getColumnSize(int index) {
		return getHMapList().get(index).size();
	}
	
	public String getColumnName(int index, int key) {
		Set<String> set = getHMapList().get(index).keySet();
		Object[] nameList = set.toArray();
		return nameList[key].toString();
	}
	
	public Object[] getColumnNameList(int index) {
		if( getHMapList().size() == 0 || index >= getHMapList().size() ) {
			return null;
		}
		
		Set<String> set = getHMapList().get(index).keySet();
		Object[] columnNameList = set.toArray();
		return columnNameList;
	}
	
	public Object[] getColumnNameList(HashMap<String, Object> map) {
		if( map.size() == 0) {
			return null;
		}
		
		Set<String> set = map.keySet();
		Object[] columnNameList = set.toArray();
		return columnNameList;
	}
	
	public String getColumnName(int index) {
		String columnName = getColumnNameList()[index].toString(); 
		return columnName;
	}
	
	public HashMap<String,Object> getRecord(int index) {
		return getHMapList().get(index);
	}
	
	public List<Object> getListValuesByName(String name) {
		List<Object> list = new ArrayList<Object>();
		int size = size();
		for(int i=0; i < size; i++) {
			list.add(get(i, name));
		}
		return list;
	}
	
	public int getInt(int columnIndex) {
		return objectUtil.toInt(get(0, columnIndex));
	}
	
	public int getInt(int rowIndex, int columnIndex) {
		return objectUtil.toInt(get(rowIndex, columnIndex));
	}
	
	public int getInt(String columnName) {
		return objectUtil.toInt(get(0, columnName));
	}
	
	public int getInt(int rowIndex, String columnName) {
		return objectUtil.toInt(get(rowIndex, columnName));
	}
	
	public long getLong(int columnIndex) {
		return objectUtil.toLong(get(0, columnIndex));
	}
	
	public long getLong(int rowIndex, int columnIndex) {
		return objectUtil.toLong(get(rowIndex, columnIndex));
	}
	
	public long getLong(String columnName) {
		return objectUtil.toLong(get(0, columnName));
	}
	
	public long getLong(int rowIndex, String columnName) {
		return objectUtil.toLong(get(rowIndex, columnName));
	}
	
	public String getString(int columnIndex) {
		return objectUtil.toString(get(0, columnIndex));
	}
	
	public String getString(int rowIndex, int columnIndex) {
		return objectUtil.toString(get(rowIndex, columnIndex));
	}
	
	public String getString(String columnName) {
		return objectUtil.toString(get(0, columnName));
	}
	
	public String getString(int rowIndex, String columnName) {
		return objectUtil.toString(get(rowIndex, columnName));
	}
	
	public boolean getBoolean(int columnIndex) {
		return objectUtil.toBoolean(get(0, columnIndex));
	}
	
	public boolean getBoolean(int rowIndex, int columnIndex) {
		return objectUtil.toBoolean(get(rowIndex, columnIndex));
	}
	
	public boolean getBoolean(String columnName) {
		return objectUtil.toBoolean(get(0, columnName));
	}
	
	public boolean getBoolean(int rowIndex, String columnName) {
		return objectUtil.toBoolean(get(rowIndex, columnName));
	}
	
	public Timestamp getTimestamp(int columnIndex) {
		return objectUtil.toTimestamp(get(0, columnIndex));
	}
	
	public Timestamp getTimestamp(int rowIndex, int columnIndex) {
		return objectUtil.toTimestamp(get(rowIndex, columnIndex));
	}
	
	public Timestamp getTimestamp(String columnName) {
		return objectUtil.toTimestamp(get(0, columnName));
	}
	
	public Timestamp getTimestamp(int rowIndex, String columnName) {
		return objectUtil.toTimestamp(get(rowIndex, columnName));
	}
	
	public double getDouble(int columnIndex) {
		return objectUtil.toDouble(get(0, columnIndex));
	}
	
	public double getDouble(int rowIndex, int columnIndex) {
		return objectUtil.toDouble(get(rowIndex, columnIndex));
	}
	
	public double getDouble(String columnName) {
		return objectUtil.toDouble(get(0, columnName));
	}
	
	public double getDouble(int rowIndex, String columnName) {
		return objectUtil.toDouble(get(rowIndex, columnName));
	}
	
	public float getFloat(int columnIndex) {
		return objectUtil.toFloat(get(0, columnIndex));
	}
	
	public float getFloat(int rowIndex, int columnIndex) {
		return objectUtil.toFloat(get(rowIndex, columnIndex));
	}
	
	public float getFloat(String columnName) {
		return objectUtil.toFloat(get(0, columnName));
	}
	
	public float getFloat(int rowIndex, String columnName) {
		return objectUtil.toFloat(get(rowIndex, columnName));
	}
	
	public Object get(int columnIndex) {
		return get(0, columnIndex);
	}
	
	public Object get(int rowIndex, int columnIndex) {
		try {
			if( getHMapList().isEmpty()) {return null;}
			String cName = getColumnName(columnIndex);
			Object value =  getHMapList().get(rowIndex).get(cName);
			return value;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Object get(String columnName) {
		return get(0, columnName);
	}
	
	public Object get(int rowIndex, String columnName) {
		try {
			if( getHMapList().isEmpty()) {return null;}
			HashMap<String, Object> map = getHMapList().get(rowIndex); 
			Object[] nameList = getColumnNameList();
			int length = nameList.length;
			for(int i = 0; i < length; i++) {
				if(nameList[i].toString().toLowerCase().equals(columnName.toLowerCase())) {
					return map.get(nameList[i]);
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}

	public int getRowIndex(String keyColumnName, Object key) {
		int i = 0;
		int j = 0;
		int length = getColumnNameList().length;
		for(i=0; i<length; i++) {
			if(getColumnName(i).toLowerCase().equals(keyColumnName.toLowerCase()) == true) {
				for(j=0; j<getHMapList().size(); j++) {
					if(getString(j, i).equals(objectUtil.toString(key)) == true){
						return j;
					}
				}
			}
		}
		return -1;
		//Object[] rowItemList = getRow(rowIndex)
	}
	
	public Object getByKey(String keyColumnName, Object key, String targetColumnName) {
		int index = getRowIndex(keyColumnName, key);
		if(index == -1) {
			return null;
		} else {
			return get(index, targetColumnName);
		}
	}

	public Object getByKeyCaseIgnore(String keyColumnName, Object key, String targetColumnName) {
		int index = getRowIndex(keyColumnName, key.toString().toUpperCase());
		if(index == -1) {
			return null;
		} else {
			return get(index, targetColumnName);
		}
		
	}
	
	public void setByKey(String keyColumnName, Object key, String targetColumnName, Object value) {
		int index = getRowIndex(keyColumnName, key);
		if(index == -1) {
		} else {
			add(index, targetColumnName, value);
		}
	}
	
	
	public int size() {
		return getHMapList().size();
	}
	
	public int columnSize(int index) {
		return getHMapList().get(index).size();
	}
	
	public Data() {
		
	}
	
	public Data(ResultSet rs) {
		setHashMapList(rs);
		//setColumnNameList();
	}
	
	// Get all parameters from request
	public Data(HttpServletRequest request) throws Exception {
		String key;
		int count = 0;
		String[] values = null;
		for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
			key = (String) e.nextElement();
			// Object o = request.getAttribute(key);
			
			if (request.getParameter(key) != null) {
				values = request.getParameterValues(key);
				count = values.length;
				for( int i=0; i < count; i++) {
					//System.out.println("INPUT NAME: " + key + "\tVALUE: " +values[i]);
					this.add(i, key, values[i]);
				}
			}
		}
		
	}
	
	public Data(List<HashMap<String,Object>> list) {
		if (list == null ) {return;}
		
		int size = list.size();
		if(size == 0) {return;}
		
		HashMap<String, Object> record = list.get(0);
		Set<String> set = record.keySet();
		Object[] columnNameList = set.toArray();
		int paramLength = columnNameList.length;
		String[] strColumnNameList = new String[paramLength];
		
		for( int i =0; i < paramLength; i++ ) {
			strColumnNameList[i] = toKeyName(columnNameList[i].toString());
		}
		
		for(int i =0; i < size; i++) {
			record = list.get(i);
			int orgSize = size();
			for( int j =0; j < paramLength; j++) {
				add(orgSize + i, strColumnNameList[j], record.get(columnNameList[j].toString()));
			}
		}
	}
	
	public boolean isNull() {
		if(getHMapList() == null) return true;
		if( getHMapList().size() == 0 ) return true;
		else return false;
	}
	
	public void setPagingInfo(long maxRow, int page, int pageSize) {
		this.setMaxRow(maxRow);
		this.setPage(page);
		this.setPageSize(pageSize);
	}
	
	public void add(String key, Object value) {
		add(hMapList.size(), key, value);
	}
	
	public void add(int index, String key, Object value) {
		
		HashMap<String, Object> row = null;
		int target = 0;
		int size = hMapList.size();
		if( index < 1) {
			index = 0;
			target = 0;
		} else if( index >= size) {
			index = size;
			target = index -1;
		} else {
			target = index;
		}
		
		row = new HashMap<String, Object>();
		if( size > 0 ) {
			for(int i=0; i < getColumnSize(target); i++) {
				//System.out.println("NAME: " +getColumnName(target, i) + "\tVALUE: " +get(target, i));
				row.put(getColumnName(target, i), get(target, getColumnName(target, i)));
			}
		}
		
		row.put(key, value);
		
		if(size == 0) {
			hMapList.add(0, row);
		} else if( index == size) {
			hMapList.add(index, row);
		} else {
			hMapList.setElementAt(row, index);
		}
	}
	/*
	public HashMap<String, Object> toLowerCase(HashMap<String, Object> param) {
		HashMap<String, Object> temp = new HashMap<String, Object>();
		Object[] columnNameList = getColumnNameList(param);
		for(int i=0; i < columnNameList.length; i++) {
			temp.put(columnNameList[i].toString().toLowerCase(), param.get(columnNameList[i].toString()));
		}
		return temp;
	}
	*/
	public void add(HashMap<String, Object> param) {
		
		hMapList.add(param);
	}
	
	public void add(List<HashMap<String, Object>> param) {
		int size = param.size();
		
		for(int i=0; i < size; i++) {
			this.hMapList.add(param.get(i));
		}
	}
	
	public void add(int index, HashMap<String, Object> param) {
		if( index < hMapList.size()) {
			hMapList.add(index, param);
		} else {
			hMapList.add(param);
		}
	}
	
	public void add(Data additionalData) {
		int size = additionalData.size();
		int newIndex = hMapList.size();
		for(int i=0; i < size; i++) {
			hMapList.add(newIndex +i, additionalData.getRecord(i));
		}
	}
	@Override
	public String toString() {
		int i,j;
		
		Object[] names = getColumnNameList();
		if( names == null ) {return "empty";};
		if( names.length == 0) {return "empty";};
		StringBuilder form = new StringBuilder();
		int size = hMapList.size();
		form.append("SIZE : " + size+"\n");
		form.append("|\t");
		for(i=0; i<names.length; i++) {
			form.append(names[i] + "\t|\t");
		}
		form.replace(form.lastIndexOf("\t"), form.length(), "\n");
		for(i=0; i < size; i++ ) {
			form.append("|\t");
			for(j=0; j < names.length; j++) {
				form.append(getString(i, j)+"\t|\t");
			}
			form.replace(form.lastIndexOf("\t"), form.length(), "\n");
		}
		
		return form.toString();
	}
	
	public String toJSArray() {
		int i,j;
		StringBuilder form = new StringBuilder();
		Object[] names = getColumnNameList(0);
		
		int size = getHMapList().size();
		if( size == 0 ) { return "'empty'"; }
		form.append(" new Array(\n");
		for(i=0; i < size; i++ ) {
			form.append("{");
			for(j=0; j < names.length; j++) {
				form.append("\""+names[j].toString().replaceAll("\"", "\\\"").replaceAll("\t", "\\\t").replaceAll("\n", "\\\n")+"\" : ");
				form.append("\""+getString(i, j).replaceAll("\"", "\\\"").replaceAll("\t", "\\\t").replaceAll("\n", "\\\n")+"\",");
			}
			form.replace(form.lastIndexOf(","), form.length(), "},\n");
		}
		form.replace(form.lastIndexOf(","), form.length(), "\n);");
		//form.append("\n)");
		return form.toString();
	}
	
	public String toKeyName(String columnName) {
		String[] textList = columnName.split("_");
		String name = textList[0].toLowerCase();
		int length = textList.length;
		
		for(int i =1; i < length; i++) {
			String text = textList[i];
			name = name + text.charAt(0) + text.substring(1, text.length()); 
		}
		return name;
	}
}