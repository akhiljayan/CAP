package edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.caps.model.Courseinfo;
import edu.iss.caps.model.Student;
import edu.iss.caps.model.Studentgrade;
import edu.iss.caps.model.User;
import edu.iss.caps.service.CourseinfoService;
import edu.iss.caps.service.StudentService;
import edu.iss.caps.service.StudentgradeService;
import edu.iss.caps.service.UserService;

@Controller
@RequestMapping(value = "/Student")
public class StudentController {
	
	@Autowired
	private UserService uservice;
	
	@Autowired
	private StudentgradeService gradeService;
	
	@Autowired
	private CourseinfoService courseService;
	
	@Autowired
	private StudentService sservice;
	
	public int getStudentId(HttpSession session){
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		return us.getGeneralID();
	}
	
	@RequestMapping(value = "/announcement", method = RequestMethod.GET)
	public String indexPage(Model model, HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		int id = us.getUser().getUserID();
		String role = us.getUser().getRoleID().getRole();
		User logedInUser = uservice.findOneById(id);
		if (logedInUser != null && us.getSessionId() != null) {
			return "adminPage/adminIndex";
		} else {
			return "noAccess";
		}
	}
	
	@RequestMapping(value = "/viewGrades", method = RequestMethod.GET)
	public ModelAndView ListStudentPage(HttpSession session) {
		int currentStudentId = this.getStudentId(session);
		ModelAndView mav = new ModelAndView("adminPage/studRole/grade-list");
		mav.addObject("gradelist", gradeService.findGradeBySid(currentStudentId));
		return mav;
	}
	
	@RequestMapping(value = "/viewCourses", method = RequestMethod.GET)
	public ModelAndView viewCourses(HttpSession session) {
		int currentStudentId = this.getStudentId(session);
		ModelAndView mav = new ModelAndView("adminPage/studRole/viewCourse");
		ArrayList<Courseinfo> clist = courseService.findAllActiveCourses();
		ArrayList<Studentgrade> sglist = gradeService.findGradeBySid(currentStudentId);
		mav.addObject("clist",clist);
		mav.addObject("sglist",sglist);
		return mav;
	}
	
	@RequestMapping(value = "/requestEnrolment", method = RequestMethod.GET)
	public ModelAndView requestEnrolment(HttpSession session) {
		int currentStudentId = this.getStudentId(session);
		ModelAndView mav = new ModelAndView("adminPage/studRole/requestEnrolment");
		ArrayList<Studentgrade> sglist = gradeService.findGradeBySid(currentStudentId);
		
		Student std = sservice.findOneStudent(currentStudentId);
		ArrayList<Courseinfo> cclist = courseService.findCourseForStudent(std);
		mav.addObject("clist",cclist);
		mav.addObject("sglist",sglist);
		mav.addObject("studId",currentStudentId);
		return mav;
	}
	
	@RequestMapping(value = "/student-request/{courseId}", method = RequestMethod.POST)
	public ModelAndView studentRequest(Model model, HttpSession session, @PathVariable String courseId) {
		int currentStudentId = this.getStudentId(session);
		Student stu = sservice.findOneStudent(currentStudentId);
		Courseinfo crs = courseService.findCourseinfo(Integer.parseInt(courseId));
		Studentgrade enrolment = new Studentgrade();
		ArrayList<Studentgrade> grades = gradeService.viewEnrolmentByCourseID(Integer.parseInt(courseId));
		enrolment.setCompletionStatus("Requested");
		enrolment.setCourseID(crs);
		enrolment.setEnrolledDate(new Date());
		enrolment.setStudentID(stu);
		if(crs.getMaxClassSize() < grades.size()){
			return null;
		}else{
			Studentgrade newEnr = gradeService.createEnrolment(enrolment);
			return new ModelAndView("adminPage/adminRole/enrolManage/enroleStudent");
		}
	}
	
	
}
