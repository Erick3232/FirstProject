package com.springcourse.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.spring.entities.Order;
import com.springcourse.spring.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource { //Recurso Web que vai ser controlado por um Rest e ligar com o Order
	
	@Autowired
	private OrderService service; //injection dependency
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}") //requisição para aceitar um id na URL
	public ResponseEntity<Order> findById(@PathVariable Long id){ //PathVariable = O spring vai aceitar isso com id, só por conta do Path
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
