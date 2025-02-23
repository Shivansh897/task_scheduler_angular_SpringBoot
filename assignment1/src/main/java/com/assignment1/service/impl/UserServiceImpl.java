package com.assignment1.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.User;
import com.assignment1.model.UserRole;
import com.assignment1.repo.RoleRepository;
import com.assignment1.repo.UserRepository;
import com.assignment1.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	// creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception 
	{
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is already present!!!");
			throw new Exception("User already present!!");
		}
		else {
			
			//user create
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
		}
		return local;
	}
	
	//getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
