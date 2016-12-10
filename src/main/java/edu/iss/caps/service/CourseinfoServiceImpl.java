package edu.iss.caps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.repository.CourseinfoRepository;

@Service
public class CourseinfoServiceImpl implements CourseinfoService{
	
	@Resource
	private CourseinfoRepository courseRepository;

	@Override
	public String findCourseNameByID(int courseID) {
		return courseRepository.findOne(courseID).getCourseName();
	}

	@Override
	@Transactional
	public ArrayList<Courseinfo> findAllCourseinfos() {
		ArrayList<Courseinfo> courseinfoList = (ArrayList<Courseinfo>)courseRepository.findAll();
		return courseinfoList;
	}

	@Override
	@Transactional
	public Courseinfo createCourseinfo(Courseinfo courseInfo) {
		return courseRepository.saveAndFlush(courseInfo);
	}

	@Override
	@Transactional
	public Courseinfo findCourseinfo(int courseID) {
		return courseRepository.findOne(courseID);
	}

	@Override
	@Transactional
	public Courseinfo changeCourseinfo(Courseinfo courseInfo) {
		return courseRepository.saveAndFlush(courseInfo);
	}

	@Override
	@Transactional
	public void removeCourseinfo(Courseinfo courseInfo) {
		courseRepository.delete(courseInfo);
	}

	@Override
	public ArrayList<Courseinfo> findAllActiveCourses() {
		return courseRepository.findAllActiveCourses();
	}
	
}
