/**
 * 
 */
package com.isfasiel.content.doc.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.content.service.ContentService;
import com.isfasiel.content.web.ContentController;
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
@RequestMapping(value="/doc")
public class DocController extends ContentController {
	@Resource(name="docService")
	ContentService docService;
	/**
	 * insert a new document 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insert.do")
	public String insertDoc() throws Exception{
		Data param = getParam();
		Long contentId = docService.insert(param);
		linkFileMap(param, contentId);
		param = null;
		return "rediect:/doc/edit/" + contentId;
		//return "redirect:/doc/list.do";
	}
	
	/**
	 * view an document page.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view/{contentId}")
	public String viewDoc(@PathVariable("contentId") Long contentId, Model model) throws Exception {
		if(contentId > 0) {
			Data param = new Data(); 
			List<Data> result = docService.select(param);
			addTagView(model, result);
			model.addAttribute("param", param);
			return "doc/view";
		}
		return "doc/edit";
		
	}
	
	/**
	 * view an document page.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update/{contentId}")
	public String viewEdit(@PathVariable("contentId") Long contentId, Model model) throws Exception {
		if(contentId > 0) {
			Data param = new Data(); 
			List<Data> result = docService.select(param);
			addTagView(model, result);
			model.addAttribute("param", param);
			
		}
		return "doc/edit";
	}
	
	/**
	 * update a document and return to view page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update.do")
	public String updateDoc(Model model) throws Exception {
		Data param = getParam();
		docService.update(param);
		linkFileMap(param);
		model.addAttribute("param", param);
		return "redirect:/doc/view/" + param.getString(0, "contentId");
	}
	
	@RequestMapping(value="/delete.do")
	public String deleteDoc(Model model) throws Exception {
		Data param = getParam();
		docService.delete(param);
		model.addAttribute("param", param);
		return "redirect:/doc/list/" + param.getPage() + "/" + param.getPageSize();
	}
	
	@RequestMapping(value="/list/{page}/{pageSize}")
	public String listDoc(@PathVariable int page, @PathVariable int pageSize, Model model) throws Exception {
		Data param = getPageParam(page, pageSize);
		Data result = docService.list(param);
		addList(model, "result", result);
		addParam(model, param);
		return "doc/list";
	}
	
	
}
