package com.doing.server.dao;

import java.util.List;

import com.doing.server.pojo.Comment;

public interface CommentDao {

	Comment findById(int id);
	void saveComment(Comment comment);
	void deleteCommentById(int id);
	List<Comment> findAllComments(Comment comment);
	Comment findCommentByName(String name);

}
