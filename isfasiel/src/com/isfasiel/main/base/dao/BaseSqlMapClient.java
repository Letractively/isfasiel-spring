package com.isfasiel.main.base.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseSqlMapClient {
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
	}
	
	public SqlMapClientTemplate getSqlMapClientTemplate() {
		return this.sqlMapClientTemplate;
	}
}
