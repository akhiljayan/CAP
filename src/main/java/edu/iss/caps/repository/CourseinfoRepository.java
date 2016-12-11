package edu.iss.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Student;


public interface CourseinfoRepository extends JpaRepository<Courseinfo, Integer> {

	@Query("SELECT c FROM Courseinfo c WHERE c.CourseActiveStatus = 'Active'")
	ArrayList<Courseinfo> findAllActiveCourses();

	@Query("SELECT c FROM Courseinfo c WHERE c.CourseActiveStatus = 'Active' AND c NOT IN (SELECT s.courseID FROM Studentgrade s WHERE s.studentID = :studentID)")
	ArrayList<Courseinfo> findAvailableCourseForStudent(@Param("studentID") Student studentID);
	
}
