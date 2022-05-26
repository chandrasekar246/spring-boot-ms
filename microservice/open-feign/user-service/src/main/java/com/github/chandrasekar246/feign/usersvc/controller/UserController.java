package com.github.chandrasekar246.feign.usersvc.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.feign.usersvc.model.User;
import com.github.chandrasekar246.feign.usersvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> add(@RequestBody User user) {
		Optional<User> optional = service.add(user);
		return optional.isPresent() ? new ResponseEntity<>(optional.get(), HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> read(@PathVariable int id) {
		Optional<User> optional = service.read(id);
		return optional.isPresent() ? new ResponseEntity<>(optional.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public Set<User> readAll() {
		return service.readAll();
	}
}