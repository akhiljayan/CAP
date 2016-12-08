package edu.iss.caps.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Student;


public interface StudentRepository extends JpaRepository<Student,Integer>{

	@Query("SELECT s FROM Student s WHERE s.studentName LIKE :un")
	ArrayList<Student> findSearch(@Param("un") String val);
	
}
