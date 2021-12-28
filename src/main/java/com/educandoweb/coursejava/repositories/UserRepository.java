package com.educandoweb.coursejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejava.entities.User;

// JPA repository Interface) (sub framework); dependency injection (container), database seeding (popular dados)
public interface UserRepository extends JpaRepository<User, Long>  {
  
}
