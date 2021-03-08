package com.yedam.emp;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	@NotNull
	private String password;
	private String name;
	private String role;
	@NotNull
	private String newpassword;
	@NotNull
	private String newpassword2;
}
