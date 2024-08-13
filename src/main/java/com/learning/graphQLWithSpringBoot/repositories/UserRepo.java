package com.learning.graphQLWithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.graphQLWithSpringBoot.entity.User;

@Repository //It is optional to use @Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
