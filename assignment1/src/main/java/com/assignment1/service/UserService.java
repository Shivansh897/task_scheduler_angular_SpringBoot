package com.assignment1.service;

import java.util.List;
import java.util.Set;

import com.assignment1.model.User;
import com.assignment1.model.UserRole;

public interface UserService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles ) throws Exception;

	
     //get user by username
	 public User getUser(String username);
	 
	 public List<User> getAllUsers(); 

}
