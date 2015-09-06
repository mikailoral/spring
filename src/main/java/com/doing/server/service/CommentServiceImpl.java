package com.doing.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doing.server.dao.CommentDao;
import com.doing.server.pojo.Comment;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao dao;
	
	public Comment findById(int id) {
		return dao.findById(id);
	}

	public void saveComment(Comment comment) {
		dao.saveComment(comment);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateComment(Comment comment) {
		Comment entity = dao.findById(comment.getId());
		if(entity!=null){
			entity.setComment(comment.getComment());
		}
	}

	public void deleteCommentById(int id) {
		dao.deleteCommentById(id);
	}
	
	public List<Comment> findAllComments(Comment comment) {
		return dao.findAllComments(comment);
	}


	
}
