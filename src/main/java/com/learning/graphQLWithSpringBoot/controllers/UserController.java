package com.learning.graphQLWithSpringBoot.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.graphQLWithSpringBoot.entity.User;
import com.learning.graphQLWithSpringBoot.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	// create User API
	@MutationMapping
	//Usaully we create like public User createUser(User user) but for this GraphQL mapping 
	public User createUser(@Argument int userId,@Argument String name, @Argument String phone, @Argument String email,@Argument String password) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUserId(userId);
		return userService.createUser(user);
	}
	
	//Get all users
	//here we have used name attribute because query method name is different then controller handler
	@QueryMapping(name = "getUsers") 
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	//Get single User
	@QueryMapping
	public User getUser(@Argument int userId) {
		return userService.getUser(userId);
	}
	
	@MutationMapping
	public boolean deleteUser(@Argument int userId) {
		return userService.deleteUser(userId);
	}
}
