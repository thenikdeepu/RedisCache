package com.redis.demo.CRUD.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.redis.demo.CRUD.dao.UserRoleDetailsDao;
import com.redis.demo.CRUD.dto.CreateUserReqDto;
import com.redis.demo.CRUD.dto.FetchUserReqDto;
import com.redis.demo.CRUD.model.UserRoleDetails;
import com.redis.demo.generic.ResponseDto;
import com.redis.demo.generic.ResponseMessage;

@Service
public class RedisServiceImpl implements RedisService {

	private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Autowired
	private UserRoleDetailsDao userRoleDetailsDao;

	@Override
	public ResponseEntity<?> fetchUser(FetchUserReqDto fetchUserReqDto) {
		logger.info("Inside RedisServiceImpl :: Inside fetchUser");
		try {
			logger.info("Inside fetchUser: first Name List is {}", fetchUserReqDto.getFirstName());
			List<UserRoleDetails> userDetails = userRoleDetailsDao.fetchUserDetails(fetchUserReqDto.getFirstName());
			return new ResponseEntity<>(
					new ResponseDto(ResponseMessage.SUCCESS_API_CODE, ResponseMessage.SUCCESS_API_MSG,
							userDetails == null || userDetails.isEmpty() ? "NO DATA FOUND" : userDetails),
					HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Error while fetchUser details");
			logger.info(e.getMessage(), e);
			return new ResponseEntity<>(
					new ResponseDto(ResponseMessage.ERROR_CODE, ResponseMessage.ERROR_CODE_MESSAGE, null),
					HttpStatus.OK);

		}
	}

	@Override
	public ResponseEntity<?> createUser(CreateUserReqDto createUserReqDto) {
		logger.info("Inside RedisServiceImpl :: Inside createUser");
		try {
			logger.info("Inside create user : firstName is {}", createUserReqDto.getFirstName());
			logger.info("Inside create user : lastName is {}", createUserReqDto.getLastName());
			logger.info("Inside create user : mobileNumber is {}", createUserReqDto.getMobileNumber());
			UserRoleDetails userDetails = new UserRoleDetails(createUserReqDto);
			userRoleDetailsDao.save(userDetails);
			logger.info("User Created successfully");
			return new ResponseEntity<>(
					new ResponseDto(ResponseMessage.SUCCESS_API_CODE, ResponseMessage.SUCCESS_API_MSG, userDetails),
					HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Error while createUser details");
			logger.info(e.getMessage(), e);
			return new ResponseEntity<>(
					new ResponseDto(ResponseMessage.ERROR_CODE, ResponseMessage.ERROR_CODE_MESSAGE, null),
					HttpStatus.OK);
		}
	}

}
