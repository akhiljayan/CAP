package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.repository.StudentgradeRepository;

@Service
public class StudentgradeServiceImpl implements StudentgradeService{

	@Resource
	private StudentgradeRepository sgrepository;

	@Override
	@Transactional
	public ArrayList<Studentgrade> findGradeBySid(int studentID) {
		ArrayList<Studentgrade> sgrade = sgrepository.findGradeBySid(studentID);		
		return sgrade;
	}
	
	@Override
	@Transactional	
	public ArrayList<Studentgrade> getStudentGradeByCourse(int id)
	{
		ArrayList<Studentgrade> glist = (ArrayList<Studentgrade>) sgrepository.getStudentGradeByCourse(id);
		return glist;
		
	}
	
	@Override
	@Transactional
	public Studentgrade gradeStudent(int enrolmentID)
	{
		Studentgrade glist = sgrepository.gradeStudent(enrolmentID);
		return glist;
		
	}
			
	@Override
	@Transactional
	public void updateStudentGrade(String grade, int enrolmentID)
	{
		sgrepository.updateStudentGrade(grade, enrolmentID);
	}
	
	@Override
	@Transactional
	public ArrayList<Studentgrade> viewEnrolmentByCourseID(int id) {
		ArrayList<Studentgrade> sment = (ArrayList<Studentgrade>) sgrepository.viewEnrolmentByCourseID(id);		
		return sment;
	}
	
	@Override
	@Transactional
	public ArrayList<Studentgrade> viewPerformanceByStudentID(int id) {
		ArrayList<Studentgrade> sperf = (ArrayList<Studentgrade>) sgrepository.viewPerformanceByStudentID(id);
		return sperf;
	}

	@Override
	@Transactional
	public Studentgrade createEnrolment(Studentgrade enrolment) {
		return sgrepository.saveAndFlush(enrolment);
	}

	@Override
	@Transactional
	public Studentgrade findGradeBySidCid(Student student, Courseinfo crs) {
		return sgrepository.findGradeByCourseStudent(student,crs);
	}

	@Override
	@Transactional
	public ArrayList<Studentgrade> findAllEnrolmentRequests() {
		return sgrepository.findAllEnrolmentRequests();
	}
	
}
