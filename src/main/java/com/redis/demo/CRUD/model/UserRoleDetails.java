package com.redis.demo.CRUD.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.redis.demo.CRUD.dto.CreateUserReqDto;

@Entity
@Table(name = "UserRoleDetails")
@RedisHash("UserRoleDetails")
public class UserRoleDetails {

	@Id
	@Indexed
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserID", nullable = false)
	private Long userID;

	@Column(name = "FirstName", columnDefinition = "CHAR(50)", nullable = false)
	private String firstName;

	@Column(name = "LastName", columnDefinition = "CHAR(50)", nullable = false)
	private String lastName;

	@Column(name = "MobileNumber", columnDefinition = "LONG", nullable = false)
	private Long mobileNumber;

	public UserRoleDetails(CreateUserReqDto createUserReqDto) {
		super();
		this.firstName = createUserReqDto.getFirstName();
		this.lastName = createUserReqDto.getLastName();
		this.mobileNumber = createUserReqDto.getMobileNumber();
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
