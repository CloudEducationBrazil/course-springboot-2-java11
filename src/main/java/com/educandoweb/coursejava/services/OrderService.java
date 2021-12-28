package com.educandoweb.coursejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejava.entities.Order;
import com.educandoweb.coursejava.entities.User;
import com.educandoweb.coursejava.repositories.OrderRepository;

// Annotation
@Service
public class OrderService {
	
	// Injeção de dependência - Dependency Injection
	@Autowired
	private OrderRepository repository;
	
	// Métodos da Classe findAll
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	// Métodos da Classe findById
	public Order findById(Long id){
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
