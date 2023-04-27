package com.springcourse.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.spring.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
