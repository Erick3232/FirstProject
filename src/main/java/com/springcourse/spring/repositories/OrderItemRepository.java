package com.springcourse.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.spring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}

