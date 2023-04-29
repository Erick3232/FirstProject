package com.springcourse.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springcourse.spring.entities.Order;
import com.springcourse.spring.entities.User;
import com.springcourse.spring.repositories.OrderRepository;
import com.springcourse.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //database seeding
	@Autowired //realiza automaticamente 
	private UserRepository userRepository;//Injection Dependency
	@Autowired
	private OrderRepository orderRepository;
	
@Override
public void run(String... args) throws Exception {
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11988888888", "maria342312312");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "11977777777", "alex&greene");
	User u3 = new User(null, "João Goulart", "gou@hotmail.com", "1189656482","gougoularrat");
	
	Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
	Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
	Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
	
	userRepository.saveAll(Arrays.asList(u1,u2,u3)); //Save in database
	orderRepository.saveAll(Arrays.asList(o1,o2,o3));
}
	
}
