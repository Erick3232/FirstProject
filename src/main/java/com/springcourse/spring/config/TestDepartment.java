package com.springcourse.spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springcourse.spring.entities.Department;
import com.springcourse.spring.repositories.DepartmentRepository;

@Configuration
@Profile("test")
public class TestDepartment implements CommandLineRunner{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		Department d1 = new Department(null, "Industrial");
		Department d2 = new Department(null, "Eletronics"); 
		Department d3 = new Department(null, "Automobilistcs"); 
		Department d4 = new Department(null, "Computers"); 
		Department d5 = new Department(null, "Comercial"); 
	
		departmentRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5));
	}
	
}
