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

	private static final Logger logger = Logger.getLogger(UserServer.class);

	@Autowired
	UserService service;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/usertest", method = RequestMethod.GET)
	public @ResponseBody User usertest() {

		User mood = new User();
		mood.setId(1);
		mood.setFullname("name");
		System.out.println(mood);
		return mood;
	}

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		logger.debug("xxxxxx/ntestdebug");
		logger.error("xxxxxx/ntesterror");

		List<User> list = service.findAllUsers();
		for (User user : list) {
			System.out.println(user);
		}
		return list;
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user) {
		logger.debug(user);
		System.out.println("userxxxxxx/n/n/n/n/n" + user + "/n/n/n/n");
		logger.error("userxxxxxx/n/n/n/n/n" + user + "/n/n/n/n");
		logger.debug("userxxxxxx/n/n/n/n/n" + user + "/n/n/n/n");
		service.saveUser(user);
		return user;
	}



}
