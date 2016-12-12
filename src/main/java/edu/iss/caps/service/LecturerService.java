package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Lecturer;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;

public interface LecturerService {
	
	ArrayList<Lecturer> findAllLecturer();
	
	Lecturer getCourseByLecturerID(int id);

	Lecturer findOneByUserId(User user);

	Lecturer findOneByLectId(int id);
		
	ArrayList<Lecturer> findAllEmployedLecturers();
	
	ArrayList<Integer> findAllLecturerIDs();
	
	Lecturer createLecturer(Lecturer lecturer);
 
	Lecturer findLecturer(int id);
	
	Lecturer changeLecturer(Lecturer lecturer);
	
}
