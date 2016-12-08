  package edu.iss.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.caps.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	/*@Query("SELECT d FROM Department d WHERE u.departmentID=:id")
	Department findOneDepartmentById(@Param("id") int id);*/
	
}
