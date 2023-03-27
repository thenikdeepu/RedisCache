package com.redis.demo.CRUD.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

public class CreateUserReqDto {

	@NotNull(message = "First name can not be null.", groups = Default.class)
	@NotEmpty(message = "First name can not be empty.", groups = Default.class)
	@NotBlank(message = "First name can not be blank.", groups = Default.class)
	private String firstName;

	@NotNull(message = "First name can not be null.", groups = Default.class)
	@NotEmpty(message = "First name can not be empty.", groups = Default.class)
	@NotBlank(message = "First name can not be blank.", groups = Default.class)
	private String lastName;

	@NotNull(message = "First name can not be null.", groups = Default.class)
	private Long mobileNumber;

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
