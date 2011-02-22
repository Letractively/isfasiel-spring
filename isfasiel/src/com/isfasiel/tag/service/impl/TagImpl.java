package com.isfasiel.tag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.tag.service.TagService;
import com.isfasiel.util.data.Data;

@Service("tagService")
public class TagImpl implements TagService {
	@Resource(name="tagDAO")
	TagDAO tagDAO;
	
	@Override
	public void updateTag(Long contentId, String[] tagNames) throws Exception{
		tagDAO.updateTag(contentId, tagNames);
	}
	
	@Override
	public void updateTag(Data data) throws Exception {
		int size = data.size();
		Long contentId = data.getLong(0, "contentId");
		String[] tagNames = new String[size];
		for(int i =0; i < size; i++) {
			tagNames[i] = data.getString(i, "tagName");
		}
		
		tagDAO.updateTag(contentId, tagNames);
		tagNames = null;
		
	}
	
	@Override
	public void deleteTag(Long contentId) throws Exception {
		tagDAO.delAllCntTags(contentId);
	}
}
