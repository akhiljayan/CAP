package edu.iss.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.Studentgrade;



public interface StudentgradeRepository extends JpaRepository<Studentgrade,Integer>{

	@Query("SELECT s FROM Studentgrade s WHERE s.studentID.studentID=:studentID")
	ArrayList<Studentgrade> findGradeBySid(@Param("studentID") int studentID);
	
	@Query("select sg from Studentgrade sg where sg.courseID.courseID = :courseID")
	ArrayList<Studentgrade> getStudentGradeByCourse(@Param("courseID") int courseID);

	
	@Query("select sg from Studentgrade sg where sg.enrolmentID = :enrolmentID")
	Studentgrade gradeStudent(@Param("enrolmentID") int enrolmentID);
	
	@Modifying(clearAutomatically=true)	
	@Query("update Studentgrade sg set sg.grade = :grade where sg.enrolmentID = :enrolmentID")
	void updateStudentGrade(@Param("grade") String grade, @Param("enrolmentID") int enrolmentID);
	
	@Query("select sg from Studentgrade sg where sg.courseID.courseID = :id")
	ArrayList<Studentgrade> viewEnrolmentByCourseID(@Param("id")int id);


	@Query("select sg from Studentgrade sg, Courseinfo ci WHERE sg.courseID.courseID = ci.courseID.courseID and sg.studentID.studentID = :id")
	ArrayList<Studentgrade> viewPerformanceByStudentID(@Param("id")int id);

	@Query("select sg from Studentgrade sg where sg.studentID = :student and sg.courseID = :crs")
	Studentgrade findGradeByCourseStudent(@Param("student") Student student,@Param("crs") Courseinfo crs);
	
}
