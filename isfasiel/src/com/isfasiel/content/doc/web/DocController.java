/**
 * 
 */
package com.isfasiel.content.doc.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.base.web.BaseController;
import com.isfasiel.content.doc.service.DocService;
import com.isfasiel.util.data.Data;

/**
 * @author Bae, Byeongseon.
 * @Project     : isfasiel
 * @Package     : com.isfasiel.content.doc.web
 * @FileName  : DocController.java
 * @Date         : 2011. 2. 20. 
 * Description :
 */
@Controller
public class DocController extends BaseController {
	@Resource(name="docService")
	DocService docService;
	
	@RequestMapping(value="/doc/insert.do")
	public String insertDoc() throws Exception{
		Data param = getParam();
		Long contentId = docService.insert(param);
		linkFileMap(param, contentId);
		
		return "redirect:/doc/list.do";
	}
	
	@RequestMapping(value="/doc/viewInsert.do")
	public String viewInsertDoc() throws Exception {
		return "doc/viewInsert";
	}
}
