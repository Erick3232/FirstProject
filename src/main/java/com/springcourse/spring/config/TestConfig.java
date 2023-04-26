package com.springcourse.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springcourse.spring.entities.User;
import com.springcourse.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //database seeding
	@Autowired //realiza automaticamente 
	private UserRepository userRepository; //Injection Dependency

@Override
public void run(String... args) throws Exception {
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
	
	userRepository.saveAll(Arrays.asList(u1,u2)); //Save in database
}
	
}
