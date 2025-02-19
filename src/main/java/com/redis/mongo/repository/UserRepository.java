package com.redis.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.redis.mongo.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findByCity(String city);
}
