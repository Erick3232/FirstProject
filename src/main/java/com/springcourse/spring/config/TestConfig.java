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
	User u6 = new User(null, "Burguesisisa", "burgoss@hotmail.com", "11456878532", "buburgogos");
	User u7 = new User(null, "Renascimento Urbano", "renascimentoUC@hotmail.com", "1148935632", "baixaidademedia");
	User u8 = new User(null, "Império Bizantino", "bizancio@hotmail.com", "1178953268", "ImperioBizantino");
	User u9 = new User(null, "Império Otomano", "otomanobe@hotmail.com", "1189322849", "ImperioOtomanao");
	User u10 = new User(null, "Grande Peste", "pespeste@hotmail.com", "11010101100", "pestebulbonica");
	
	userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10)); //Save in database
}
	
}
