package com.learning.graphQLWithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.graphQLWithSpringBoot.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

	//We don't need any class to implement this because Spring Boot Data JPA will generate a class at runtime 
}
