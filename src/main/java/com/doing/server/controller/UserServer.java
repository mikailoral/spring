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

import com.doing.server.pojo.User;
import com.doing.server.service.UserService;

@RestController
public class UserServer {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(UserServer.class);

	@Autowired
	UserService service;

	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = "/listuser", method = RequestMethod.POST)
	public @ResponseBody List<User> getUsers(@RequestBody User userp) {

		List<User> list = service.findAllUsers(userp);
		for (User user : list) {
			System.out.println(user);
		}
		return list;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user) {
		service.saveUser(user);
		return user;
	}
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public @ResponseBody User updateUser(@RequestBody User user) {
		service.updateUser(user);
		return user;
	}

	@RequestMapping(value = "/updateuserlocation", method = RequestMethod.POST)
	public @ResponseBody User updateLocation(@RequestBody User user) {
		service.updateLocation(user);
		return user;
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody User user) {
		service.deleteUserById(user.getId());
	}
	
	@RequestMapping(value = "/getuser", method = RequestMethod.POST)
	public @ResponseBody User findById(@RequestBody User user) {
		return service.findById(user.getId());
	}



}
