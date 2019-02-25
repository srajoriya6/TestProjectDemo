package com.raystech.proj0.form;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.raystech.proj0.util.DataValidator;

@Component
public class CollegeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CollegeForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CollegeForm collegeForm = (CollegeForm) target;

		String name = collegeForm.getName();
		String address = collegeForm.getAddress();

		if (!DataValidator.isNull(name)) {
			errors.rejectValue("name", "College Name is not valid");
		}
		if (!DataValidator.isNull(address)) {
			errors.rejectValue("address", "College Address is not valid");
		}
	}

}
