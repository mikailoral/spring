package com.doing.server.dao;

import java.util.List;

import com.doing.server.pojo.Task;

public interface TaskDao {

	Task findById(int id);
	void saveTask(Task task);
	void deleteTaskById(int id);
	List<Task> findAllTasks(Task task);
	Task findTaskByName(String name);

}
