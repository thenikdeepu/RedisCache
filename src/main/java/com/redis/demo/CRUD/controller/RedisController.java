package com.redis.demo.CRUD.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;

import com.redis.demo.CRUD.dto.CreateUserReqDto;
import com.redis.demo.CRUD.dto.FetchUserReqDto;
import com.redis.demo.CRUD.service.RedisService;
import com.redis.demo.generic.ResponseDto;
import com.redis.demo.generic.ResponseMessage;

@RestController
@RequestMapping("redis/demo")
public class RedisController {

	private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

	@Autowired
	private RedisService redisService;
	
	public static final String HASH_KEY_NAME = "MENU-ITEM";
	
    @Autowired
    private RedisTemplate redisTemplate;

	@PostMapping("/fetchUser")
	public ResponseEntity<?> fetchUser(@Valid @RequestBody FetchUserReqDto fetchUserReqDto, Errors error,
			HttpServletRequest request) {
		logger.info("Inside RedisController :: Inside fetchUser");
		if (error.hasErrors()) {
			return new ResponseEntity<>(
					new ResponseDto(ResponseMessage.ERROR_CODE, error.getAllErrors().get(0).getDefaultMessage(), null),
					HttpStatus.BAD_REQUEST);
		} else {
			return redisService.fetchUser(fetchUserReqDto);
		}
	}

	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserReqDto createUserReqDto, Errors error,
			HttpServletRequest request) {
		logger.info("Inside RedisController :: Inside createUser");
		if (error.hasErrors()) {
			return new ResponseEntity<>(
					new ResponseDto(ResponseMessage.ERROR_CODE, error.getAllErrors().get(0).getDefaultMessage(), null),
					HttpStatus.BAD_REQUEST);
		} else {
			return redisService.createUser(createUserReqDto);
		}
	}

}
