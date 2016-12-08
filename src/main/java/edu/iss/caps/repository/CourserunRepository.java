package edu.iss.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.caps.model.Courserun;
import edu.iss.caps.model.CourserunPK;


public interface CourserunRepository extends JpaRepository<Courserun, CourserunPK> {

}
