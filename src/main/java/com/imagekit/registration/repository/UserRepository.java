package com.imagekit.registration.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.imagekit.registration.model.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
	
	List<UserEntity> findByIp(String ip);
}
