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

import com.doing.server.pojo.Task;
import com.doing.server.service.TaskService;

@RestController
public class TaskServer {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(TaskServer.class);

	@Autowired
	TaskService service;

	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = "/listtask", method = RequestMethod.POST)
	public @ResponseBody List<Task> getTasks(@RequestBody Task taskp) {

		List<Task> list = service.findAllTasks(taskp);
		for (Task task : list) {
			System.out.println(task);
		}
		return list;
	}

	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	public @ResponseBody Task addTask(@RequestBody Task task) {
		service.saveTask(task);
		return task;
	}
	
	@RequestMapping(value = "/updatetask", method = RequestMethod.POST)
	public @ResponseBody Task updateTask(@RequestBody Task task) {
		return service.updateTask(task);
	}

	@RequestMapping(value = "/updatetaskstatus", method = RequestMethod.POST)
	public @ResponseBody Task updateTaskStatus(@RequestBody Task task) {
		return service.updateTaskStatus(task);
	}

	@RequestMapping(value = "/deletetask", method = RequestMethod.POST)
	public void deleteTask(@RequestBody Task task) {
		service.deleteTaskById(task.getId());
	}
	
	@RequestMapping(value = "/gettask", method = RequestMethod.POST)
	public @ResponseBody Task findById(@RequestBody Task task) {
		return service.findById(task.getId());
	}



}
