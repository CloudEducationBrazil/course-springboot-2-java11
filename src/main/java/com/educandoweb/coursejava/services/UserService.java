package com.educandoweb.coursejava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejava.entities.User;
import com.educandoweb.coursejava.repositories.UserRepository;
import com.educandoweb.coursejava.services.exceptions.DatabaseException;
import com.educandoweb.coursejava.services.exceptions.ResourceNotFoundException;

// @Component
@Service
public class UserService {

	// Injeção de dependência - Dependency Injection
	// Feita pelo Spring Boot de forma transparente (automática)
	// Padrão de desenvolvimento de sistemas
	// para manter baixo o nível de acoplamento entre diferentes módulos de um sistema
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		//return obj.get();
		return obj.orElseThrow( () -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj){
		return repository.save(obj);
	}

	public void delete(Long id){
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e ) {
			throw new DatabaseException(e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace(); // Verificar o tipo da mensagem de erro
		}
	}

	public User update(Long id, User obj){
		User entity = repository.getById(id); // getOne(id); prepara o objeto monitorado
		updateData(entity, obj);
		return repository.save(entity);
	}	

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		//entity.setPassword(obj.getPassword()); // Por conta de segurança
	}
}
