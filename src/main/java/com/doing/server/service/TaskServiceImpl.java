package com.doing.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doing.server.dao.TaskDao;
import com.doing.server.pojo.Task;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao dao;

	public Task findById(int id) {
		return dao.findById(id);
	}

	public void saveTask(Task task) {
		dao.saveTask(task);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public Task updateTask(Task task) {
		Task entity = dao.findById(task.getId());
		if (entity != null) {
			if (task.getStartdate() != null) {
				entity.setStartdate(task.getStartdate());
			}
			if (task.getEnddate() != null) {
				entity.setEnddate(task.getEnddate());
			}
			if (task.getAddress() != null) {
				entity.setAddress(task.getAddress());
			}
			if (task.getCustomerid() != 0) {
				entity.setCustomerid(task.getCustomerid());
			}
			if (task.getStatus() != 0) {
				entity.setStatus(task.getStatus());
			}
		}
		return entity;
	}

	public Task updateTaskStatus(Task task) {
		Task entity = dao.findById(task.getId());
		if (entity != null) {
			if (task.getStatus() != 0) {
				entity.setStatus(task.getStatus());
			}
		}
		return entity;
	}

	public void deleteTaskById(int id) {
		dao.deleteTaskById(id);
	}

	public List<Task> findAllTasks(Task task) {
		return dao.findAllTasks(task);
	}

}
