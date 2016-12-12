package edu.iss.caps.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.iss.caps.model.Lecturer;

@Component
public class LecturerValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Lecturer.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "lecturerName", "error.lecturerName", "Please fill in the Lecturer Name.");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "status", "error.status", "Please enter a status.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(e, "gender", "error.gender", "Please select a gender.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(e, "dob", "error.dob", "Please select a date of birth");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "error.email", "Please enter an email.");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "address", "error.address", "Please enter an address.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(e, "employedDate", "error.employedDate", "Please select an employement start date.");
		/*ValidationUtils.rejectIfEmptyOrWhitespace(e, "lecturerFacultyID", "error.lecturerFacultyID", "Please select a faculty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "lecturerDepartmentID","error.lecturerDepartmentID", "Please select a department.");*/
		/*ValidationUtils.rejectIfEmptyOrWhitespace(e, "username","error.username", "Username Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "password","error.password", "Password Required.");*/
		//ValidationUtils.rejectIfEmptyOrWhitespace(e, "role", "error.role", "Role of User Required.");
		
		
	}

}
