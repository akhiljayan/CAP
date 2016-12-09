package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Faculty;

public interface FacultyService {

	ArrayList<Faculty> findAllFaculty();
	
	Faculty finfOneById(int id);
	
	Faculty createFaculty(Faculty Faculty);
	
	Faculty findFaculty(int id);
	
	Faculty changeFaculty(Faculty Faculty);
	void removeFaculty(Faculty Faculty);
	
}
