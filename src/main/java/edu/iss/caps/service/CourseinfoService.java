  package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Courseinfo;

public interface CourseinfoService {
	
	String findCourseNameByID(int courseID);
	
	ArrayList<Courseinfo> findAllCourseinfos();
	
	Courseinfo createCourseinfo(Courseinfo courseInfo);
	
	Courseinfo findCourseinfo(int courseID);
	
	Courseinfo changeCourseinfo(Courseinfo courseInfo);
	
	void removeCourseinfo(Courseinfo courseInfo);
	
	ArrayList<Courseinfo> findAllActiveCourses();
	
}
