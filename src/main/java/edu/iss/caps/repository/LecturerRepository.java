package edu.iss.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.caps.model.Lecturer;


public interface LecturerRepository  extends JpaRepository<Lecturer, Integer>{

}
