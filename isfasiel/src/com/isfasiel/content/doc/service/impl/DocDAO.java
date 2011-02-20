/**
 * 
 */
package com.isfasiel.content.doc.service.impl;

import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.content.ContentDAO;
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
public class DocDAO extends ContentDAO {
	public Long insert(Data data) throws Exception{
		Long contentId = getContentSeq();
		data.add("contentId", contentId);
		insertContent(data);
		insert("docDAO.insert", data);
		return contentId;
	}
}
