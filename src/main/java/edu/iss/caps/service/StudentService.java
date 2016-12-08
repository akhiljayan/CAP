package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Student;

public interface StudentService {
	
	ArrayList<Student> findAllStudents();
	
	ArrayList<Student> findStudentsBySearch(String value);
	
	Student createStudent(Student student);
	
	Student findOneStudent(int id);
	
	Student changeStudent(Student student);
	
	void removeStudent(Student student);
}
