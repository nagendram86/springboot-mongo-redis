package com.redis.mongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.mongo.entity.User;
import com.redis.mongo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserRepository repo;

	@Cacheable(value = "users")
	@GetMapping
	public List<User> get() {
		log.info("returning list of all users");
		return repo.findAll();
	}

	@Cacheable(value = "users", key = "#id")
	@GetMapping("/{id}")
	public User get(@PathVariable String id) {
		log.info("returning user for id " + id);
		return repo.findById(id).get();
	}

	@PostMapping
	public User save(@RequestBody User user) {
		log.info("saving user details: " + user.toString());
		repo.save(user);
		return user;
	}

	@GetMapping("/demo")
	public User getDemo() {
		return User.builder()
				.name("demo")
				.email("demo@email.com")
				.city("hyd")
				.id("123")
				.phone("phone")
				.build();
	}
}
