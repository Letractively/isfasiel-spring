package com.isfasiel.tag.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isfasiel.base.DAO.BaseDAO;
import com.isfasiel.util.NumberUtil;
import com.isfasiel.util.ObjectUtil;
import com.isfasiel.util.ParamUtil;
import com.isfasiel.util.Text;
import com.isfasiel.util.data.Data;
/**
 * 
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.tag.service.impl
 * @FileName  : TagDAO.java
 * @Date         : 2011. 2. 21. 
 * Description :
 */
@Repository("tagDAO")
public class TagDAO extends BaseDAO {
	@Autowired
	Text text;
	
	@Autowired
	ObjectUtil objectUtil;
	
	@Autowired
	NumberUtil numberUtil;
	
	@Autowired
	ParamUtil paramUtil;
	
	/**
	 * create a new tag (to be deleted)
	 * @param tags
	 * @return
	 * @throws Exception
	 */
	/*
	public boolean createTag(Data tags) throws Exception {
		//long cntNum, String[] tagNames, int dataType
		int i =0;
		boolean result = false;
		List<Object> tagNameList = tags.getListValuesByName("tagName");
		Data rs = getTags(tagNameList);
		String[] newTags = text.notAndC(tagNameList.toArray(), rs, "tagName");
		String[] addedTags = text.andC(rs, tagNameList.toArray(), "tagName");
		if( addedTags != null) {
			long[] addedTagNums = new long[addedTags.length];
			for(i=0; i<addedTags.length; i++) {
				addedTagNums[i] = rs.getLong(i, "tagId");
			}
			result = setTagCountInc(addedTagNums);
		}
		
		if( newTags != null ) {
			for(i=0; i<newTags.length; i++) {
				result = insertTag(newTags[i]);
			}
		}
		
		return result;
	}
	*/
	/**
	 * delete all connection between a content and tags
	 */
	public void delAllCntTags(long cntNum) throws Exception {
		updateTag(cntNum, null);
	}
	
	/**
	 * ��� �ױ��� �߰� ���� ������ ����Ѵ�.
	 * @param contentId
	 * @param tagNames
	 * @param dataType
	 * @throws Exception
	 */
	public void updateTag(long contentId, String[] tagNames) throws Exception {
		Data rs = new Data(this.getSqlMapClientTemplate().queryForList("tagDAO.connSelectByContent", contentId));
		addCntTags(contentId, text.toUnique(tagNames), rs);
		delCntTags(contentId, text.toUnique(tagNames), rs);
		rs = null;
	}
	
	/*
	 * add contentTag
	 * parameter : cntId(String), tagnames(String[]), rs(Result), dataType(int)
	 * purpose : add new tags in tContentTag table and tTag table.
	 * 				1. check added tags.
	 * 				2. add new tags to tContentTag and tTag.
	 *              3. count up added tags.
	 */
	protected void addCntTags(long contentId, String[] tagNames, Data rs) throws Exception {
		String[] addedTagNames = text.andC(tagNames, rs, "tagName");
		String[] notAddedTagNames = text.notAndC(tagNames, rs, "tagName");
		long[] addedTagIds = new long[]{};
		int i = 0;
		if(addedTagNames != null) { 
			for(i=0; i<addedTagNames.length; i++) {
				addedTagIds = numberUtil.add(addedTagIds, rs.getByKeyCaseIgnore("tagName", addedTagNames[i], "tagId"));
			}
		}
		
		if(notAddedTagNames != null) {
			for(i=0; i<notAddedTagNames.length; i++) {
				Data tagRs = getTag(notAddedTagNames[i]);
				if(tagRs.size() == 0) {
					insertTag(notAddedTagNames[i]);
					tagRs = getTag(notAddedTagNames[i]);
				} else {
					addedTagIds = numberUtil.add(addedTagIds, tagRs.get(i, "tagId"));
				}
				setCntTag(contentId, objectUtil.toLong(tagRs.get(i, "tagId")));
			}
		}
		if( addedTagIds.length > 0) {
			setTagCountInc(addedTagIds);
		}
		addedTagNames = null;
		notAddedTagNames = null;
		addedTagIds = null;
	}
	
	protected void delCntTags(long contentId, String[] tagNames, Data rs) throws Exception {
		String[] deleteTagNames = text.notAndC(rs, tagNames, "tagName");
		if(deleteTagNames == null) {return;}
		long[] deletedTagIds = new long[]{};
		int i = 0;
		for(i=0; i<deleteTagNames.length; i++) {
			deletedTagIds = numberUtil.add(deletedTagIds, rs.getByKey("tagName", deleteTagNames[i], "tagId"));
		}
		if(deleteTagNames.length > 0) {
			setTagCountDec(deletedTagIds);
			delCntTag(contentId, paramUtil.toNumList(deletedTagIds) );
		}
		deleteTagNames = null;
		deletedTagIds = null;
	}
	
	
	
