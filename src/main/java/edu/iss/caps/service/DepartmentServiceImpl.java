package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Department;
import edu.iss.caps.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentRepository drepo;
	
	@Override
	@Transactional
	public ArrayList<Department> findAllDepartments() {
		ArrayList<Department> departments = (ArrayList<Department>) drepo.findAll();
		return departments;
	}

	@Override
	@Transactional
	public Department findOneById(int id) {
		Department dpt = drepo.findOne(id); 
		return dpt;
	}
	
	@Override
	@Transactional
	public Department createDepartment(Department Department) {
		return drepo.saveAndFlush(Department);
		 
	}
	
	@Override
	@Transactional
	public Department findDepartment(int id) {
		return drepo.findOne(id);
	}
	
	@Override
	@Transactional
	public Department changeDepartment(Department department) {
		return drepo.saveAndFlush(department);
	}

	@Override
	@Transactional
	public void removeDepartment(Department department) {
		drepo.delete(department);
	}

}
