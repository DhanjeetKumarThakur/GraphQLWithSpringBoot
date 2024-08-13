package com.learning.graphQLWithSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.graphQLWithSpringBoot.entity.User;
import com.learning.graphQLWithSpringBoot.helper.ExceptionHelper;
import com.learning.graphQLWithSpringBoot.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	private UserRepo userRepo;

	//Auto injection will be done by constructor while spring container creating objects 
	//that's why we have not used @Autowired annotation on UserRepo attribute  
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User updateUser= userRepo.findById(user.getUserId()).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		updateUser.setEmail(user.getEmail());
		updateUser.setName(user.getName());
		updateUser.setPassword(user.getPassword());
		updateUser.setUserId(user.getUserId());
		return updateUser;
	}

	@Override
	public boolean deleteUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
		userRepo.delete(user);
		return true;
	}
	
	
	
	
}
