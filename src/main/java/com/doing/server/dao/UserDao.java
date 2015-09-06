package com.doing.server.dao;

import java.util.List;

import com.doing.server.pojo.User;

public interface UserDao {

	User findById(int id);
	void saveUser(User user);
	void deleteUserById(int id);
	List<User> findAllUsers(User user);
	User findUserByName(String name);

}
