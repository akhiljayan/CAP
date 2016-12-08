package edu.iss.caps.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SampleValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		//Validator MEOW MEOW ...:P
	}

}
