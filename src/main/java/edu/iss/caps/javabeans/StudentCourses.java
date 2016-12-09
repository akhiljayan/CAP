package edu.iss.caps.javabeans;

import java.util.ArrayList;
import java.util.Date;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Studentgrade;

public class StudentCourses {

	
	private String studentName;
	private String courseName;
	private String grade;
	private String completionStatus;
	private String enrolledDate;
	
	public String getEnrolledDate() {
		return enrolledDate;
	}
	public void setEnrolledDate(String enrolledDate) {
		this.enrolledDate = enrolledDate;
	}
	public StudentCourses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}
	
/*	private ArrayList<Studentgrade> studentgrades = null ;
	private ArrayList<String> courses = null;
	
	public StudentCourses() {
		super();
		
	}

	

	public ArrayList<Studentgrade> getStudentgrades() {
		return studentgrades;
	}



	public void setStudentgrades(ArrayList<Studentgrade> studentgrades) {
		this.studentgrades = studentgrades;
	}



	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	*/
}
