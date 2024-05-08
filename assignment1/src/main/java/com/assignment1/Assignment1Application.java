package com.assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.assignment1.service.UserService;



@SpringBootApplication
@EnableScheduling
@CrossOrigin("*")
public class Assignment1Application implements CommandLineRunner{
	 @Autowired
		private UserService userService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Assignment1Application.class, args);
	}
	
	@Override
	public void run(String... args)throws Exception{
		System.out.println("starting code!!!");
		
//		User user=new User();
//		
//		
//		  user.setFirstName("shivansh"); user.setLastName("singh");
//		  user.setUsername("shivaaanshhhh"); 
//		  user.setEmail("shivansh@gmail.com"); user.setcPassword("abc");
//		  user.setProfile("default.png");
//		  user.setPassword("abc");
//		 
//		  Role role1=new Role();
//		  role1.setRoleId(44L);
//		  role1.setRoleName("ADMIN");
//		  
//		  Set<UserRole> userRoleSet = new HashSet<>();
//		  UserRole userRole = new UserRole();
//		  
//		  userRole.setRole(role1);
//		  
//		  userRole.setUser(user);
//		  
//		  userRoleSet.add(userRole);
//		  
//		  User user1 = this.userService.createUser(user, userRoleSet);
//		  System.out.println(user1.getUsername());
//		 
//		 
//		
//		
//		 
	}
	@Bean
	public WebMvcConfigurer configurer() {
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registery) {
				registery.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
