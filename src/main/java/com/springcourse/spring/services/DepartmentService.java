package com.springcourse.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.spring.entities.Department;
import com.springcourse.spring.repositories.DepartmentRepository;

@Service //Component Register
public class DepartmentService {
	@Autowired
	private DepartmentRepository userRepository;
	
	public List<Department> findAll(){
		return userRepository.findAll();
	}
	public Department findById(Long id) {
		Optional<Department> obj = userRepository.findById(id);
		return obj.get();
	}
}