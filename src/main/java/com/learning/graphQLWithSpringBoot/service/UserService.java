package com.learning.graphQLWithSpringBoot.service;

import java.util.List;

import com.learning.graphQLWithSpringBoot.entity.User;

public interface UserService {

	//creating User
	public User createUser(User user);

	//getting all users
	public List<User> getAllUser();
	
	//getting single user
	public User getUser(int userId);
	
	//updating user
	public User updateUser(User user);
	
	//delete user
	public boolean deleteUser(int userId);
}
