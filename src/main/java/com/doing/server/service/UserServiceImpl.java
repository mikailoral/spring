package com.doing.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doing.server.dao.UserDao;
import com.doing.server.pojo.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public void saveUser(User user) {
		dao.saveUser(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public User updateUser(User user) {
		User entity = dao.findById(user.getId());
		if (entity != null) {
			if (user.getEmail() != null) {
				entity.setEmail(user.getEmail());
			}
			if (user.getFullname() != null) {
				entity.setFullname(user.getFullname());
			}
			if (user.getPassword() != null) {
				entity.setPassword(user.getPassword());
			}
			if (user.getPhone1() != null) {
				entity.setPhone1(user.getPhone1());
			}
			if (user.getPhone2() != null) {
				entity.setPhone2(user.getPhone2());
			}
			if (user.getPhoto() != null) {
				entity.setPhoto(user.getPhoto());
			}
			if (user.getRole() != 0) {
				entity.setRole(user.getRole());
			}
		}
		
		return entity;
	}
	
	public User updateLocation(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setXlocation(user.getXlocation());
			entity.setYlocation(user.getYlocation());
		}
		return entity;
	}

	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}
	
	public List<User> findAllUsers(User user) {
		return dao.findAllUsers(user);
	}

	public User findUserByName(String name) {
		return dao.findUserByName(name);
	}

	public boolean isUserNameUnique(Integer id, String name) {
		User user = findUserByName(name);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
