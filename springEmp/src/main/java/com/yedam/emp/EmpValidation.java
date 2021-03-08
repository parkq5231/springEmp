package com.yedam.emp;

import org.springframework.validation.*;

public class EmpValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp = (EmpVO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", null, "Empty last_name is now allowed.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hire_date", null, "Empty hire_date is not allowed.");
		
		if (emp.getEmail() == null || emp.getEmail().isEmpty())
			errors.rejectValue("email", null, "email not null");

		if (emp.getDepartment_id() == null || emp.getDepartment_id().isEmpty())
			errors.rejectValue("department_id", null, "department_id not null");

	}
}// end of class