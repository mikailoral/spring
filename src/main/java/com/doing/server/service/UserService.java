package com.doing.server.service;

import java.util.List;

import com.doing.server.pojo.User;

public interface UserService {

	User findById(int id);
	void saveUser(User user);
	User updateUser(User user);
	User updateLocation(User user);
	void deleteUserById(int id);
	List<User> findAllUsers(User user); 
	User findUserByName(String name);
	boolean isUserNameUnique(Integer id, String name);
}
