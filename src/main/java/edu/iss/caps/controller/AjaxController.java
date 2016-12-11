package edu.iss.caps.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.service.StudentService;
import edu.iss.caps.service.StudentgradeService;

@Controller
@RequestMapping(value = "/Ajax")
public class AjaxController {
	
	
	@Autowired
	private StudentService sservice;
	
	@Autowired
	private StudentgradeService sgservice;
	
	@Autowired
	private StudentgradeService gradeService;
	
	@RequestMapping(value = "/search-students/{value}", method = RequestMethod.GET)
	public ModelAndView searchStudents(Model model, HttpSession session, @PathVariable String value) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/studMang/showStudentsList");
		if(value.equals("--")){
			mav.addObject("slist", sservice.findAllStudents());	
		}else{
			mav.addObject("slist", sservice.findStudentsBySearch(value));	
		}
		return mav;
	}
	
	@RequestMapping(value = "/gradeCourseMenu/{id}", method = RequestMethod.POST)
	public ModelAndView showGradeByClass(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/gradebycourse");
		ArrayList<Studentgrade> glist = sgservice.getStudentGradeByCourse(id);
		mav.addObject("glist", glist);
		return mav;
	}
	
	@RequestMapping(value = "/viewPerformanceMenu/{id}", method = RequestMethod.POST)
	public ModelAndView showEnrolment(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("adminPage/lectrRole/enrolbycourse");
		ArrayList<Studentgrade> sment = sgservice.viewEnrolmentByCourseID(id);
		mav.addObject("sment", sment);		
		return mav;
	}
	
	@RequestMapping(value = "/search-students-enrolment/{value}/{courseId}", method = RequestMethod.POST)
	public ModelAndView searchStudentsEnrolment(Model model, HttpSession session, @PathVariable String value, @PathVariable String courseId) {
		ModelAndView mav = new ModelAndView("adminPage/adminRole/enrolManage/enroleStudentList");
		if(value.equals("--")){
			mav.addObject("students", sservice.findAllStudents());	
		}else{
			mav.addObject("students", sservice.findStudentsBySearch(value));	
		}
		ArrayList<Studentgrade> enrolStstus = gradeService.getStudentGradeByCourse(Integer.parseInt(courseId));
		mav.addObject("enrolStstus", enrolStstus);
		mav.addObject("courseId", courseId);
		return mav;
	}
	
	
}
