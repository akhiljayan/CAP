package edu.iss.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.caps.model.Courseinfo;

@Component
public class CourseinfoValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Courseinfo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "courseName" , "error.courseName" , "course name is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"courseDescription", "error.courseDescription", "course description is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"maxClassSize", "error.maxClassSize", "max class Size is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"credits", "error.credits", "credits  is required!");
	
	}

}
