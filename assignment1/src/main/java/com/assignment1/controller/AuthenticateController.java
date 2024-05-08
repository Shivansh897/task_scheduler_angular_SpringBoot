package com.assignment1.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.config.JwtUtils;
import com.assignment1.model.JwtRequest;
import com.assignment1.model.JwtResponse;
import com.assignment1.model.User;
import com.assignment1.service.impl.UserDetailsServiceImpl;

@RestController
//@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticateManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	//generate token
	
	@PostMapping("/generate_token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
			
		}
		
		//////authenticate user
		
		UserDetails userDetails= this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			
			authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}
		catch(DisabledException e) {
			throw new Exception("USER DISABLED" + e.getMessage());
		}catch(BadCredentialsException e) {
			throw new Exception("invalid credentials" + e.getMessage());
		}
	}
	
	//return the details of current user
	
	@GetMapping("/current_user")
	public User getCurrentUser(Principal principal) {
		
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
	}
	

}
