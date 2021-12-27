package com.educandoweb.coursejava.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.coursejava.entities.User;

// Anottations
@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Julia Maria", "juju@gmail.com", "88776655", "123");
		return ResponseEntity.ok().body(u);
	}
}
