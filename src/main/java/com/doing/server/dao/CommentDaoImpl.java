package com.doing.server.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.doing.server.pojo.Comment;

@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CommentDaoImpl.class);

	public Comment findById(int id) {
		return getByKey(id);
	}

	public void saveComment(Comment comment) {
		persist(comment);
	}

	public void deleteCommentById(int id) {
		Query query = getSession().createSQLQuery("delete from Comment where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> findAllComments(Comment comment) {
		Criteria criteria = createEntityCriteria();
		return (List<Comment>) criteria.list();
	}
	
	public Comment findCommentByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Comment) criteria.uniqueResult();
	}

}
