package com.andremata.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andremata.hruser.entities.User;
import com.andremata.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserRepository repository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findMyId(@PathVariable Long id) {
		User user = repository.findById(id).get();
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {		
		User user = repository.findByEmail(email);
		
		return ResponseEntity.ok(user);
	}
}
