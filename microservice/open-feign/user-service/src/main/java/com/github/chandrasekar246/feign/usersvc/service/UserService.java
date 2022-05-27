package com.github.chandrasekar246.feign.usersvc.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.feign.usersvc.model.User;
import com.github.chandrasekar246.feign.usersvc.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	public Optional<User> add(User user) {
		return repo.create(user);
	}

	public Optional<User> findById(Integer id) {
		return repo.findById(id);
	}

	public Set<User> findAll() {
		return repo.findAll();
	}

}
