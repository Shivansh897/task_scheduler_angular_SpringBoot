package com.assignment1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment1.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private com.assignment1.repo.UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("NO USER FOUND WITH THIS CRED");
		}
		
		return user;
	}

}
