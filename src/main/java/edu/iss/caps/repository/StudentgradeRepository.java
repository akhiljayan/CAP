package edu.iss.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.model.StudentgradePK;


public interface StudentgradeRepository extends JpaRepository<Studentgrade,StudentgradePK>{

}
