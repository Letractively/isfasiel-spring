package com.isfasiel.tag.service;

public interface TagService {
	public void updateTag(Long contentId, String[] tagNames) throws Exception;
	public void deleteTag(Long contentId) throws Exception;
}
