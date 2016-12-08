package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Department;

public interface DepartmentService {

	ArrayList<Department> findAllDepartments();
	
	Department findOneById(int id);
	
}
