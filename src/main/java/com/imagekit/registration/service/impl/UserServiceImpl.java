package com.imagekit.registration.service.impl;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.imagekit.registration.dto.User;
import com.imagekit.registration.model.DatabaseSequence;
import com.imagekit.registration.model.UserEntity;
import com.imagekit.registration.repository.UserRepository;
import com.imagekit.registration.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveUser(@Valid User userDto, String ip) {
		userRepo.save(UserDtoToEntityConverter(userDto, ip));
	}

	private UserEntity UserDtoToEntityConverter(User userDto, String ip) {
		UserEntity user = new UserEntity();
		user.setId(generateSequence(UserEntity.SEQUENCE_NAME));
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setIp(ip);
		user.setPassword(userDto.getPassword());
		return user;
	}

	private long generateSequence(String seqName) {
		Query query = new Query();
		DatabaseSequence counter = mongoTemplate.findAndModify(query.addCriteria(Criteria.where("_id").is(seqName)),
				new Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
				DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}

	@Override
	public int getIpCount(String Ip) {
		List<UserEntity> userList = userRepo.findByIp(Ip);
		if (userList == null) {
			return 0;
		} else {
			return userList.size();
		}
	}

}
