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
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11988888888", "maria342312312");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "11977777777", "alex&greene");
	User u3 = new User(null, "João Goulart", "gou@hotmail.com", "1189656482","gougoularrat");
	User u4 = new User(null, "Napoleão Bonaparte", "emperoleon@hotmail.com", "11623549865", "bonbabona0231");
	User u5 = new User(null, "Joana Dark", "santadark@hotmail.com", "112328946", "jojojo12312");
	
	userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5)); //Save in database
}
	
}
