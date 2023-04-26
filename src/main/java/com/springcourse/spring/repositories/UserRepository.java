package com.springcourse.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
