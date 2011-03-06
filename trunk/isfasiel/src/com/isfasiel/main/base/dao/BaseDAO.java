package com.isfasiel.main.base.dao;

import java.sql.SQLException;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.isfasiel.util.data.Data;
/**
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.base.DAO
 * @FileName  : BaseDAO.java
 * @Date         : 2011. 2. 18.
 * Description :
 */
public class BaseDAO {
	
	public final String TYPE_LIST = "LIST";
	public final String TYPE_INT = "INT";
	public final String TYPE_STRING = "STRING";
	public final String TYPE_OBJECT = "OBJECT";
	public final String TYPE_UPDATE = "UPDATE";
	public final String TYPE_DELETE = "DELETE";
	public final String TYPE_INSERT = "INSERT";
	
	public final String TYPE_DATA_TYPE = "type";
	public final String TYPE_DATA_QUERY = "query";
	public final String TYPE_DATA_PARAM = "param";
	public final String TYPE_DATA_RESULT = "result";
	
	protected Data queryList = null;
	
	@Resource(name="baseSqlMapClient")
	private BaseSqlMapClient baseSqlMapClient;

	
	protected void addObjectQuery(String query, HashMap<String, Object> param) {
		addQuery(TYPE_OBJECT, query, param);
	}
	
	protected void addIntQuery(String query, HashMap<String, Object> param) {
		addQuery(TYPE_INT, query, param);
	}
	
	protected void addStringQuery(String query, HashMap<String, Object> param) {
		addQuery(TYPE_STRING, query, param);
	}

	protected void addDeleteQuery(String query, HashMap<String, Object> param) {
		addQuery(TYPE_DELETE, query, param);
	}
	
	protected void addUpdateQuery(String query, HashMap<String, Object> param) {
		addQuery(TYPE_UPDATE, query, param);
	}
	
	protected void addListInsert(String query, HashMap<String, Object> param) {
		addQuery(TYPE_INSERT, query, param);
	}
	
	protected void addListQuery(String query, HashMap<String, Object> param) {
		addQuery(TYPE_LIST, query, param);
	}
	
	protected void addQuery(String type, String query, HashMap<String, Object> param) {
		if(queryList == null) {queryList = new Data();}
		int current = queryList.size(); 
		queryList.add(current, TYPE_DATA_TYPE, type);
		queryList.add(current, TYPE_DATA_QUERY, query);
		queryList.add(current, TYPE_DATA_PARAM, param);
	}
	
	protected Data getQueryList() {
		return queryList;
	}
	
	protected SqlMapClientTemplate getSqlMapClientTemplate() {
		return this.baseSqlMapClient.getSqlMapClientTemplate();
	}
	
	protected Data select(String queryName) {
		return new Data((HashMap<String, Object>)this.getSqlMapClientTemplate().queryForObject(queryName));
	}
	
	protected Data select(String queryName, Data data) {
		return new Data((HashMap<String, Object>)this.getSqlMapClientTemplate().queryForObject(queryName, data.getRecord(0)));
	}
	
	protected Data list(String queryName) {
		return new Data(this.getSqlMapClientTemplate().queryForList(queryName));
	}
	
	protected Data list(String queryName, Data data) throws Exception{
		return list(queryName, data.getRecord(0));
	}
	
	protected Data list(String queryName, HashMap<String, Object> param) throws Exception{
		return new Data(this.getSqlMapClientTemplate().queryForList(queryName, param));
	}
	
	protected Object insert(String queryName, Data data) throws Exception{
		return insert(queryName, data.getRecord(0));
	}
	
	protected Object insert(String queryName, HashMap<String, Object> param) throws Exception {
		return this.getSqlMapClientTemplate().insert(queryName, param);
	}
	
	protected int update(String queryName, Data data) throws Exception{
		return update(queryName, data.getRecord(0));
	}
	
	protected int update(String queryName, HashMap<String, Object> param) throws Exception {
		return this.getSqlMapClientTemplate().update(queryName, param);
	}
	
	protected int delete(String queryName, Data data) throws Exception{
		return delete(queryName, data.getRecord(0));
	}
	protected int delete(String queryName, HashMap<String, Object> param) throws Exception {
		return this.getSqlMapClientTemplate().delete(queryName, param);
	}
	
	protected Object execute() throws Exception {
		return execute(queryList);
	}
	protected Data execute(final Data cQueryList) throws Exception {
		Data result = getSqlMapClientTemplate().execute(
				new SqlMapClientCallback<Data>() {
					@Override
					public Data doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
						
						int size = cQueryList.size();
						executor.startBatch();
						for(int i =0; i < size; i++) {
							String query = cQueryList.getString(i,TYPE_DATA_QUERY);
							String type = cQueryList.getString(i, TYPE_DATA_TYPE); 
							HashMap<String, Object> param = (HashMap<String, Object>)cQueryList.get(i, TYPE_DATA_PARAM);
							if(type.equals(TYPE_LIST)) {
								Data result = new Data();
								result.add(executor.queryForList(query, param));
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							} else if(type.equals(TYPE_INT)) {
								Integer result = (Integer)executor.queryForObject(query, param);
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							} else if(type.equals(TYPE_STRING)) {
								String result = (String)executor.queryForObject(query, param);
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							} else if(type.equals(TYPE_OBJECT)) {
								Object result = executor.queryForObject(query, param);
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							} else if(type.equals(TYPE_INSERT)) {
								Object result = executor.insert(query, param);
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							} else if(type.equals(TYPE_DELETE)) {
								int result = executor.delete(query, param);
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							} else if(type.equals(TYPE_UPDATE)) {
								int result = executor.update(query, param);
								cQueryList.add(i, TYPE_DATA_RESULT, result);
							}
						}
						executor.executeBatch();
						return queryList;
					}
				}
			);
		return result;
	}
	
	protected Long getSeq(String seqName) throws Exception {
		return (Long)getSqlMapClientTemplate().queryForObject("baseDAO.newId", seqName);
	}
}
