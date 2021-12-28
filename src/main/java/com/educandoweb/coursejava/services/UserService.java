package com.educandoweb.coursejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejava.entities.User;
import com.educandoweb.coursejava.repositories.UserRepository;

// @Component
@Service
public class UserService {

	// Para injeção de dependência seja feita pelo Spring Boot de forma transparente (automática)
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}