package com.doing.server.service;

import java.util.List;

import com.doing.server.pojo.Comment;

public interface CommentService {

	Comment findById(int id);
	void saveComment(Comment comment);
	void updateComment(Comment comment);
	void deleteCommentById(int id);
	List<Comment> findAllComments(Comment comment); 
	
}
