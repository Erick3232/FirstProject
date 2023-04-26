package com.springcourse.spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.spring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //Recurso Web que vai ser controlado por um Rest e ligar com o User
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria", "maria@hotmail.com", "113984984", "12345"); //Create a new User in json
		return ResponseEntity.ok().body(u);
	}
}
