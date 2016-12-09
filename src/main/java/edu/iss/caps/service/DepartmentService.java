package edu.iss.caps.service;

import java.util.ArrayList;

import edu.iss.caps.model.Department;

public interface DepartmentService {

	ArrayList<Department> findAllDepartments();
	
	Department findOneById(int id);
	
	Department createDepartment(Department Department);
	
	Department findDepartment(int id);
	
	Department changeDepartment(Department Department);
	
	void removeDepartment(Department Department);
	
}
