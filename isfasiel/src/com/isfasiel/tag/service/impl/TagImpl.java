package com.isfasiel.tag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isfasiel.tag.service.TagService;

@Service("tagService")
public class TagImpl implements TagService {
	@Resource(name="tagDAO")
	TagDAO tagDAO;
	
	@Override
	public void updateTag(Long contentId, String[] tagNames) throws Exception{
		tagDAO.updateTag(contentId, tagNames);
	}
	
	@Override
	public void deleteTag(Long contentId) throws Exception {
		tagDAO.delAllCntTags(contentId);
	}
}
