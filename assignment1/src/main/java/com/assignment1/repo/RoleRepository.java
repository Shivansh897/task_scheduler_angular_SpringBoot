package com.assignment1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment1.model.Role;

public interface RoleRepository extends JpaRepository<Role ,Long> {

}
