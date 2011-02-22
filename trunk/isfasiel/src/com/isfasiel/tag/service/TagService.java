package com.isfasiel.tag.service;

import com.isfasiel.util.data.Data;

public interface TagService {
	public void updateTag(Long contentId, String[] tagNames) throws Exception;
	public void updateTag(Data data) throws Exception;
	public void deleteTag(Long contentId) throws Exception;
}
