package edu.iss.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



import edu.iss.caps.model.Faculty;

@Component
public class FacultyValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Faculty.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {

		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "facultyName", "error.facultyName", "faculty name is required.");
		
		
	}

}
