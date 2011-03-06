package com.isfasiel.main.file.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isfasiel.main.file.service.DirService;
import com.isfasiel.util.data.Data;
import com.isfasiel.util.file.DateUtil;
import com.isfasiel.util.file.DirUtil;


/**
 * 
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.file.service.impl
 * @FileName  : DirImpl.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
@Service("dirService")
public class DirImpl implements DirService {

	@Autowired
	protected DateUtil dateUtil;
	
	@Autowired
	protected DirUtil dirUtil;
	
	@Resource(name="dirDAO")
	private DirDAO dirDAO;

	@Override
	public Data insertDir(String realPath, Data data) throws Exception {
		if( data.get("phyPath") == null ) {
			data.add(0, "phyPath", dateUtil.dateToPath());
		}
		
		if( data.get("dirType") == null) {
			data.add("dirType", "N");
		}
		
		dirUtil.mkDir(realPath + "/" + data.getString("dirType") + "/" + data.getString("phyPath"));
		data.add(0,"dirId", dirDAO.insertDir(data));
		return data; 
	}

}
