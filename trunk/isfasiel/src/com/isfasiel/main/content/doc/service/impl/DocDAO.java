/**
 * 
 */
package com.isfasiel.main.content.doc.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.main.base.dao.BaseDAO;
import com.isfasiel.util.data.Data;

/**
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.content.doc.service.impl
 * @FileName  : DocDAO.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
@Repository("docDAO")
public class DocDAO extends BaseDAO {
	public void insert(Data data) throws Exception{
		insert("docDAO.insert", data);
	}
	
	public void update(Data data) throws Exception {
		update("docDAO.update", data);
	}
	
	public Data select(Data data) throws Exception {
		return select("docDAO.select", data);
	}
	
	public Data list(Data data) throws Exception {
		return list("docDAO.list", data);
	}
	
}
