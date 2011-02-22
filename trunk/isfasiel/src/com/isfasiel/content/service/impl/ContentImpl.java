package com.isfasiel.content.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.content.service.ContentService;
import com.isfasiel.tag.service.impl.TagDAO;
import com.isfasiel.util.data.Data;

@Service("contentService")
public class ContentImpl implements ContentService {

	@Resource(name="tagDAO")
	protected TagDAO tagDAO;
	
	@Resource(name="contentDAO")
	protected ContentDAO contentDAO;
	
	@Override
	public Long insertContent(Data data) throws Exception {
		
		return contentDAO.insertContent(data);
	}

	@Override
	public Long updateContent(Data data) throws Exception {
		return null;
	}

	@Override
	public boolean deleteContent(Data data) throws Exception {
		return false;
	}

	@Override
	public Data selectContent(Data data) throws Exception {
		return null;
	}

	@Override
	public Data listContent(Data data) throws Exception {
		return null;
	}
	
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
	public void deleteTAg(Data data) throws Exception{
		tagDAO.delAllCntTags(data.getLong(0, "contentId"));
	}

}
