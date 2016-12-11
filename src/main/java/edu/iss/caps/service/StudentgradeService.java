package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Studentgrade;

public interface StudentgradeService {

	ArrayList<Studentgrade> findGradeBySid(int studentID);
	
	ArrayList<Studentgrade> getStudentGradeByCourse(int id);
	
	Studentgrade gradeStudent(int enrolmentID);
	
	void updateStudentGrade(String grade, int enrolmentID);

	ArrayList<Studentgrade> viewEnrolmentByCourseID(int id);
	
	ArrayList<Studentgrade> viewPerformanceByStudentID(int id);

	Studentgrade createEnrolment(Studentgrade enrolment);
	
}
