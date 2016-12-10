package edu.iss.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.iss.caps.model.Courseinfo;


public interface CourseinfoRepository extends JpaRepository<Courseinfo, Integer> {

	@Query("SELECT c FROM Courseinfo c WHERE c.CourseActiveStatus = 'Active'")
	ArrayList<Courseinfo> findAllActiveCourses();
	
}
