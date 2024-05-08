package com.assignment1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment1.model.User;

public interface UserRepository extends JpaRepository<User , Long>{

	public User findByUsername(String username);
}

