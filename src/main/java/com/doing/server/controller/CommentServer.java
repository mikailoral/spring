package com.doing.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doing.server.pojo.Comment;
import com.doing.server.service.CommentService;

@RestController
public class CommentServer {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CommentServer.class);

	@Autowired
	CommentService service;

	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = "/commentlist", method = RequestMethod.POST)
	public @ResponseBody List<Comment> getComments(@RequestBody Comment commentp) {

		List<Comment> list = service.findAllComments(commentp);
		for (Comment comment : list) {
			System.out.println(comment);
		}
		return list;
	}

	@RequestMapping(value = "/addcomment", method = RequestMethod.POST)
	public @ResponseBody Comment addComment(@RequestBody Comment comment) {
		service.saveComment(comment);
		return comment;
	}
	
	@RequestMapping(value = "/updatecomment", method = RequestMethod.POST)
	public @ResponseBody Comment updateComment(@RequestBody Comment comment) {
		service.updateComment(comment);
		return comment;
	}

	@RequestMapping(value = "/deletecomment", method = RequestMethod.POST)
	public @ResponseBody Comment deleteComment(@RequestBody Comment comment) {
		service.deleteCommentById(comment.getId());
		return comment;
	}
	
	@RequestMapping(value = "/getcomment", method = RequestMethod.POST)
	public @ResponseBody Comment findById(@RequestBody Comment comment) {
		service.findById(comment.getId());
		return comment;
	}



}
