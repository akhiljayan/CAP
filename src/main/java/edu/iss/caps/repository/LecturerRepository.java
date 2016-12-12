package edu.iss.caps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Lecturer;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.User;


public interface LecturerRepository  extends JpaRepository<Lecturer, Integer>{
	
	@Query("SELECT l FROM Lecturer l WHERE l.userID = :user")
	Lecturer findLecturerByUserId(@Param("user") User user);
	
	@Query("SELECT l FROM Lecturer l WHERE l.status='Employed'")
	ArrayList<Lecturer> findAllEmployedLecturers();
	
	@Query("SELECT DISTINCT l.lecturerID FROM Lecturer l")
	ArrayList<Integer> findAllLecturerIDs();
	
}
