package com.redis.demo.CRUD.service;

import org.springframework.http.ResponseEntity;

import com.redis.demo.CRUD.dto.CreateUserReqDto;
import com.redis.demo.CRUD.dto.FetchUserReqDto;

public interface RedisService {

	ResponseEntity<?> fetchUser(FetchUserReqDto fetchUserReqDto);

	ResponseEntity<?> createUser(CreateUserReqDto createUserReqDto);

}
