package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.repository.StudentgradeRepository;

@Service
public class StudentgradeServiceImpl implements StudentgradeService{
	
	@Resource
	private StudentgradeRepository studentGradeRepository;

	@Override
	@Transactional
	public ArrayList<Studentgrade> findGradeBySid(int studentID) {
		ArrayList<Studentgrade> sgrade = studentGradeRepository.findGradeBySid(studentID);		
		return sgrade;
	}
	
}
