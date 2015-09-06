package com.doing.server.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.doing.server.pojo.Task;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(TaskDaoImpl.class);

	public Task findById(int id) {
		return getByKey(id);
	}

	public void saveTask(Task task) {
		persist(task);
	}

	public void deleteTaskById(int id) {
		Query query = getSession().createSQLQuery("delete from Task where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks(Task task) {
		Criteria criteria = createEntityCriteria();
		return (List<Task>) criteria.list();
	}
	
	public Task findTaskByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Task) criteria.uniqueResult();
	}

}
