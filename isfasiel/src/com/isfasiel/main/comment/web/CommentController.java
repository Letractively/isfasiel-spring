package com.isfasiel.main.comment.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isfasiel.main.comment.service.CommentService;
import com.isfasiel.main.content.web.ContentController;
import com.isfasiel.util.data.Data;
@Controller
@RequestMapping(value="/comment")
public class CommentController extends ContentController {

	private int pageSize = 20;
	private String path = "content/xml";
	@Resource(name="commentService")
	CommentService commentService;
	
	@RequestMapping(value="/subList/{contentId}/{commentId}/{pageNumber}")
	public String getSubList(@PathVariable long contentId, @PathVariable long commentId, @PathVariable int pageNumber, Model model) throws Exception {
		Data param = getPageParam(pageNumber, pageSize);
		Data result = commentService.subList(param);
		addXML(model, "result", result, "comment");
		param = null;
		return path;
	}
	
	@RequestMapping(value="/create")
	public String createComment(Model model) throws Exception {
		Data result = new Data();
		try {
			commentService.craete(getParam());
			result.add(0, "result", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.add(0, "result", "NO");
		}
		return path;
	}
	
	@RequestMapping(value="/update")
	public String updateComment(Model model) throws Exception {
		Data result = new Data();
		try {
			commentService.update(getParam());
			result.add(0, "result", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.add(0, "result", "NO");
		}
		return path;
	}
	
	@RequestMapping(value="/delete/{commentId}")
	public String deleteComment(Model model) throws Exception {
		Data result = new Data();
		try {
			commentService.delete(getParam());
			result.add(0, "result", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.add(0, "result", "NO");
		}
		return path;
	}
}
