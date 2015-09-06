package com.doing.server.service;

import java.util.List;

import com.doing.server.pojo.Task;

public interface TaskService {

	Task findById(int id);
	void saveTask(Task task);
	void updateTask(Task task);
	void deleteTaskById(int id);
	List<Task> findAllTasks(Task task); 
	
}
