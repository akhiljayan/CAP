package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Faculty;
import edu.iss.caps.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService{

	@Resource
	private FacultyRepository frepo;

	@Override
	@Transactional
	public ArrayList<Faculty> findAllFaculty() {
		ArrayList<Faculty> facultys = (ArrayList<Faculty>) frepo.findAll();
		return facultys;
	}

	@Override
	@Transactional
	public Faculty finfOneById(int id) {
		return frepo.findOne(id);
	}
	
}
