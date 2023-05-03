package com.springcourse.spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springcourse.spring.entities.Category;
import com.springcourse.spring.entities.Order;
import com.springcourse.spring.entities.OrderItem;
import com.springcourse.spring.entities.Product;
import com.springcourse.spring.entities.User;
import com.springcourse.spring.enums.OrderStatus;
import com.springcourse.spring.repositories.CategoryRepository;
import com.springcourse.spring.repositories.OrderItemRepository;
import com.springcourse.spring.repositories.OrderRepository;
import com.springcourse.spring.repositories.ProductRepository;
import com.springcourse.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //database seeding
		
	@Autowired //realiza automaticamente 
	private UserRepository userRepository;//Injection Dependency
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
@Override
public void run(String... args) throws Exception {
	
	Category cat1 = new Category(null, "Electronics");
	Category cat2 = new Category(null, "Books");
	Category cat3 = new Category(null, "Computers");
	
	Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
	Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
	Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
	Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
	Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
	
	categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
	p1.getCategories().add(cat2);
	p2.getCategories().add(cat1);
	p2.getCategories().add(cat3);
	p3.getCategories().add(cat3);
	p4.getCategories().add(cat3);
	p5.getCategories().add(cat2);
	
	productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "11988888888", "maria342312312");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "11977777777", "alex&greene");
	User u3 = new User(null, "João Goulart", "gou@hotmail.com", "1189656482","gougoularrat");
	
	Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
	Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
	Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u3);
	
	userRepository.saveAll(Arrays.asList(u1,u2,u3)); //Save in database
	orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	
	OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
	OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
	OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
	OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
	
	orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

}
	
}
