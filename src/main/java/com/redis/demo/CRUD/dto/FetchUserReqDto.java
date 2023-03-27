package com.redis.demo.CRUD.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

public class FetchUserReqDto {

	@NotNull(message = "First name can not be null.", groups = Default.class)
	@NotEmpty(message = "First name can not be empty.", groups = Default.class)
	private List<@NotNull(message = "First name can not be null.", groups = Default.class) @NotEmpty(message = "First name can not be empty.", groups = Default.class) @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid First name.", groups = Default.class) String> firstName;

	public List<String> getFirstName() {
		return firstName;
	}

	public void setFirstName(List<String> firstName) {
		this.firstName = firstName;
	}

}