	public boolean setCntTag(long contentId, long tagId) throws Exception {
		Data param = new Data();
		param.add(0, "contentId", contentId);
		param.add(0, "tagId", tagId);
		Object result = this.getSqlMapClientTemplate().insert("tagDAO.connInsert", param);
		param = null;
		return result != null ? true : false;
	}
	
	public Data getTags(List<Object> tagNames) throws Exception {
		return new Data(this.getSqlMapClientTemplate().queryForList("tagDAO.tagSelect", tagNames));
	}
	
	public Data getTag(String tagName) throws Exception {
		return new Data(this.getSqlMapClientTemplate().queryForList("tagDAO.select", tagName));
	}
	
	public boolean insertTag(String tagName) throws Exception {
		tagName = tagName.toUpperCase();
		Long tagId = getSeq("SEQ_TN_TAG");
		Data param = new Data();
		param.add(0, "tagId", tagId);
		param.add(0, "tagName", tagName);
		
		Object result = this.getSqlMapClientTemplate().insert("tagDAO.insert", param);
		param = null;
		return result != null ? true : false;
	}
	
	public boolean updateTag(long tagId, String tagName, int tagCount, int state) throws Exception {
		Data param = new Data();
		param.add(0, "tagId", tagId);
		param.add(0, "tagName", tagName);
		param.add(0, "tagCount", tagCount);
		param.add(0, "state", state);
		
		int result = this.getSqlMapClientTemplate().update("tagDAO.update", param);
		param = null;
		return result > 0 ? true : false;
	}
	public boolean delTag(long tagId) throws Exception {
		int result = this.getSqlMapClientTemplate().delete("tagDAO.delete", tagId);
		return result > 0 ? true : false;
	}
	
	public boolean setTagCountInc(long[] tagIds) throws Exception {
		List<Long> list = new ArrayList<Long>();
		int length = tagIds.length;
		for(int i=0; i < length; i++) {
			list.add(tagIds[i]);
		}
		
		int result = this.getSqlMapClientTemplate().update("tagDAO.countIncrease",list);
		list = null;
		return result > 0 ? true : false;
	}
	
	public boolean setTagCountInc(String tagIds) throws Exception {
		List<Long> list = new ArrayList<Long>();
		String[] tagIdList = tagIds.split(",");
		int length = tagIdList.length;
		for(int i=0; i < length; i++) {
			list.add(Long.parseLong( tagIdList[i] ));
		}
		int result = this.getSqlMapClientTemplate().update("tagDAO.countIncrease", list);
		return result > 0 ? true : false;
	}
	
	public boolean setTagCountDec(long[] tagIds) throws Exception {
		List<Long> list = new ArrayList<Long>();
		int length = tagIds.length;
		for(int i=0; i < length; i++) {
			list.add(tagIds[i]);
		}
		int result = this.getSqlMapClientTemplate().update("tagDAO.countDecrease", list);
		list = null;
		return result > 0 ? true : false;
	}
	
	public boolean setTagCountDec(String tagIds) throws Exception {
		List<Long> list = new ArrayList<Long>();
		String[] tagIdList = tagIds.split(",");
		int length = tagIdList.length;
		for(int i=0; i < length; i++) {
			list.add(Long.parseLong( tagIdList[i] ));
		}
		int result = this.getSqlMapClientTemplate().update("tagDAO.countDecrease", list);
		list = null;
		return result > 0 ? true : false;
	}
	
	public boolean delCntTag(long cntNum, String tagNum) throws Exception {
		Data data = new Data();
		data.add("nums", tagNum);
		data.add("cntNum", cntNum);
		int result = this.getSqlMapClientTemplate().delete("tagDAO.connSelectByTag", data);
		return result > 0 ? true : false;
	}
	
	
	public Data getCntTag(long contentId, long tagId) throws Exception{
		Data param = new Data();
		param.add(0, "contentId", contentId);
		param.add(0, "tagId", tagId);
		Data rs = new Data(this.getSqlMapClientTemplate().queryForList("tagDAO.connSelect", param));
		param = null;
		return rs;
	}
	
	public Data getCntTagByCntId(long contentId) throws Exception{
		Data param = new Data();
		param.add(0, "contentId", contentId);
		Data rs = new Data(this.getSqlMapClientTemplate().queryForList("tagDAO.connSelectByContent", param));
		param = null;
		return rs;
	}
	
	public Data getCntTagByTagName(long tagId) throws Exception{
		Data param = new Data();
		param.add(0, "tagId", tagId);
		Data rs = new Data(this.getSqlMapClientTemplate().queryForList("tagDAO.connSelectByTag", param));
		param = null;
		return rs;
	}
}