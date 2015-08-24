package com.doing.server.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.doing.server.pojo.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public User findById(int id) {
		return getByKey(id);
	}

	public void saveUser(User user) {
		logger.debug("----------------------------------------------------------------------");
		logger.debug(user.getId());
		logger.debug(user.getEmail());
		logger.debug(user.getFullname());
		logger.debug(user.getPassword());
		logger.debug(user.getPhone1());
		logger.debug(user.getPhone2());
		logger.debug(user.getXlocation());
		logger.debug(user.getYlocation());
		logger.debug(user.getCompanyid());
		logger.debug(user.getRole());
		logger.debug("----------------------------------------------------------------------");
		persist(user);
	}

	public void deleteUserById(int id) {
		Query query = getSession().createSQLQuery("delete from User where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
	
	public User findUserByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (User) criteria.uniqueResult();
	}

}
