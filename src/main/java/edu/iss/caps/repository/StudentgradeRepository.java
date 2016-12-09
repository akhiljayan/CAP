package edu.iss.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Studentgrade;



public interface StudentgradeRepository extends JpaRepository<Studentgrade,Integer>{

	@Query("SELECT s FROM Studentgrade s WHERE s.studentID.studentID=:studentID")
	ArrayList<Studentgrade> findGradeBySid(@Param("studentID") int studentID);
	
}
