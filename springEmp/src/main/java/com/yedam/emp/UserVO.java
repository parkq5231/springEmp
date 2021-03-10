package com.yedam.emp;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String name;
	private String role;
	@NotNull
	private String oldpassword;
	@NotNull
	private String password;
	@NotNull
	private String newpassword;
}
