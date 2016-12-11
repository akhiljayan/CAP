package edu.iss.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import edu.iss.caps.model.Department;

@Component
public class DepartmentValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Department.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "departmentName", "error.departmentName", "department name is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(e, "facultyID", "error.facultyID", "faculty name is required.");
	}

}
