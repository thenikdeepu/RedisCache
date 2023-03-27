package com.redis.demo.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redis.demo.CRUD.model.UserRoleDetails;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface UserRoleDetailsDao extends JpaRepository<UserRoleDetails, Long> {

	@Query(value = "Select * from UserRoleDetails where FirstName IN (:firstName) ", nativeQuery = true)
	List<UserRoleDetails> fetchUserDetails(@Param("firstName") List<String> firstName);

}
