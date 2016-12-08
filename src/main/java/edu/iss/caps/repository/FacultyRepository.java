package edu.iss.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Faculty;


public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	
	
}
