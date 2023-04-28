package com.springcourse.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springcourse.spring.entities.Department;
import com.springcourse.spring.entities.Order;
import com.springcourse.spring.entities.User;
import com.springcourse.spring.repositories.DepartmentRepository;
import com.springcourse.spring.repositories.OrderRepository;
import com.springcourse.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //database seeding
	@Autowired //realiza automaticamente 
	private UserRepository userRepository;//Injection Dependency
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
@Override
public void run(String... args) throws Exception {
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11988888888", "maria342312312");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "11977777777", "alex&greene");
	User u3 = new User(null, "João Goulart", "gou@hotmail.com", "1189656482","gougoularrat");
	
	Order o1 = new Order(null, Instant.parse("2019-07-22T15:21:07Z"), u1);
	Order o2 = new Order(null, Instant.parse("2019-07-22T15:21:10Z"), u2);
	Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u3);
	
	Department d1 = new Department(null, "Industrial");
	Department d2 = new Department(null, "Eletronics"); 
	Department d3 = new Department(null, "Automobilistcs");

	
	userRepository.saveAll(Arrays.asList(u1,u2,u3)); //Save in database
	orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	departmentRepository.saveAll(Arrays.asList(d1,d2,d3));
}
	
}
