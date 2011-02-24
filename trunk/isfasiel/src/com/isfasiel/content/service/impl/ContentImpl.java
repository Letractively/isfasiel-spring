package com.isfasiel.content.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.isfasiel.content.service.ContentService;
import com.isfasiel.tag.service.impl.TagDAO;
import com.isfasiel.util.data.Data;

//@Service("contentService")

/**
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.content.service.impl
 * @FileName  : ContentImpl.java
 * @Date         : 2011. 2. 24. 
 * Description : an abstract class for all content
 */
public abstract class ContentImpl implements ContentService {

	@Resource(name="tagDAO")
	protected TagDAO tagDAO;
	
	@Resource(name="contentDAO")
	protected ContentDAO contentDAO;
	
	/**
	 * insert a new content
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@Override
	public Long insert(Data data) throws Exception {
		Long contentId = contentDAO.insertContent(data);
		data.add(0, "contentId", contentId);
		insertContent(data);
		updateTag(data);
		return contentId;
	}

	/**
	 * It is an abstract class to insert a sub content
	 * @param data
	 * @throws Exception
	 */
	public abstract void insertContent(Data data) throws Exception;
	
	/**
	 * update a new content
	 * @param data
	 * @throws Exception
	 */
	@Override
	public void update(Data data) throws Exception {
		contentDAO.updateContent(data);
		updateContent(data);
		updateTag(data);
	}
	
	/**
	 * It is an abstract class to update a sub content
	 * @param data
	 * @throws Exception
	 */
	public abstract void updateContent(Data data) throws Exception;

	/**
	 * delete a content
	 * @param data
	 * @throws Exception
	 */
	@Override
	public void delete(Data data) throws Exception{
		contentDAO.deleteContent(data);
		deleteTag(data);
	}

	/**
	 * It is an abstract class to select a content
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Data> select(Data data) throws Exception{
		List<Data> result = new ArrayList<Data>();
		result.add(selectContent(data));
		result.add(getTags(data));
		return result;
	}
	
	public abstract Data selectContent(Data data) throws Exception;

	/**
	 * It is an abstract class to search a list of contents
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@Override
	public abstract Data list(Data data) throws Exception;
	
	/**
	 * update tags of a content
	 * @param data
	 * @throws Exception
	 */
	public void updateTag(Data data) throws Exception{
		int size = data.size();
		String[] tagNames = new String[size];
		for(int i = 0; i < size; i++) {
			tagNames[i] = data.getString(i, "tagName");
		}
		tagDAO.updateTag(data.getLong(0, "contentId"), tagNames);
	}
	
	/**
	 * delete all tags of a content
	 * @param data
	 * @throws Exception
	 */
	public void deleteTag(Data data) throws Exception{
		tagDAO.delAllCntTags(data.getLong(0, "contentId"));
	}

	public Data getTags(Data data) throws Exception {
		return tagDAO.getCntTagByCntId(data.getLong(0, "contentId"));
	}
	
}
