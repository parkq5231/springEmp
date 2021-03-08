package com.yedam.emp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO vo = (UserVO) target;
		if(vo.getNewpassword().equals(vo.getNewpassword2())) {
			
		}
	}
}
